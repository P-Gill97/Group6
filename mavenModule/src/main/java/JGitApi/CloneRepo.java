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




    public File clone(String uri, File file)    {

        // try to get repository
        try {
            Git cloneResult = Git.cloneRepository()
                .setURI(uri)
                .setDirectory(file)
                .call();
        return file;
        } catch (GitAPIException e) {
            e.printStackTrace();
        }


        return null; // this should never happen.
    }

}
