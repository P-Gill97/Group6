package JGitApi;

import org.eclipse.jgit.api.errors.GitAPIException;

import java.io.File;
/*
 *  Programmer : Perry Gill
 *  purpose : to turn git object into a repository file.
 *
 *
 *  */
public class gitFile
{
    public File getRepo(String link, String location) throws GitAPIException {
      File file = new File (location); // Math for mac chance this path to a path in your computer.
        CloneRepo cloneFile = null;
        cloneFile.clone(link,file);

        return file;
    }
}