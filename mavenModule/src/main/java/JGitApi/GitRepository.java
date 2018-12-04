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
    private ArrayList<File> allFIles;         //= new ArrayList<>();

    public GitRepository ( File repo) throws GitAPIException {

        this.repo = repo;

}
    FilenameFilter  nameFilter = new FilenameFilter() {
        @Override
        public boolean accept(File dir, String name) {
            if(name.endsWith(".java")||name.endsWith(".c")||name.endsWith("."))
            return false;
        }

    }
    public ArrayList<File> getFiles (){
        //Todo: need to add get java files from repo directory by using the extention


    }


}
