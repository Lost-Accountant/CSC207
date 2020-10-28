// Dependency injection pattern

public class Movie {
    private String director;

    public Movie(String director){
        this.director = director;
    }

    public String getDirector(){
        return director;
    }
}
