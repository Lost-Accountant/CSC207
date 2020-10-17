import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
                        System.out.println("not exist");
                    } else { // if has game already
                        System.out.println("exist");
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
