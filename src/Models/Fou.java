package Models;

import java.util.LinkedList;

public class Fou extends Piece {

    public Fou(int xPos, int yPos, String nomPiece, LinkedList<Piece> listePieces) {
        super(xPos, yPos, nomPiece, listePieces);
    }

    public void deplacement(Piece piece, int xDepart, int xDestination, int yDepart, int yDestination) {

        if (xDestination - xDepart == yDestination - yDepart) {
            // Deplacement droit
            piece.seDeplacer(xDestination, yDestination);
        } else if (-xDestination + xDepart == yDestination - yDepart) {
            // Deplacement gauche
            piece.seDeplacer(xDestination, yDestination);
        } else {
            // Retourne à sa place initiale
            x = this.xPos * 60;
            y = this.yPos * 60;
            return;
        }

    }

}
