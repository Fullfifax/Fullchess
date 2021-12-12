package Controllers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Views.Fenetre.fenetre;
import static Views.Menu.menu;

public class BoutonEcouteur implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton bouton = (JButton) e.getSource();

        if(bouton.getText().equals("Nouvelle partie")) {
            menu.setVisible(false);
            fenetre.setVisible(true);
        }
        if(bouton.getText().equals("Quitter")) {
            System.exit(0);
        }
    }
}
