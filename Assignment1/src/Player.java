/**
 * Created by lindseyshorser on 2018-05-10.
 */

import java.util.ArrayList;

public class Player {

    private String name;
    private int rank;
    private ArrayList<Game> games;

    public Player(String name, int rank){
        this.name = name;
        this.rank = rank;
        this.games = new ArrayList<Game>();
    }

    public String getName(){
        return(this.name);
    }

    public int getRank(){
        return (this.rank);
    }

    public void addGame(Game g){
        this.games.add(g);
        g.addPlayer(this);
    }

    public ArrayList<Game> getGames(){
        return this.games;
    }

    public boolean equals(Player p2){
        return this.name == p2.name &&
                this.rank == p2.rank;
    }

    public String toString() {
        if (this.games.size() == 0) {
            return (this.name.toString() + ", " + this.rank);
        } else {
            String temp = this.getName() + ", " + this.getRank();
            for (int i = 0; i != this.games.size(); i++){
                temp += System.lineSeparator() + this.games.get(i).getId();
            }
            return temp;
        }
    }

}
