/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Ludia
 */
public class Controller {

    public void init(View view, Model model) throws SQLException, ClassNotFoundException, Exception {

        /*Setup model database
        model.setupDatabase();

        model.addCharacter("1", "Mario", "Mario", "A fan favorite.", "Donkey Kong (1981)", "images/mario.png", "https://www.youtube.com/embed/INk1W8OujQI");
        model.addAttack("1", "Smash", "Description", "50", "pics");
        model.addStage("1", "Smash", "Description", "50", "pics");
        */

        //Listeners
        view.selectButtonListener((ActionEvent evt) -> {
            try {
                ArrayList details = model.getCharacterDetails(view.getName());
                view.setName(details.get(0).toString());
                view.setUniverse(details.get(1).toString());
                view.setDebut(details.get(3).toString());
                view.setDescription(details.get(2).toString());
                view.setImage(details.get(4).toString()); // set Image not working atm
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
        view.videoButtonListener((ActionEvent evt) -> {
            try {
                ArrayList details = model.getCharacterDetails(view.getName());
                view.setVideo(details.get(5).toString());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
        view.attackButtonListener((ActionEvent evt) -> {
            try {
                ArrayList details = model.getAttackDetails(view.getCharacterComboBox().getSelectedItem().toString());
                view.setAttack(details.get(0).toString());
                view.setAttackDescription(details.get(1).toString());
                view.setAttackLength(details.get(2).toString());
                view.setAttackGIF(details.get(3).toString());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
        view.stageButtonListener((ActionEvent evt) -> {
            try {
                ArrayList details = model.getAttackDetails(view.getStageComboBox().getSelectedItem().toString());
                view.setStage(details.get(0).toString());
                view.setUniverseName(details.get(1).toString());
                view.setMaxPlayer(details.get(2).toString());
                view.setStageImage(details.get(3).toString());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
        
        view.setCharacterComboBoxModel(model.buildAttackComboBoxModel());
        view.setStageComboBoxModel(model.buildStageComboBoxModel());
        view.setTreeModel(model.pop_tree());

        view.setVisible(true);  //Show View

    }

}
