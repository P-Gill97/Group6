package JGitApi;

import java.io.File;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;

public class gitController {
    // directory where repos are saved for testing.
     private String fileDirectory = "/Users/pdippygill/desktop/DownloadedGitRepos";
    // CloneRepo repoClone =
    public File  getRepo(String url) throws GitAPIException {
        gitFile gitFileMaker= new gitFile();

        gitFileMaker.getRepo(url , fileDirectory);

        return null; // Need to add the rest of the function
    }

}
