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
                String[] playerInfo = separated[0].replaceAll("\\s+","").split("\\,");

                // construct player
                Player newPlayer = new Player(playerInfo[0], Integer.valueOf(playerInfo[1]));
                allPlayers.add(newPlayer);

                // each game in a player's line
                for (int i = 1; i < separated.length; i++){
                    // game ID not in record
                    if (!hasGame(separated[i].trim(), allGames)){
                        // construct game
                        Game newGame = new Game(separated[i].trim());
                        // add player to new game
                        newGame.addPlayer(newPlayer);
                        allGames.add(newGame);
                    } else { // game ID in record
                        Game existingGame = getGame(separated[i].trim(), allGames);
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

    // can rewrite all following methods since game.equals only test ID.

    public static ArrayList<String> getGamesId(ArrayList<Game> allGames){
        ArrayList<String> allGamesID = new ArrayList<String>();
        for (int i = 0; i < allGames.size(); i++){
            allGamesID.add(allGames.get(i).getId());
        }
        return allGamesID;
    }

    public static boolean hasGame(String gameID, ArrayList<Game> allGames){
        return (getGamesId(allGames).contains(gameID));
    }

    public static Game getGame(String gameID, ArrayList<Game> allGames){
        // assume hasGame is true
        int i = 0;
        Game returnedGame = allGames.get(i);
        while (gameID != returnedGame.getId()){
            i += 1;
            returnedGame = allGames.get(i);
        }
        return returnedGame;
    }
}
