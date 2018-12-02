/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Ludia
 */
public class DbBean {

    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    String jdbc_drivers = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/smesh?verifyServerCertificate=false&useSSL=true";

    //User login
    String user = "root";
    String password = "abcd";

    public void createCharacterTable() throws SQLException {
        // can't name table 'character' for some reason
        String stm = "CREATE TABLE IF NOT EXISTS characters ("
                + "ID int(11) NOT NULL UNIQUE,"
                + "Name varchar(45) NOT NULL,"
                + "Universe varchar(45) NOT NULL,"
                + "Description varchar(45) NOT NULL,"
                + "Debut varchar(45) NOT NULL,"
                + "Picture varchar(255) NOT NULL,"
                + "Youtube_Link varchar(255) NOT NULL,"
                + "PRIMARY KEY (ID))";
//                + "UNIQUE KEY 'ID_UNIQUE' (ID))";
        try {
            System.setProperty("jdbcDriver", jdbc_drivers);
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
            st.executeUpdate(stm);

        } catch (SQLException e) {
            System.out.println("An error has occured on Table Creation");
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public void createAttackTable() throws SQLException {
        String stm = "CREATE TABLE IF NOT EXISTS attack ("
                + "ID int(11) NOT NULL UNIQUE,"
                + "Name varchar(45) NOT NULL,"
                + "Description varchar(45) NOT NULL,"
                + "Animation_length varchar(45) NOT NULL,"
                + "Picture varchar(255) NOT NULL,"
                + "PRIMARY KEY (ID))";

        try {
            System.setProperty("jdbcDriver", jdbc_drivers);
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
            st.executeUpdate(stm);

        } catch (SQLException e) {
            System.out.println("An error has occured on Table Creation");
            e.printStackTrace();

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public void createStageTable() throws SQLException {
        String stm = "CREATE TABLE IF NOT EXISTS stage ("
                + "ID int(11) NOT NULL,"
                + "Name varchar(45) NOT NULL,"
                + "Universe varchar(45) NOT NULL,"
                + "Max_players varchar(45) NOT NULL,"
                + "Picture varchar(255) NOT NULL,"
                + "PRIMARY KEY (ID))";
        try {
            System.setProperty("jdbcDriver", jdbc_drivers);
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
            st.executeUpdate(stm);

        } catch (SQLException e) {
            System.out.println("An error has occured on Table Creation");
            e.printStackTrace();

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public void addCharacter(String ID, String name, String universe, String description, String debut, String picture, String youtube_link) throws ClassNotFoundException {

        try {

            Class.forName("com.mysql.jdbc.Driver");

            System.setProperty("jdbc.drivers", jdbc_drivers);
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();

            String sql = "INSERT INTO characters(ID, Name, Universe, Description, Debut, Picture, Youtube_Link) VALUES (?,?,?,?,?,?,?);";
            pst = con.prepareStatement(sql);
            pst.setString(1, ID);
            pst.setString(2, name);
            pst.setString(3, universe);
            pst.setString(4, description);
            pst.setString(5, debut);
            pst.setString(6, picture);
            pst.setString(7, youtube_link);

            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DbBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(DbBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void addAttack(String ID, String name, String description, String animation_length, String picture) throws ClassNotFoundException {

        try {

            Class.forName("com.mysql.jdbc.Driver");

            System.setProperty("jdbc.drivers", jdbc_drivers);
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();

            String sql = "INSERT INTO attack(ID, Name, Description, Animation_length, Picture) VALUES (?,?,?,?,?);";
            pst = con.prepareStatement(sql);
            pst.setString(1, ID);
            pst.setString(2, name);
            pst.setString(3, description);
            pst.setString(4, animation_length);
            pst.setString(5, picture);

            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DbBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(DbBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void addStage(String ID, String name, String universe, String max_players, String picture) throws ClassNotFoundException {

        try {

            Class.forName("com.mysql.jdbc.Driver");

            System.setProperty("jdbc.drivers", jdbc_drivers);
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();

            String sql = "INSERT INTO stage(ID, Name, Universe, Max_players, Picture) VALUES (?,?,?,?,?);";
            pst = con.prepareStatement(sql);
            pst.setString(1, ID);
            pst.setString(2, name);
            pst.setString(3, universe);
            pst.setString(4, max_players);
            pst.setString(5, picture);

            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DbBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(DbBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public ArrayList getCharacterDetails(String name) throws ClassNotFoundException {
        ArrayList characterDetails = new ArrayList();
        try {

            Class.forName("com.mysql.jdbc.Driver");

            System.setProperty("jdbc.drivers", jdbc_drivers);
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();

            String sql = "SELECT * FROM characters where Name = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, name);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                characterDetails.add(rs.getString("Name"));
                characterDetails.add(rs.getString("Universe"));
                characterDetails.add(rs.getString("Description"));
                characterDetails.add(rs.getString("Debut"));
                characterDetails.add(rs.getString("Picture"));
                characterDetails.add(rs.getString("Youtube_Link"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(DbBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(DbBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return characterDetails;
    }

    public ArrayList getAttackDetails(String name) throws ClassNotFoundException {
        ArrayList attackDetails = new ArrayList();
        try {

            Class.forName("com.mysql.jdbc.Driver");

            System.setProperty("jdbc.drivers", jdbc_drivers);
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();

            String sql = "SELECT * FROM attack where name = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, name);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                attackDetails.add(rs.getString("Name"));
                attackDetails.add(rs.getString("Description"));
                attackDetails.add(rs.getString("Animation_length"));
                attackDetails.add(rs.getString("Picture"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(DbBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return attackDetails;
    }

    public ArrayList getStageDetails(String name) throws ClassNotFoundException {
        ArrayList stageDetails = new ArrayList();
        try {

            Class.forName("com.mysql.jdbc.Driver");

            System.setProperty("jdbc.drivers", jdbc_drivers);
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();

            String sql = "SELECT * FROM stage where name = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, name);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                stageDetails.add(rs.getString("Name"));
                stageDetails.add(rs.getString("Universe"));
                stageDetails.add(rs.getString("Max_players"));
                stageDetails.add(rs.getString("Picture"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(DbBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return stageDetails;
    }

    public DefaultComboBoxModel buildAttackComboBoxModel() throws Exception {
        DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
        String SQL = "SELECT * from attack";
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                comboBoxModel.addElement(rs.getString(2));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                con.close();
            } catch (Exception e) {;
            }
        }
        return comboBoxModel;
    }

    public DefaultComboBoxModel buildStageComboBoxModel() throws Exception {
        DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
        String SQL = "SELECT * from stage";
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                comboBoxModel.addElement(rs.getString(2));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                con.close();
            } catch (Exception e) {;
            }
        }
        return comboBoxModel;
    }

    @SuppressWarnings("CallToThreadDumpStack")
    public DefaultTreeModel pop_tree() {
        DefaultTreeModel treeModel = null;

        try {

            try {
                con = DriverManager.getConnection(url, user, password);
                st = con.createStatement();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            ArrayList list = new ArrayList();
            list.add("Characters");
            String sql = "SELECT * from characters";

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Object value[] = {rs.getString(1)};
                list.add(value);
            }
            Object hierarchy[] = list.toArray();
            DefaultMutableTreeNode root = processHierarchy(hierarchy);

            treeModel = new DefaultTreeModel(root);

            return treeModel;
        } catch (Exception e) {
        }

        return treeModel;

    }

    @SuppressWarnings("CallToThreadDumpStack")
    public DefaultMutableTreeNode processHierarchy(Object[] hierarchy) {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(hierarchy[0]);
        try {
            int rows = 0;
            int i = 0;
            try {

                try {
                    con = DriverManager.getConnection(url, user, password);
                    st = con.createStatement();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                String sql = "SELECT * from characters";
                ResultSet rs = st.executeQuery(sql);

                while (rs.next()) {
                    rows = rs.getRow();
                }
                String names[] = new String[rows];
                ResultSet rs1 = st.executeQuery(sql);
                while (rs1.next()) {
                    names[i] = rs1.getString("Name");
                    i++;
                }
                DefaultMutableTreeNode child, grandchild;
                for (int childIndex = 0; childIndex < names.length; childIndex++) {
                    child = new DefaultMutableTreeNode(names[childIndex]);
                    node.add(child);
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } catch (Exception e) {
        }

        return (node);
    }

}
