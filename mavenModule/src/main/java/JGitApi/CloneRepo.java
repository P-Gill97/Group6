package JGitApi;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import java.io.File;

/*
*  Programmer : Perry Gill
*  purpose : TO clone a repository
*
*
*  */
public class CloneRepo {




    public void clone(String uri, File file)    {

        // try to get repository
        try {
            Git cloneResult = Git.cloneRepository()
                .setURI(uri)
                .setDirectory(file)
                .call();

        } catch (GitAPIException e) {
            e.printStackTrace();
        }



    }

}
