import org.eclipse.jgit.api.errors.GitAPIException;

import java.sql.SQLException;
import java.util.ArrayList;

public class retMets {


    public static ArrayList<String> getMetrics(String URL) throws ClassNotFoundException, SQLException, InstantiationException, GitAPIException, IllegalAccessException {
        Metrics m= new Metrics();
        String[] pass =new String[1];
        pass[0]=URL;
        return m.runzit(URL,pass);
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException, InstantiationException, GitAPIException, IllegalAccessException {
        ArrayList grab = getMetrics("https://github.com/Jovanyp23/WordCountProject");
        System.out.println("Date: "+grab.get(0)+"  URL:"+grab.get(1)+"  Lines:"+grab.get(2));

    }
}
