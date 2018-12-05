package JGitApi;

import java.io.File;
import java.util.ArrayList;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;

/*
contributor: Perry Gill
Purpose:  This is the controller class
that the metrics part of the app can call.
 */
//NOT FINISHED.
public class gitController {
    // directory where repos are saved for testing.
    //TODO: If YOU WANT TO RUN ON YOUR COMPUTER CHANGE THE FILE PATH TO SOME RANDOM FOLDER OR DESKTOP .

    private String filePath = "/Users/pdippygill/desktop/DownloadedGitRepos";

    public ArrayList<File> getRepo(String url) throws GitAPIException {

        gitFile gitFileMaker = new gitFile();
        File repo = gitFileMaker.getRepo(url, filePath);

        GitRepository Repository = new GitRepository(repo);
        Repository.getFiles(Repository.filesTolook(Repository.getRepo()));
        return Repository.arrayListOfFiles;
    }

}
