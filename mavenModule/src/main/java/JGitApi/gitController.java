package JGitApi;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Comparator;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;

/*
contributor: Perry Gill
Purpose:  This is the controller class
that the metrics part of the app can call.
Refrences: https://softwarecave.org/2018/03/24/delete-directory-with-contents-in-java/
i used this source for help with the deletion algorithm.
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
    public void deleteDirectory(){
        Path path = Paths.get(this.filePath) ;
        try {
            Files.walk(path)
                    .sorted(Comparator.reverseOrder())
                    .map(Path::toFile)
                    .forEach(File::delete);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
