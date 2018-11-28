package JGitApi;


public class gitController {
   // CloneRepo repoClone =
    public GitRepository enterURL(String url){

        CloneRepo cr = new CloneRepo();
        cr.clone(url);

        return null; // Need to add the rest of the function
    }

}
