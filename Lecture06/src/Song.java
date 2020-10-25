// Implement leaf class

public class Song implements IComponent{
    public String songName;
    public String artist;
    public float speed = 1; // Default playback speed

    public Song(String songName, String artist){
        this.songName = songName;
        this.artist = artist;
    }

    public String getArtist(){
        return this.artist;
    }

    // Implement Component methods
    public String getName(){
        return this.songName;
    }

    public void play(){
        System.out.println("Current song:" + this.songName);
    }

    public void setPlaybackSpeed(float speed){
        this.speed = speed;
    }
}
