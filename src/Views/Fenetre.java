package Views;

import Models.Piece;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Fenetre extends JFrame {

        Container conteneur = getContentPane();
        static Sauvegarde sauvegarde = new Sauvegarde();

        public int tour = 2;
        public static Component fenetre = new Fenetre();

        // Menu
        private JMenuBar menuBar = new JMenuBar();
        private JMenu partie = new JMenu("Partie");
        private JMenuItem nouvellePartie = new JMenuItem ( "Jouer une nouvelle partie" ) ;
        private JMenuItem sauvegardePartie = new JMenuItem ( "Sauvegarder une partie" ) ;
        private JMenuItem quitterPartie = new JMenuItem ( "Quitter la partie" ) ;

        // Echiquier
        Echiquier echiquier = new Echiquier();
        JPanel panel = echiquier.initaliserCasesEtPieces();

        public static Piece pieceSelectionnE = null;

        public Fenetre() {
            this.setTitle("FullChess :)");
            this.setSize(480, 530 );
            this.setResizable(false);
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);

            // Ajout des composants dans le fenêtre/conteneur
            this.ajouterComposantAuConteneur();

            this.setVisible(true);
        }

        public void ajouterComposantAuConteneur() {

            // Echiquier initial
            conteneur.add(panel);

            // Menu du jeu
            partie.add(nouvellePartie);
            partie.add(sauvegardePartie);
            partie.add(quitterPartie);
            menuBar.add(partie);
            this.setJMenuBar(menuBar);

            // Bouton listener
            nouvellePartie.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    echiquier.initaliserCasesEtPieces();
                    panel.repaint();
                }
            });

            sauvegardePartie.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    sauvegarde.setVisible(true);
                    sauvegarde.connecter();
                }
            });

            quitterPartie.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    fenetre.setVisible(false);
                    Menu menu = new Menu();
                    menu.setVisible(true);
                }
            });

            // Mouse motion listener
            conteneur.addMouseMotionListener(new MouseMotionListener() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    if(pieceSelectionnE != null) {
                        // Centrer par rapport à la case
                        pieceSelectionnE.x = e.getX() - 30;
                        pieceSelectionnE.y = e.getY() - 30;
                        panel.repaint();
                    }
                }

                @Override
                public void mouseMoved(MouseEvent e) {}
            });


            // Mouse listener
            conteneur.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {}

                @Override
                public void mousePressed(MouseEvent e) {
                    // Get position pièce
                    pieceSelectionnE = Piece.getPiece(e.getX(), e.getY());
                    System.out.println(tour);
                    System.out.println(pieceSelectionnE.nomPiece);
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    // Deplacement vers destination
                    if(tour % 2 == 0 && pieceSelectionnE.nomPiece.charAt(1) == 'b') {
                        pieceSelectionnE.deplacement(pieceSelectionnE, pieceSelectionnE.xPos, e.getX()/60, pieceSelectionnE.yPos, e.getY()/60);
                        if(pieceSelectionnE.positionLegal == true) {
                            tour += 1;
                        }
                    } else if (tour % 2 != 0 && pieceSelectionnE.nomPiece.charAt(1) == 'n'){
                        pieceSelectionnE.deplacement(pieceSelectionnE, pieceSelectionnE.xPos, e.getX()/60, pieceSelectionnE.yPos, e.getY()/60);
                        if(pieceSelectionnE.positionLegal == true) {
                            tour -= 1;
                        }
                    } else {
                        // Rester à sa place
                        pieceSelectionnE.seDeplacer(pieceSelectionnE.xPos, pieceSelectionnE.yPos);
                        tour *= 1;
                    }

                    panel.repaint();
                }

                @Override
                public void mouseEntered(MouseEvent e) {}

                @Override
                public void mouseExited(MouseEvent e) {}
            });

        }

    }


