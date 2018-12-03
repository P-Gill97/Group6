package JGitApi;
import org.eclipse.jgit.api.errors.GitAPIException;

import java.io.File;
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

       return javaFiles;
    }
}
