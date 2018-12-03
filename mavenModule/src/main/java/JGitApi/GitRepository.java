package JGitApi;
import org.eclipse.jgit.api.errors.GitAPIException;

import java.io.File;
import java.util.ArrayList;
public class GitRepository {
    private File repo;
    private ArrayList<File> fileList = new ArrayList<>();

    public GitRepository ( File repo) throws GitAPIException {

        this.repo = repo;

    }

}
