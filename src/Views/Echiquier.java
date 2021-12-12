package Views;

import Models.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class Echiquier extends JPanel {

    public static LinkedList<Piece> listePieces = new LinkedList<>();

    // Pour stocker les images lu par ImageIO
    Image listeImagesPiece[] = new Image[12];

    // Chemin des images de pièce
    String path = "/home/fifax/Documents/Fullchess/src/pieces/";

    BufferedImage tourNr, cavalierNr, fouNr, dameNr, roiNr, pionNr,
    tourBl, cavalierBl, fouBl, dameBl, roiBl, pionBl;

    {
        try {
            // Lecture des images des pièces
            tourNr = ImageIO.read(new File(path + "tn.png"));
            listeImagesPiece[0] = tourNr;
            cavalierNr = ImageIO.read(new File(path + "cn.png"));
            listeImagesPiece[1] = cavalierNr;
            fouNr = ImageIO.read(new File(path + "fn.png"));
            listeImagesPiece[2] = fouNr;
            dameNr = ImageIO.read(new File(path + "dn.png"));
            listeImagesPiece[3] = dameNr;
            roiNr = ImageIO.read(new File(path + "rn.png"));
            listeImagesPiece[4] = roiNr;
            pionNr = ImageIO.read(new File(path + "pn.png"));
            listeImagesPiece[5] = pionNr;

            // Lecture des images des pièces blanches
            tourBl = ImageIO.read(new File(path + "tb.png"));
            listeImagesPiece[6] = tourBl;
            cavalierBl = ImageIO.read(new File(path + "cb.png"));
            listeImagesPiece[7] = cavalierBl;
            fouBl = ImageIO.read(new File(path + "fb.png"));
            listeImagesPiece[8] = fouBl;
            dameBl = ImageIO.read(new File(path + "db.png"));
            listeImagesPiece[9] = dameBl;
            roiBl = ImageIO.read(new File(path + "rb.png"));
            listeImagesPiece[10] = roiBl;
            pionBl = ImageIO.read(new File(path + "pb.png"));
            listeImagesPiece[11] = pionBl;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Emplacement des pièces noire
    Piece tourN = new Tour(0, 0,"tn", listePieces);
    Piece cavalierN = new Cavalier(1, 0,"cn", listePieces);
    Piece fouN = new Fou(2, 0,"fn", listePieces);
    Piece dameN = new Dame(3, 0,"dn", listePieces);
    Piece roiN = new Roi(4, 0,"rn", listePieces);
    Piece fouN1 = new Fou(5, 0,"fn", listePieces);
    Piece cavalierN1 = new Cavalier(6, 0,"cn", listePieces);
    Piece tourN1 = new Tour(7, 0,"tn", listePieces);
    Piece pionN = new Pion(0, 1,"pn", listePieces);
    Piece pionN1 = new Pion(1, 1,"pn", listePieces);
    Piece pionN2 = new Pion(2, 1,"pn", listePieces);
    Piece pionN3 = new Pion(3, 1,"pn", listePieces);
    Piece pionN4 = new Pion(4, 1,"pn", listePieces);
    Piece pionN5 = new Pion(5, 1,"pn", listePieces);
    Piece pionN6 = new Pion(6, 1,"pn", listePieces);
    Piece pionN7 = new Pion(7, 1,"pn", listePieces);

    // Emplacement des pièces blanche
    Piece tourB = new Tour(0, 7,"tb", listePieces);
    Piece cavalierB = new Cavalier(1, 7,"cb", listePieces);
    Piece fouB = new Fou(2, 7,"fb", listePieces);
    Piece dameB = new Dame(3, 7,"db", listePieces);
    Piece roiB = new Roi(4, 7,"rb", listePieces);
    Piece fouB1 = new Fou(5, 7,"fb", listePieces);
    Piece cavalierB1 = new Cavalier(6, 7,"cb", listePieces);
    Piece tourB1 = new Tour(7, 7,"tb", listePieces);
    Piece pionB = new Pion(0, 6,"pb", listePieces);
    Piece pionB1 = new Pion(1, 6,"pb", listePieces);
    Piece pionB2 = new Pion(2, 6,"pb", listePieces);
    Piece pionB3 = new Pion(3, 6,"pb", listePieces);
    Piece pionB4 = new Pion(4, 6,"pb", listePieces);
    Piece pionB5 = new Pion(5, 6,"pb", listePieces);
    Piece pionB6 = new Pion(6, 6,"pb", listePieces);
    Piece pionB7 = new Pion(7, 6,"pb", listePieces);

    public JPanel initaliserCasesEtPieces(){

        JPanel panel = new JPanel() {

            @Override
            public void paint(Graphics g) {

                boolean blanc = true;

                for(int y = 0; y < 8; y ++) {

                    for(int x = 0; x < 8; x ++) {

                        if(blanc) {
                            g.setColor(Color.WHITE.darker());
                        } else {
                            g.setColor(Color.GRAY);
                        }
                        g.fillRect(x * 60, y * 60, 60, 60);

                        blanc = !blanc;
                    }

                    blanc = !blanc;
                }

                // Ajout des pièces sur les cases initialisées
                for(Piece piece: listePieces) {
                    int index = 0;

                    if(piece.nomPiece.equalsIgnoreCase("tn")) {index = 0;}
                    if(piece.nomPiece.equalsIgnoreCase("cn")) {index = 1;}
                    if(piece.nomPiece.equalsIgnoreCase("fn")) {index = 2;}
                    if(piece.nomPiece.equalsIgnoreCase("dn")) {index = 3;}
                    if(piece.nomPiece.equalsIgnoreCase("rn")) {index = 4;}
                    if(piece.nomPiece.equalsIgnoreCase("pn")) {index = 5;}
                    if(piece.nomPiece.equalsIgnoreCase("tb")) {index = 6;}
                    if(piece.nomPiece.equalsIgnoreCase("cb")) {index = 7;}
                    if(piece.nomPiece.equalsIgnoreCase("fb")) {index = 8;}
                    if(piece.nomPiece.equalsIgnoreCase("db")) {index = 9;}
                    if(piece.nomPiece.equalsIgnoreCase("rb")) {index = 10;}
                    if(piece.nomPiece.equalsIgnoreCase("pb")) {index = 11;}

                    g.drawImage(listeImagesPiece[index], piece.x, piece.y, this);
                }

            }
        };

        return panel;

    }

}