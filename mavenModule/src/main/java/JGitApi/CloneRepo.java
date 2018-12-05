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


    public void clone(String uri, File file) throws GitAPIException {

        // try to get repository

        Git cloneResult = Git.cloneRepository()
                .setURI(uri)
                .setDirectory(file)
                .call();


    }

}
