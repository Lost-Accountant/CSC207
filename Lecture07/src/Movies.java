// Dependency injection pattern

import java.util.List;

public class Movies {
    private MovieFinder finder;

    public Movies(){};

    public void setFinder(MovieFinder finder){
        // allow us to change underlying algorithm easily
        this.finder = finder;
    }

    public List<Movie> moviesDirectedBy(String director){
        List<Movie> allMovies = finder.findAll();

        for (Movie m: allMovies){
            if (!m.getDirector().equals(director)){
                allMovies.remove(m);
            }
        }
        return allMovies;
    }
}
