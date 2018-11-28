package JGitApi;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import java.io.File;
import java.io.IOException;
/*
*  Programmer : Perry Gill
*  purpose : TO clone a repository
*
*
*  */
public class CloneRepo {




    public Git clone(String uri)    {
        File localPath = null;
        try {
            localPath = File.createTempFile("GitRepo","");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Git cloneResult = Git.cloneRepository()
                .setURI(uri)
                .setDirectory(localPath)
                .call();
           return cloneResult ;
        } catch (GitAPIException e) {
            e.printStackTrace();
        }

        return null;
    }

}
