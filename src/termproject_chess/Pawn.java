
package termproject_chess;

public class Pawn extends Piece {
    
    private boolean firstMove;
    
    public Pawn(boolean isWhite){
        super(isWhite);
        firstMove = true;
    }
    
    @Override
    public boolean canMoveTo(Location l){
        Location testLoc = new Location();
        if (ChessSys.board.get(l.getY()).get(l.getX()) == null) {
            if (firstMove){
                if (isWhite){
                    testLoc.set(this.loc.getX(), this.loc.getY() - 2);
                    if (testLoc.equals(l)){
                        testLoc.set(this.loc.getX(), this.loc.getY() - 1);
                        if (ChessSys.board.get(testLoc.getY()).get(testLoc.getX()) == null)
                            return true;
                    }
                }
                else {
                    testLoc.set(this.loc.getX(), this.loc.getY() + 2);
                    if (testLoc.equals(l)){
                        testLoc.set(this.loc.getX(), this.loc.getY() + 1);
                        if (ChessSys.board.get(testLoc.getY()).get(testLoc.getX()) == null)
                            return true;
                    }
                }
            }
            if (isWhite)
                testLoc.set(this.loc.getX(), this.loc.getY() - 1);
            else
                testLoc.set(this.loc.getX(), this.loc.getY() + 1);
            if (testLoc.equals(l))
                    return true;
        }
        if (ChessSys.board.get(l.getY()).get(l.getX()) != null && ChessSys.board.get(l.getY()).get(l.getX()).getIsWhite() != this.isWhite){
            if (isWhite){
                testLoc.set(this.loc.getX() - 1, this.loc.getY() - 1);
                if (testLoc.equals(l))
                    return true;
                testLoc.set(this.loc.getX() + 1, this.loc.getY() - 1);
                if (testLoc.equals(l))
                    return true;
            }
            else {
                testLoc.set(this.loc.getX() - 1, this.loc.getY() + 1);
                if (testLoc.equals(l))
                    return true;
                testLoc.set(this.loc.getX() + 1, this.loc.getY() + 1);
                if (testLoc.equals(l))
                    return true;
            }
        }
        return false;
    }
    
    public void updateFirstMove(){
        firstMove = false;
    }
}
