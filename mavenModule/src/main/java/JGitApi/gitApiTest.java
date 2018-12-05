package JGitApi;

import org.eclipse.jgit.api.errors.GitAPIException;

import java.io.File;
import java.util.ArrayList;

public class gitApiTest {
    public static void main(String[] args) {
        String url = "https://github.com/CSC131Fall2018/Group6";
        gitController Controller = new gitController();
        try {
            ArrayList<File> Arraylistoffiles = Controller.getRepo(url);
        } catch (GitAPIException e) {
            e.printStackTrace();
        }

    }
}
