package Models;

import java.util.LinkedList;

public class Tour extends Piece {
    public Tour(int xPos, int yPos, String nomPiece, LinkedList<Piece> listePieces) {
        super(xPos, yPos, nomPiece, listePieces);
    }

    public void deplacement(Piece piece, int xDepart, int xDestination, int yDepart, int yDestination) {

        int i;

        if (xDepart == xDestination) {
            if (yDepart < yDestination) {
                // Deplacement droit
                for (i = yDepart + 1; i <= yDestination; ++i) {
                    piece.seDeplacer(xDestination, yDestination);
                }
            } else {
                // Deplacement gauche
                for (i = yDepart - 1; i >= yDestination; --i) {
                    piece.seDeplacer(xDestination, yDestination);
                }
            }
        } else if (yDepart == yDestination) {
            if (xDepart < xDestination) {
                // Deplacement bas
                for (i = xDepart + 1; i <= xDestination; ++i) {
                    piece.seDeplacer(xDestination, yDestination);
                }
            } else {
                // Deplacement haut
                for (i = xDepart - 1; i >= xDestination; --i) {
                    piece.seDeplacer(xDestination, yDestination);
                }
            }
        } else {
            // Retourne à sa place initiale
            x = this.xPos * 60;
            y = this.yPos * 60;
            return;
        }
    }
}
