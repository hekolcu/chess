
package termproject_chess;

public class King extends Piece {
    
    private boolean firstMove;
    
    public King(boolean isWhite){
        super(isWhite);
        firstMove = true;
    }
    
    @Override
    public boolean canMoveTo(Location l){
        if (ChessSys.board.get(l.getY()).get(l.getX()) == null || ChessSys.board.get(l.getY()).get(l.getX()).getIsWhite() != this.isWhite){
            Location testLoc = new Location(this.loc.getX() - 1, this.loc.getY() - 1);
            if (testLoc.equals(l)) return true;
            testLoc.set(this.loc.getX(), this.loc.getY() - 1);
            if (testLoc.equals(l)) return true;
            testLoc.set(this.loc.getX() + 1, this.loc.getY() - 1);
            if (testLoc.equals(l)) return true;
            testLoc.set(this.loc.getX() - 1, this.loc.getY());
            if (testLoc.equals(l)) return true;
            testLoc.set(this.loc.getX() + 1, this.loc.getY());
            if (testLoc.equals(l)) return true;
            testLoc.set(this.loc.getX() - 1, this.loc.getY() + 1);
            if (testLoc.equals(l)) return true;
            testLoc.set(this.loc.getX(), this.loc.getY() + 1);
            if (testLoc.equals(l)) return true;
            testLoc.set(this.loc.getX() + 1, this.loc.getY() + 1);
            if (testLoc.equals(l)) return true;
        }
        return false;
    }
    
    public void updateFirstMove(){
        firstMove = false;
    }
}
