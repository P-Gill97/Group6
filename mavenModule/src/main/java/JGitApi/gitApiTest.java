package JGitApi;

import org.eclipse.jgit.api.errors.GitAPIException;

public class gitApiTest {
    public static void main(String[] args){
        String url = "";
        gitController Controller = new gitController();
        try {
            GitRepository GitRepo = new GitRepository(Controller.getRepo(url)); // calling GitRepository constructor.

            GitRepo.getCFiles();
            GitRepo.getJavaFiles();

            //Todo: add a for loop to display every item of the Cfiles array list and javaFiles array list.



        } catch (GitAPIException e) {
            e.printStackTrace();
        }

    }
}
