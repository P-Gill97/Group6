package JGitApi;

import org.eclipse.jgit.api.errors.GitAPIException;

import java.io.FilenameFilter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/*
contributor: Perry Gill
Purpose: To Have an object of repository that holds the repo file and containts all the functions
needed to get the files needed from the repo. This will be called in the controller class
that the metrics part of the app can call.
Refrences : https://stackoverflow.com/questions/2056221/recursively-list-files-in-java
 */
public class GitRepository {
    private File repo;


    public GitRepository(File repo) throws GitAPIException {

        this.repo = repo;

    }

    FilenameFilter nameFilter = new FilenameFilter() {
        @Override
        public boolean accept(File dir, String name) {
            if (name.endsWith(".java") || name.endsWith(".c") || name.endsWith(".h")
                    || name.endsWith(".cpp") || name.endsWith(".hpp")) {
                return true;
            } else {
                return false;
            }
        }

    };
    /*
     recursively get files and filter files that are not desired files.
     Takes in a Arraylist<File>
     returns an Arraylist<File>
     that has all the java and C files.
      */

    public ArrayList<File> getFiles(ArrayList<File> emptyArrayList) {

        File[] files = repo.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                // stack overflow error incoming.
                getFiles(emptyArrayList);

            } else {
                if (nameFilter.accept(file, file.getName())) {

                    emptyArrayList.add(file);
                }
            }

        }
        return emptyArrayList;
    }


}




