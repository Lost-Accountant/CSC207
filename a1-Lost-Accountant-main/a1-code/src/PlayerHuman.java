import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TODO: Add Javadoc comments for this class and all its methods. (Task 3)
public class PlayerHuman {
	
	private static final String INVALID_INPUT_MESSAGE = "Invalid number, please enter 1-8";
	private static final String IO_ERROR_MESSAGE = "I/O Error";
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

	private Othello othello;
	private char player;

	/**
	 * Cpmstrict a PlayerHuman player with the given symbol and Othello game.
	 * @param othello the Othello game this player is in
	 * @param player the symbol of this player
	 */
	public PlayerHuman(Othello othello, char player) {
		
		this.othello = othello;
		this.player = player;
	}

	/**
	 * Returns and activates the move based on given coordinates.
	 * @return the move desired by the player
	 */
	public Move getMove() {
		
		int row = getMove("row: ");
		int col = getMove("col: ");
		return new Move(row, col);
	}

	/**
	 * Return the desired row number or column number from the player for their move
	 * @param message the row or column indication for input
	 * @return the row or column number of player's move
	 */
	private int getMove(String message) {
		
		int move, lower = 0, upper = 7;
		while (true) {
			try {
				System.out.print(message);
				String line = PlayerHuman.stdin.readLine();
				move = Integer.parseInt(line);
				if (lower <= move && move <= upper) {
					return move;
				} else {
					System.out.println(INVALID_INPUT_MESSAGE);
				}
			} catch (IOException e) {
				System.out.println(INVALID_INPUT_MESSAGE);
				break;
			} catch (NumberFormatException e) {
				System.out.println(INVALID_INPUT_MESSAGE);
			}
		}
		return -1;
	}
}
