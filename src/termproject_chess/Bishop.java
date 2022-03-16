
package termproject_chess;

public class Bishop extends Piece {
    
    private boolean isRight;
    
    public Bishop(boolean isWhite, boolean isRight){
        super(isWhite);
        this.isRight = isRight;
    }
    
    public boolean getIsRight(){
        return isRight;
    }
    
    private boolean onDiagonal(Location l){
        if ((l.getX() > this.loc.getX() && l.getY() < this.loc.getY()) || (l.getX() < this.loc.getX() && l.getY() > this.loc.getY()))
            return this.loc.getX() + this.loc.getY() == l.getX() + l.getY();// if its on the positive diagonal of this: magical equation to increase efficiency
        else {
            for (int i = 1; i <= 7; i++){
                if ((this.loc.getX() - i == l.getX() && this.loc.getY() - i == l.getY()) || (this.loc.getX() + i == l.getX() && this.loc.getY() + i == l.getY()))
                    return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean canMoveTo(Location l){
        if (onDiagonal(l) && (ChessSys.board.get(l.getY()).get(l.getX()) == null || ChessSys.board.get(l.getY()).get(l.getX()).getIsWhite() != this.isWhite)) {
            if (l.getX() > this.loc.getX() && l.getY() < this.loc.getY()) {// quadrant 1
                for (int x = this.loc.getX() + 1, y = this.loc.getY() - 1; x < l.getX() && y > l.getY(); x++, y--)
                    if (ChessSys.board.get(y).get(x) != null)
                        return false;
                return true;
            } else if (l.getX() < this.loc.getX() && l.getY() > this.loc.getY()) {// quadrant 3
                for (int x = this.loc.getX() - 1, y = this.loc.getY() + 1; x > l.getX() && y < l.getY(); x--, y++)
                    if (ChessSys.board.get(y).get(x) != null)
                        return false;
                return true;
            } else if (l.getX() < this.loc.getX() && l.getY() < this.loc.getY()) {// quadrant 2
                for (int x = this.loc.getX() - 1, y = this.loc.getY() - 1; x > l.getX() && y > l.getY(); x--, y--)
                    if (ChessSys.board.get(y).get(x) != null)
                        return false;
                return true;
            } else if (l.getX() > this.loc.getX() && l.getY() > this.loc.getY()) {// quadrant 4
                for (int x = this.loc.getX() + 1, y = this.loc.getY() + 1; x < l.getX() && y < l.getY(); x++, y++)
                    if (ChessSys.board.get(y).get(x) != null)
                        return false;
                return true;
            }
        }
        return false;
    }
}
