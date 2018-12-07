import org.eclipse.jgit.api.errors.GitAPIException;

import java.sql.SQLException;
import java.util.ArrayList;

public class retMets {


    public static ArrayList<String> getMetrics(String URL) throws ClassNotFoundException, SQLException, InstantiationException, GitAPIException, IllegalAccessException {
        Metrics m= new Metrics();
        String[] pass =new String[1];
        pass[0]=URL;
        return m.returnMetrics(pass[0]);
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException, InstantiationException, GitAPIException, IllegalAccessException {
        System.out.println("Why");
        ArrayList<String> grab = getMetrics("https://github.com/Jovanyp23/WordCountProject");
        System.out.println("is this working");
        System.out.println(grab.get(0)+" "+grab.get(1));

    }
}
