/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Ludia
 */
public class Model {

    DbBean db = new DbBean();

    public void setupDatabase() throws SQLException {
        db.createCharacterTable();
        db.createAttackTable();
        db.createStageTable();
    }

    public void addCharacter(String ID, String Name, String Universe, String Description, String Debut, String Picture, String Youtube_Link) throws ClassNotFoundException {
        db.addCharacter(ID, Name, Universe, Description, Debut, Picture, Youtube_Link);
    }

    public void addAttack(String ID, String Name, String Description, String Animation_length, String Picture) throws ClassNotFoundException {
        db.addAttack(ID, Name, Description, Animation_length, Picture);
    }

    public void addStage(String ID, String Name, String Universe, String Max_players, String Picture) throws ClassNotFoundException {
        db.addStage(ID, Name, Universe, Max_players, Picture);
    }

    // [0] = Name, [1] = Universe, [2] = Description, [3] = Debut, [4] = Picture, [5] = Youtube_Link
    public ArrayList getCharacterDetails(String name) throws ClassNotFoundException {
        return db.getCharacterDetails(name);
    }

    // [0] = Name, [1] = Description, [2] = Animation_Length, [3] = Picture
    public ArrayList getAttackDetails(String name) throws ClassNotFoundException {
        return db.getAttackDetails(name);
    }

    public ArrayList getStageDetails(String name) throws ClassNotFoundException {
        return db.getStageDetails(name);
    }

    // needs to reference characters table, not important atm
    public DefaultComboBoxModel buildAttackComboBoxModel() throws Exception {
        return db.buildAttackComboBoxModel();
    }

    public DefaultComboBoxModel buildStageComboBoxModel() throws Exception {
        return db.buildStageComboBoxModel();
    }

    public DefaultMutableTreeNode processHierarchy(Object[] hierarchy) {
        return db.processHierarchy(hierarchy);
    }

    public DefaultTreeModel pop_tree() {
        return db.pop_tree();
    }

}
