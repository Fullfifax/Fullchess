package Views;

import Controllers.BoutonEcouteur;

import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {

    public static Component menu = new Menu();

    Container conteneur = getContentPane();

    JLabel background = new JLabel(new ImageIcon(getClass().getResource("../images/bg.jpg")));

    JLabel menuLabel = new JLabel("FullChess :)");

    JButton nouvelle_partie = new JButton("Nouvelle partie");
    JButton reprendre_partie = new JButton("Reprendre partie");
    JButton quitter = new JButton("Quitter");


    public Menu() {
        this.setTitle("FullChess :)");
        this.setSize(540, 480);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setPositionEtTaille();
        setMiseEnForme();

        this.ajouterComposantAuConteneur();

        nouvelle_partie.addActionListener(new BoutonEcouteur());

        quitter.addActionListener(new BoutonEcouteur());

        this.setVisible(true);
    }


    public void setPositionEtTaille() {
        menuLabel.setBounds(175, 50, 200, 30);

        nouvelle_partie.setBounds(170, 300, 200, 30);
        reprendre_partie.setBounds(170, 350, 200, 30);
        quitter.setBounds(170, 400, 200, 30);
    }

    public void setMiseEnForme() {
        menuLabel.setFont(new Font(Font.SERIF, Font.BOLD, 30));

        nouvelle_partie.setFont(new Font(Font.SERIF, Font.BOLD, 14));
        nouvelle_partie.setBackground(Color.GRAY.darker());

        reprendre_partie.setFont(new Font(Font.SERIF, Font.BOLD, 14));
        reprendre_partie.setBackground(Color.GRAY.darker());

        quitter.setFont(new Font(Font.SERIF, Font.BOLD, 14));
        quitter.setBackground(Color.GRAY.darker());
    }

    public void ajouterComposantAuConteneur() {
        conteneur.add(background);
        background.setLayout(null);

        background.add(menuLabel);

        background.add(nouvelle_partie);
        background.add(reprendre_partie);
        background.add(quitter);
    }


}
