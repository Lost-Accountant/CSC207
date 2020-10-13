/**
 * Created by lindseyshorser on 2018-05-10.
 */

import java.util.ArrayList;

public class Game {

    private String id;
    private ArrayList<Player> players;

    public Game(String id){
        this.id = id;
        this.players = new ArrayList();
    }

    public String getId() {
        return this.id;
    }

    public ArrayList<Player> getPlayers(){
        return this.players;
    }

    public boolean hasPlayer(Player p) {
        return this.players.contains(p);
    }

    public boolean equals(Game g2){
        return (this.id == g2.id && this.players == g2.players);
    }

    public int size(){
        return this.players.size();
    }

    public void addPlayer(Player p){
        this.players.add(p);
    }

    public boolean hasSamePlayers(Game g2){
        for(int i = 0; i != this.players.size(); i++){
            if (g2.hasPlayer(this.players.get(i))) {
                return true;
            }
        }
        return false;
    }

    public String toString(){
        return "";
    }

}
