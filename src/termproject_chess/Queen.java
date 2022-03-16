
package termproject_chess;

public class Queen extends Piece {

    public Queen(boolean isWhite){
        super(isWhite);
    }
    
    @Override
    public boolean canMoveTo(Location l){// queen can move like a bishop and a rook ()_()
        Rook r = new Rook(isWhite);
        Bishop b = new Bishop(isWhite, false);
        r.loc.set(this.loc.getX(), this.loc.getY());
        b.loc.set(this.loc.getX(), this.loc.getY());
        return (r.canMoveTo(l) || b.canMoveTo(l));
    }
    
}
