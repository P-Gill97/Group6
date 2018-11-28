package JGitApi;


import org.eclipse.jgit.api.Git;

public class gitController {
   // CloneRepo repoClone =
    public GitRepository getRepo(String url){

        CloneRepo cr = new CloneRepo();
        Git repo = cr.clone(url);

        return null; // Need to add the rest of the function
    }

}
