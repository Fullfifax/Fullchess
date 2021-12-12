package Models;

import java.util.LinkedList;

public class Pion extends Piece {
    public Pion(int xPos, int yPos, String nomPiece, LinkedList<Piece> listePieces) {
        super(xPos, yPos, nomPiece, listePieces);
    }

    public void deplacement(Piece piece, int xDepart, int xDestination, int yDepart, int yDestination) {
        if(piece.nomPiece.equals("pn")) {
            if((xDestination == xDepart) && (yDestination == yDepart + 1)) {
                piece.seDeplacer(xDestination, yDestination);
            } else {
                // Retourne à sa place initiale
                x = this.xPos * 60;
                y = this.yPos * 60;
                return;
            }
        } else if(piece.nomPiece.equals("pb")) {
            if((xDestination == xDepart) && (yDestination == yDepart - 1)) {
                piece.seDeplacer(xDestination, yDestination);
            } else {
                // Retourne à sa place initiale
                x = this.xPos * 60;
                y = this.yPos * 60;
                return;
            }
        } else {
            // Retourne à sa place initiale
            x = this.xPos * 60;
            y = this.yPos * 60;
            return;
        }
    }
}
