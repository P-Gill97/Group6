package JGitApi;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.util.FileUtils;

import java.io.FilenameFilter;
import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.Collection;

/*
contributor: Perry Gill
Purpose: To Have an object of repository that holds the repo file and containts all the functions
needed to get the files needed from the repo. This will be called in the controller class
that the metrics part of the app can call.
 */
public class GitRepository {
    private File repo;


    public GitRepository ( File repo) throws GitAPIException {

        this.repo = repo;

}
    FilenameFilter  nameFilter = new FilenameFilter() {
        @Override
        public boolean accept(File dir, String name) {
            if(name.endsWith(".java")||name.endsWith(".c")||name.endsWith(".h")
                    ||name.endsWith(".cpp")||name.endsWith(".hpp")){
                return true;
            }else {
                return false;
            }
        }

    };
    public File[] getFiles (){
        File[] files = repo.listFiles(nameFilter);


        return files;
    }


}
