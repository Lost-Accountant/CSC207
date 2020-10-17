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

    public boolean contains(Game g){
        for (int i = 0; i != g.size(); i++){
            if (!this.hasPlayer(g.players.get(i))){
                return false;
            }
        }
        return true;
    }

    public boolean equals(Game g2){
        return (this.id.equals(g2.id));
    }

    public int size(){
        return this.players.size();
    }

    public void addPlayer(Player p){
        this.players.add(p);
        if (!p.getGames().contains(this)){
            p.addGame(this);
        }
    }

    public boolean hasSamePlayers(Game g2){
        if (this.size() != 0 && g2.size() != 0){
            for (int i = 0; i != this.size(); i++){
                if (g2.hasPlayer(this.getPlayers().get(i))){
                    return true;
                }
            }
        }
        return false;
    }

    public String toString(){
        if (this.players.size() != 0) {
            String players = this.players.get(0).getName();
            for (int i = 1; i != this.players.size(); i++) {
                players += "," + this.players.get(i).getName();
            }
            return (this.getId() + " (" + players + ")");
        } else {
            return (this.getId() + " ()");
        }
    }

}
