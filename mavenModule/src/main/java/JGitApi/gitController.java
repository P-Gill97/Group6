package JGitApi;

import java.io.File;
import org.eclipse.jgit.api.Git;

public class gitController {

   // CloneRepo repoClone =
    public File  getRepo(String url){
        gitFile gitFileMaker= new gitFile();

        gitFileMaker.getRepo(url);

        return null; // Need to add the rest of the function
    }

}
