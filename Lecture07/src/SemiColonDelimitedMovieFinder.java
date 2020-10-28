// Dependency injection pattern

import java.util.List;

public class SemiColonDelimitedMovieFinder implements MovieFinder{
    private String filename;

    public void setFilename(String filename){
        this.filename = filename;
    }

    public List<Movie> findAll(){
        // when file stores movie names separated by semi colon.
        // implement an algorithm to do the job
        // Movie class might change which requires different formatting
        return null;
    }
}
