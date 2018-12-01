package FinalProject;

import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

//        Model m = new Model();

        
        View v = new View();
        
        v.setVisible(true);
        v.setVideo("https://www.youtube.com/watch_popup?v=GKiHB5AzihE&t=150s");
        
//        m.setupDatabase();
//        
//        
//        new Controller().init(v, m);
    }
}
