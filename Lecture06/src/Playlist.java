// Implement Composite Class

import java.util.ArrayList;

public class Playlist implements IComponent{
    public String playlistName;
    public ArrayList<IComponent> playlist = new ArrayList();

    public Playlist(String playlistName){
        this.playlistName = playlistName;
    }

    // implement interface methods
    public void play(){
        System.out.println("Playlist" + this.playlistName + "is being played");
    }

    public void setPlaybackSpeed(float speed){
        for (int i = 0; i < this.playlist.size(); i++){
            this.playlist.get(i).setPlaybackSpeed(speed);
        }
    }

    public String getName(){
        return this.playlistName;
    }

    // create methods to Add Composite class
    public void add(IComponent component){
        this.playlist.add(component);
    }

    public void remove(IComponent component){
        this.playlist.remove(component);
    }
}
