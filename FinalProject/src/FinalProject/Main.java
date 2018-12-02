package FinalProject;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, Exception {
        View view = new View();
        Model model = new Model();
        
        new Controller().init(view, model);

    }
}
