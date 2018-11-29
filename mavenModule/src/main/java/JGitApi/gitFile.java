package JGitApi;

import java.io.File;
/*
 *  Programmer : Perry Gill
 *  purpose : to turn git object into a repository file.
 *
 *
 *  */
public class gitFile
{
    public File getRepo(String link){
      File file = new File("/Users/pdippygill/desktop"); // Math for mac chance this path to a path in your computer.
        CloneRepo cloneFile = null;
        cloneFile.clone(link,file);

        return file;
    }
}