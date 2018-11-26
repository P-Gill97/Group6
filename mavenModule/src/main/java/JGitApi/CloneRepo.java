package JGitApi;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import java.io.File;
import java.io.IOException;

public class CloneRepo {




    public void clone(String uri) throws IOException , GitAPIException {
        File localPath = File.createTempFile("GitRepo","");
         Git cloneResult = Git.cloneRepository()
            .setURI(uri)
            .setDirectory(localPath)
            .call();
    }

}
