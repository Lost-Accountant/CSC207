import java.io.*;
import java.util.ArrayList;


/**
 * Created by lindseyshorser on 2018-05-10.
 */
public class Tournament {

    public static void main(String[] args) throws IOException {
        // collection of players and game
        ArrayList<Game> allGames = new ArrayList<Game>();
        ArrayList<Player> allPlayers = new ArrayList<Player>();

        // Specify filename
        String fileName = "Assignment1/PlayerList.txt";

        // Open file for reading
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            // Read the first line
            String line = fileReader.readLine();
            while (line != null) {
                // separate players and games
                String[] separated = line.split("\\|");
                String[] playerInfo = separated[0].split("\\,");

                // construct player
                Player newPlayer = new Player(playerInfo[0].trim(), Integer.valueOf(playerInfo[1].trim()));
                allPlayers.add(newPlayer);

                // each game in a player's line
                for (int i = 1; i < separated.length; i++){
                    String currentGameID = separated[i].trim();
                    // check whether game already in list
                    // if not, add it
                    if (!hasGame(currentGameID, allGames)){
                        Game newGame = new Game(currentGameID);
                        newGame.addPlayer(newPlayer);
                        allGames.add(newGame);
                    } else { // if has game already
                        Game existingGame = getGame(currentGameID, allGames);
                        existingGame.addPlayer(newPlayer);
                    }
                }
                // next line
                line = fileReader.readLine();
            }
        }
        System.out.println(allGames);
        System.out.println(allPlayers);

        // user interaction
        try (BufferedReader keyboard = new BufferedReader((new InputStreamReader(System.in)))){
            // Get the first name of an output file from standard input.
            System.out.print("Enter the name of the game. Type 'exit' if want to exit");
            String gameName = keyboard.readLine();

            // only stop when typed exit
            while (!gameName.equals("exit")){
                // has this game
                if (hasGame(gameName, allGames)){
                    System.out.println(getGame(gameName, allGames).toString());
                } else {
                    System.out.println("This game does not exist");
                }
                System.out.print("Enter the name of the game. Type 'exit' if want to exit");
                gameName = keyboard.readLine();
            }
        }
    }

    public static boolean hasGame(String gameID, ArrayList<Game> allGames){
        Game tempGame = new Game(gameID);
        for (int i = 0; i < allGames.size(); i++){
            if (tempGame.equals(allGames.get(i))){
                return true;
            }
        }
        return false; // if no return true
    }

    public static Game getGame(String gameID, ArrayList<Game> allGames){
        for (int i = 0; i < allGames.size(); i++){
            Game returnedGame = allGames.get(i);
            if (returnedGame.getId().equals(gameID)){
                return returnedGame;
            }
        }
        return null;
    }
}
