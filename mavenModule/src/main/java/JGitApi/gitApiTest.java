package JGitApi;

import org.eclipse.jgit.api.errors.GitAPIException;

import java.io.File;
import java.util.ArrayList;

public class gitApiTest {
    public static void main(String[] args){
        String url = "";
        gitController Controller = new gitController();
        try {
            GitRepository GitRepo = new GitRepository(Controller.getRepo(url)); // calling GitRepository constructor.




            //Todo: add a for loop to display every item of the TestCfiles array list and testjavaFiles array list.



        } catch (GitAPIException e) {
            e.printStackTrace();
        }

    }
}
