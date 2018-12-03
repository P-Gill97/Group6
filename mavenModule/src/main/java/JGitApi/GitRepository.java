package JGitApi;
import org.eclipse.jgit.api.errors.GitAPIException;
import java.io.FilenameFilter;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
/*
contributor: Perry Gill
Purpose: To Have an object of repository that holds the repo file and containts all the functions
needed to get the files needed from the repo. This will be called in the controller class
that the metrics part of the app can call.
 */
public class GitRepository {
    private File repo;
    private ArrayList<File> Cfiles;         //= new ArrayList<>();
    private ArrayList<File> javaFiles;      //= new ArrayList<>(); might not need to initaialize
    public GitRepository ( File repo) throws GitAPIException {

        this.repo = repo;

}
    public ArrayList<File> getJavaFiles (){
        //Todo: need to add get java files from repo directory by using the extention

       return javaFiles;
    }

    public ArrayList<File> getCFiles (){
        //Todo: need to add get C files from repo directory by using the extention
        return Cfiles;
    }
}
