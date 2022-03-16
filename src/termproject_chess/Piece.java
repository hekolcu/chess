
package termproject_chess;

import java.util.ArrayList;

public abstract class Piece {
    public Location loc;
    protected boolean isWhite;
    public ArrayList<ArrayList<Boolean>> moveable = new ArrayList<>(8);
    private static Location outsideOfBoard = new Location(-1, -1);
    
    public Piece(){
        loc = outsideOfBoard;
        for (int i = 0; i < 8; i++){
            moveable.add(i, new ArrayList<>(8));
            for (int k = 0; k < 8; k++)
                moveable.get(i).add(false);
        }
    }
    
    public Piece(boolean isWhite){
        this();
        this.isWhite = isWhite;
    }
    
    public boolean getIsWhite(){
        return isWhite;
    }
    
    public abstract boolean canMoveTo(Location l);
    
    public void updateMoveable(){
        for (int i = 0; i < 8; i++)
            for (int k = 0; k < 8; k++){
                moveable.get(i).set(k, this.canMoveTo(new Location(k, i)));
            }
    }
    
    @Override
    public String toString(){
        if (this instanceof Rook)
            return "Rook " + loc.toString() + (isWhite ? " White" : " Black");
        if (this instanceof Pawn)
            return "Pawn "+ loc.toString() + (isWhite ? " White" : " Black");
        if (this instanceof Knight)
            return "Knight "+ loc.toString() + (isWhite ? " White" : " Black");
        if (this instanceof Bishop)
            return "Bishop "+ loc.toString() + (isWhite ? " White" : " Black");
        if (this instanceof King)
            return "King "+ loc.toString() + (isWhite ? " White" : " Black");
        if (this instanceof Queen)
            return "Queen "+ loc.toString() + (isWhite ? " White" : " Black");
        return "";
    }
    
}
