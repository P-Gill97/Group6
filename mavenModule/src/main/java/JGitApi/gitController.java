package JGitApi;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.util.FileUtils;

/*
contributor: Perry Gill
Purpose:  This is the controller class
that the metrics part of the app can call.
Refrences: https://softwarecave.org/2018/03/24/delete-directory-with-contents-in-java/
i used this source for help with the deletion algorithm.
NOTE TO USER: After you get the repofiles call deleteDirectory() function
 */

public class gitController {
    // directory where repos are saved for testing.
    //TODO: If YOU WANT TO RUN ON YOUR COMPUTER CHANGE THE FILE PATH TO SOME RANDOM FOLDER OR DESKTOP .

    //Original line of code//private String filePath = "/Users/pdippygill/desktop/DownloadedGitRepos";

    private String filePath = "currentMetricsPath";

    public ArrayList<File> getRepo(String url) throws GitAPIException {
        gitFile gitFileMaker = new gitFile();
        Random rand = new Random();
        File repo = gitFileMaker.getRepo(url, filePath + Integer.toString(rand.nextInt()));

        GitRepository Repository = new GitRepository(repo);
        Repository.getFiles(Repository.filesTolook(Repository.getRepo()));

        return Repository.arrayListOfFiles;
    }

    public void deleteDirectory() {
        //Path path = Paths.get(this.filePath);
        /*try {
            Files.walk(path)
                    .sorted(Comparator.reverseOrder())
                    .map(Path::toFile)
                    .forEach(File::delete);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

    }
}
