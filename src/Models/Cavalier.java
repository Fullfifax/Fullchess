package Models;

import java.util.LinkedList;

public class Cavalier extends Piece{

    public Cavalier(int xPos, int yPos, String nomPiece, LinkedList<Piece> listePieces) {
        super(xPos, yPos, nomPiece, listePieces);
    }

    public void deplacement(Piece piece, int xDepart, int xDestination, int yDepart, int yDestination) {
        if(
                ((xDestination == xDepart + 2) && (yDestination == yDepart + 1)) ||
                ((xDestination == xDepart - 2) && (yDestination == yDepart - 1)) ||
                ((xDestination == xDepart + 2) && (yDestination == yDepart - 1)) ||
                ((xDestination == xDepart - 2) && (yDestination == yDepart + 1)) ||
                ((xDestination == xDepart + 2) && (yDestination == yDepart - 1)) ||
                ((xDestination == xDepart - 1) && (yDestination == yDepart - 2)) ||
                ((xDestination == xDepart - 1) && (yDestination == yDepart + 2)) ||
                ((xDestination == xDepart + 1) && (yDestination == yDepart - 2)) ||
                ((xDestination == xDepart + 1) && (yDestination == yDepart + 2))
        ) {
            piece.seDeplacer(xDestination, yDestination);
        } else {
            // Retourne à sa place initiale
            x = this.xPos * 60;
            y = this.yPos * 60;
            return;
        }
    }

}
