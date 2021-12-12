package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Sauvegarde extends JFrame {

    private final String url = "jdbc:postgresql://localhost/fullchess";
    private final String utilisateur = "postgres";
    private final String motDePasse = "pgadmin4";

    Connection connection = null;

    public Connection connecter() {

        try {
            connection = DriverManager.getConnection(url, utilisateur, motDePasse);
//            System.out.println("Vous etes connecté sur le server Postgres :)");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return connection;
    }

    Container conteneur = getContentPane();

    public JLabel idSaveLabel = new JLabel("Id de la partie");
    public JTextField idSaveField = new JTextField();

    public JLabel nomPartieLabel = new JLabel("Nom de la partie");
    public JTextField nomPartieField = new JTextField();

    public JButton sauvegarder = new JButton("Sauvegarder");

    public Sauvegarde() {
        this.setTitle("Sauvegarder une partie");
        this.setSize(300, 150);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.ajouterComposantAuConteneur();

        this.setVisible(false);
    }


    public void ajouterComposantAuConteneur() {
        conteneur.setLayout(null);

//        idSaveLabel.setBounds(50, 20, 200, 20);
//        idSaveField.setBounds(50, 40, 200, 20);

        nomPartieLabel.setBounds(50, 20, 200, 20);
        nomPartieField.setBounds(50, 40, 200, 20);

        sauvegarder.setBounds(75, 80, 150, 20);
        sauvegarder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Statement insertStmt = null;
                try {
                    insertStmt = connection.createStatement();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                String idSave = idSaveField.getText();
                String nomPartie = nomPartieField.getText();
                System.out.println(idSave + "\n" + nomPartie);
                String sql = "INSERT INTO partie (id, nom_partie) VALUES ( " + idSave + ", " + nomPartie + ")";
                try {
                    insertStmt.executeUpdate( sql );
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                Views.Fenetre.sauvegarde.setVisible(false);
            }
        });

//        conteneur.add(idSaveLabel);
//        conteneur.add(idSaveField);
        conteneur.add(nomPartieLabel);
        conteneur.add(nomPartieField);
        conteneur.add(sauvegarder);
    }



}
