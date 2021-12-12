package Models;

import java.util.LinkedList;

public abstract class Piece {

    // Position par rapport à la fenêtre
    public int x, y;

    public boolean positionLegal = true;

    // Position des pièces
    public int xPos, yPos;

    public String nomPiece;
    static LinkedList<Piece> listePieces;


    public Piece(int xPos, int yPos, String nomPiece, LinkedList<Piece> listePieces) {
        this.xPos = xPos;
        this.yPos = yPos;

        x = xPos * 60;
        y = yPos * 60;

        this.nomPiece = nomPiece;
        this.listePieces = listePieces;
        listePieces.add(this);
    }

    // Prend l'état d'une pièce (position)
    public static Piece getPiece(int x, int y) {
        int xPos = x / 60;
        int yPos = y / 60;
        for(Piece piece : listePieces) {
            if(piece.xPos == xPos && piece.yPos == yPos) {
                return piece;
            }
        }
        return null;
    }

    public void seDeplacer(int xPos, int yPos) {

        // Si une pièce existe sur la case où l'autre pièce veut y placer
        if(getPiece(xPos * 60, yPos * 60) != null) {
            // Si la pièce n'est pas de même couleur avec l'autre
            if(getPiece(xPos * 60, yPos * 60).nomPiece.charAt(1) != nomPiece.charAt(1)) {
                // Attaquez-la
                getPiece(xPos * 60, yPos * 60).attaquer();
                // Sinon retourner vers sa place initiale
            } else {
                x = this.xPos * 60;
                y = this.yPos * 60;
                return;
            }
        }

        this.xPos = xPos;
        this.yPos = yPos;

        x = xPos * 60;
        y = yPos * 60;

    }

    public void deplacement(Piece piece, int xDepart, int xDestination, int yDepart, int yDestination){}

    public void attaquer(){
        listePieces.remove(this);
    }

}
