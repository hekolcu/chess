
package termproject_chess;

public class Knight extends Piece {
    
    private boolean isRight;
    
    public Knight(boolean isWhite, boolean isRight){
        super(isWhite);
        this.isRight = isRight;
    }
    
    @Override
    public boolean canMoveTo(Location l){
        if (ChessSys.board.get(l.getY()).get(l.getX()) == null || ChessSys.board.get(l.getY()).get(l.getX()).getIsWhite() != this.isWhite){
            int x = this.loc.getX(), y = this.loc.getY();
            Location testLoc = new Location(x + 2, y - 1);
            if (testLoc.equals(l))
                return true;
            testLoc.set(x +  1, y - 2);
            if (testLoc.equals(l))
                return true;
            testLoc.set(x - 1, y - 2);
            if (testLoc.equals(l))
                return true;
            testLoc.set(x - 2, y - 1);
            if (testLoc.equals(l))
                return true;
            testLoc.set(x - 2, y + 1);
            if (testLoc.equals(l))
                return true;
            testLoc.set(x - 1, y + 2);
            if (testLoc.equals(l))
                return true;
            testLoc.set(x + 1, y + 2);
            if (testLoc.equals(l))
                return true;
            testLoc.set(x + 2, y + 1);
            return testLoc.equals(l);
        }
        return false;
    }
    
    public boolean getIsRight(){
        return isRight;
    }
    
}
