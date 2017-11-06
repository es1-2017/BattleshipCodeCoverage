/**
 * 
 */
package battleship;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * @author adrianolopes
 * 
 * PS: Thanks to Miguel Goulão for his earlier contribution 
 *
 */
public class Main {
	
	/**
	 * Strings to be used by the player
	 */
	private static final String DESISTIR = "desisto";
	private static final String RAJADA = "rajada";
	private static final String NOVAFROTA = "nova";
	private static final String BARCA = "barca";
	private static final String CARAVELA = "caravela";
	private static final String NAU = "nau";
	private static final String FRAGATA = "fragata";
	private static final String GALEAO = "galeao";
	private static final String VERTIROS = "ver";
	private static final String BATOTA = "mapa";
	private static final String STATUS = "estado";
	private static final int FULLFLEET = IFleet.SQUAREGRIDSIZE;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("***  Battleship  ***");
		// taskA();
		// taskB();
		// taskC();
		// taskD();

	}

	/**
	 * This task tests the building up of ships: For each ship, reads positions 
	 * and indicates whether the ship occupies each one of such positions or not
	 */
	public static void taskA() {
		Scanner in = new Scanner (System.in);
		while (in.hasNext()) {
			Ship s = readShip(in);
			for (int i = 0; i < 3; i++) {
				Position p = readPosition(in);
				System.out.println(p.toString()+ " " + s.occupies(p));
			}
		}
	}
	
	/**
	 * This task tests the building up of fleets
	 */
	public static void taskB() {
		Scanner in = new Scanner (System.in);
		IFleet fleet = null;
		String command = in.next();
		while (!command.equals(DESISTIR)) {
			if (command.equals(NOVAFROTA)) {
				fleet = buildFleet(in, FULLFLEET);
			} else if (command.equals(STATUS)) {
				printStatus(fleet);
			}
			// The other commands are unknown in this task
			command = in.next();
		}
		System.out.println("Bons ventos!");
	}
	
	/**
	 * This task tests the building up of fleets and takes into 
	 * consideration the possibility of cheating
	 */
	public static void taskC() {
		Scanner in = new Scanner (System.in);
		IFleet fleet = null;
		String command = in.next();
		while (!command.equals(DESISTIR)) {
			if (command.equals(NOVAFROTA)) {
				fleet = buildFleet(in, FULLFLEET);
			} else if (command.equals(STATUS)) {
				printStatus(fleet);
			} else if (command.equals(BATOTA)) {
				System.out.println(fleet.toString());
			}
			// The other commands are unknown in this task
			command = in.next();
		}
		System.out.println("Bons ventos!");
	}
	
	/**
	 * This task also tests the fighting element of a round of three shots
	 */
	public static void taskD() {
		Scanner in = new Scanner (System.in);
		IFleet fleet = null;
		IGame game = null;
		String command = in.next();
		while (!command.equals(DESISTIR)) {
			if (command.equals(NOVAFROTA)) {
				fleet = buildFleet(in, FULLFLEET);
				game = new Game(fleet);
			} else if (command.equals(STATUS)) {
				printStatus(fleet);
			} else if (command.equals(BATOTA)) {
				printFleet(fleet);
			} else if (command.equals(RAJADA)) {
				firingRound(in, game);
				System.out.println("Hits: " + game.getHits() +
						" Inv: " + game.getInvalidShots() + " Rep: " + game.getRepeatedShots() + " Restam " + game.getRemainingShips() + " navios.");
				if (game.getRemainingShips() == 0)
					System.out.println("Maldito sejas, Java Sparrow, eu voltar-glub glub glub...");
			} else if (command.equals(VERTIROS)) {
				printAllValidShots(game);
			}
			command = in.next();
		}
		System.out.println("Bons ventos!");
	}
	
	/**
	 * This operation shows the state of a fleet
	 * @param fleet The fleet to be shown
	 */
	private static void printStatus(IFleet fleet) {
		printAllShips(fleet);
		printFloatingShips(fleet);
		printShipsByCategory(fleet, "Galeao");
		printShipsByCategory(fleet, "Fragata");
		printShipsByCategory(fleet, "Nau");
		printShipsByCategory(fleet, "Caravela");
		printShipsByCategory(fleet, "Barca");
	}

	/**
	 * This operation prints all the given ships
	 * @param ships The list of ships
	 */
	private static void printShips(List<IShip> ships) {
		for (IShip ship : ships) {
			System.out.print(ship);
		}
		System.out.println();
	}
	
	/**
	 * This operation prints all the ships of a fleet
	 * @param fleet The fleet of ships
	 */
	public static void printAllShips(IFleet fleet) {
		List<IShip> ships = fleet.listAllShips();
		printShips(ships);
	}
	
	/**
	 * This operation prints all the ships of a fleet but not yet shot
	 * @param fleet The fleet of ships
	 */
	public static void printFloatingShips(IFleet fleet) {
		List<IShip> ships  = fleet.listFloatingShips();
		printShips(ships);
	}
	
	/**
	 * This operation prints all the ships of a fleet belonging to
	 * a particular category
	 * @param fleet The fleet of ships
	 * @param category The category of ships of interest
	 */
	public static void printShipsByCategory(IFleet fleet, String category) {
		List<IShip> ships  = fleet.listShipsLike(category);
		printShips(ships);
		
	}

	/**
	 * This operation allows the build up of a fleet, given user data
	 * @param in The scanner to read from
	 * @param n The number of ships of the wanted fleet
	 * @return The fleet that has been built
	 */
	public static IFleet buildFleet(Scanner in, int n) {
		IFleet fleet = new Fleet();
		int i = 0; // i represents the total of successfully created ships
		while (i <= n) {
			IShip s = readShip(in);
			if (s != null) {
				boolean success = fleet.addShip(s);
				if (success)
					i++;
				else
					System.out.println("Falha na criacao de " + s.getCategory() + " " + s.getBearing() + " " + s.getPosition());	
			}
			else {
				System.out.println("Navio desconhecido!");
			}
		}
		System.out.println(i + " navios adicionados com sucesso!");
		return fleet;
	}
	
	/**
	 * This operation reads data about a ship, build it and returns it
	 * @param in The scanner to read from
	 * @return The created ship based on the data that has been read
	 */
	private static Ship readShip(Scanner in) {
		String shipKind = in.next();
		Position pos = readPosition(in);
		char c = in.next().charAt(0);
		Compass bearing = charToCompass(c);
		return buildShip(shipKind, bearing, pos);
	}
	
	private static Compass charToCompass(char ch) {
		Compass bearing;
		switch (ch) {
		case 'n':
			bearing = Compass.NORTH;
			break;
		case 's':
			bearing = Compass.SOUTH;
			break;
		case 'e':
			bearing = Compass.EAST;
			break;
		case 'o':
			bearing = Compass.WEST;
			break;
		default: // Never happens unless input error
			bearing = Compass.NORTH;
			break;	
		}
		
		return bearing;
	}
	
	private static Ship buildShip(String shipKind, Compass bearing, Position pos) {
		Ship sh;
		if (shipKind.equals(BARCA))
			sh = new Barge(bearing, pos); 
		else if (shipKind.equals(CARAVELA))
			sh = new Caravel(bearing, pos);
		else if (shipKind.equals(NAU))
			sh = new Carrack(bearing, pos);
		else if (shipKind.equals(FRAGATA))
			sh = new Frigate(bearing, pos);
		else if (shipKind.equals(GALEAO))
			sh = new Galleon(bearing, pos);
		else
			sh = null;
		return sh;
	}
	
	/**
	 * This operation allows reading a position in the map
	 * @param in The scanner to read from
	 * @return The position that has been read
	 */
	private static Position readPosition(Scanner in) {
		int row = in.nextInt();
		int column = in.nextInt();
		return new Position(row, column);
	}
	
	/**
	 * This operation allows firing a round of shots (three) over a fleet, 
	 * in the context of a game
	 * @param in The scanner to read from
	 * @param game The context game while fleet is being attacked
	 */
	public static void firingRound(Scanner in, IGame game) {
		for (int i = 0; i < 3; i++) {
			IPosition pos = readPosition(in);
			IShip sh = game.fire(pos);
			if (sh != null)
				System.out.println("Mas... mas... " + sh.getCategory() + "s nao sao a prova de bala? :-(");
		}
		
	}
	
	/**
	 * This operation prints a map showing valid shots that have been fired
	 * @param game The context game while shots have been fired
	 */
	public static void printAllValidShots(IGame game) {
		char[][] map = new char[FULLFLEET][FULLFLEET];
		for (int r = 0; r < FULLFLEET; r++)
			for (int c = 0; c < FULLFLEET; c++)
				map[r][c]='.';
		
		for (IPosition pos : game.getShots()) {
			map[pos.getRow()][pos.getColumn()] = 'X';
		}
		
		for (int row = 0; row < FULLFLEET; row++) {
			for (int col = 0; col < FULLFLEET; col++)
				System.out.print(map[row][col]);
			System.out.println();
		}
		
	}
	
	/**
	 * This operation prints a map showing the fleet
	 * @param fleet The fleet to be shown
	 */
	private static void printFleet(IFleet fleet) {	
		char[][] map = new char[FULLFLEET][FULLFLEET];
		for (int r = 0; r < FULLFLEET; r++)
			for (int c = 0; c < FULLFLEET; c++)
				map[r][c]='.';
		
		for (IShip sh : fleet.listAllShips()) {
			Iterator<IPosition> it = sh.getPositions();
			while (it.hasNext()) {
				IPosition pos = it.next();
				map[pos.getRow()][pos.getColumn()] = '#';
			}
			
		}
		
		for (int row = 0; row < FULLFLEET; row++) {
			for (int col = 0; col < FULLFLEET; col++)
				System.out.print(map[row][col]);
			System.out.println();
		}

	}
}
