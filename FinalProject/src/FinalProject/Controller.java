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
        model.addCharacter("2", "Pikachu", "Pokemon", "Makes billions of dollars.", "Pokemon Red and Green (1996)", "images/pikachu.png", "https://www.youtube.com/embed/7LfEvnLc3mI");
        model.addCharacter("3", "Samus", "Metroid", "Wears a suit and shoots things.", "Metroid (1986)", "images/samus.png", "https://www.youtube.com/embed/Y4PTxiq11Fk");


        model.addAttack("1", "Neutral Attack 1", "Description", "16", "images/neutral_attack_1.gif");
        model.addAttack("2", "Forward tilt", "Pikachu kicks back with 2 legs.", "20", "images/forward_tilt.gif");
        model.addAttack("3", "Slide special", "Slide and shoot.", "24", "images/slide_special.gif");
        
        model.addStage("1", "3D Land", "Mario", "The stage is a travelling stage that cycles through a castle area, a valley, a downhill area, and a water area, ending in a warp pipe that restarts the cycle.", "8", "images/3D_Land.png");
        model.addStage("2", "Geat Plateau Tower", "Zelda", "The stage is a completely flat surface with a medium-sized structure above the middle of the floor acting as a ceiling. When hazards are on, the ceiling is destructible through two methods, which are by either damaging it with an attack, or having an opponent collide against it when they're being knocked back. ",
        "8", "images/Great_Tower.jpg");
        model.addStage("3", Green Hill Zone", "Sonic", "The stage consists in a single piece of land with a bridge on its left, walk-offs at both sides and a depression in the middle.", "8", "images/Green_Hill_Zone.png");
 
        
        */
        //Listeners
        
        
//        model.addStage("1", "3D Land", "Mario", "8", "images/3D_Land.png");
//        model.addStage("2", "Great Plateau Tower", "Zelda", "8", "images/Great_Tower.jpg");
//        model.addStage("3","Green Hill Zone", "Sonic", "8", "images/Green_Hill_Zone.png");


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
                ArrayList details = model.getStageDetails(view.getStageComboBox().getSelectedItem().toString());
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
