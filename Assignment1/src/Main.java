import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String [] args) throws IOException{
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



                // next line
                line = fileReader.readLine();
            }
        }
        System.out.println(allGames);
        System.out.println(allPlayers);

        // user interaction
    }
}
