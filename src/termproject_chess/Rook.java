
package termproject_chess;

public class Rook extends Piece {
    
    private boolean firstMove;
    
    public Rook(boolean isWhite){
        super(isWhite);
        firstMove = true;
    }
    
    @Override
    public boolean canMoveTo(Location l){
        if (l.getY() == loc.getY()) {
            if (l.getX() > loc.getX()) {
                for (int x = loc.getX() + 1; x < l.getX(); x++) {
                    if (ChessSys.board.get(l.getY()).get(x) != null) {
                        return false;
                    }
                }
                if (ChessSys.board.get(l.getY()).get(l.getX()) == null) {
                    return true;
                } else if (ChessSys.board.get(l.getY()).get(l.getX()).getIsWhite() != this.isWhite) {
                    return true;
                }
            } else {
                for (int x = loc.getX() - 1; x > l.getX(); x--) {
                    if (ChessSys.board.get(l.getY()).get(x) != null) {
                        return false;
                    }
                }
                if (ChessSys.board.get(l.getY()).get(l.getX()) == null) {
                    return true;
                } else if (ChessSys.board.get(l.getY()).get(l.getX()).getIsWhite() != this.isWhite) {
                    return true;
                }
            }
        } else if (l.getX() == loc.getX()) {
            if (l.getY() > loc.getY()) {
                for (int y = loc.getY() + 1; y < l.getY(); y++) {
                    if (ChessSys.board.get(y).get(l.getX()) != null) {
                        return false;
                    }
                }
                if (ChessSys.board.get(l.getY()).get(l.getX()) == null) {
                    return true;
                } else if (ChessSys.board.get(l.getY()).get(l.getX()).getIsWhite() != this.isWhite) {
                    return true;
                }
            } else {
                for (int y = loc.getY() - 1; y > l.getY(); y--) {
                    if (ChessSys.board.get(y).get(l.getX()) != null) {
                        return false;
                    }
                }
                if (ChessSys.board.get(l.getY()).get(l.getX()) == null) {
                    return true;
                } else if (ChessSys.board.get(l.getY()).get(l.getX()).getIsWhite() != this.isWhite) {
                    return true;
                }
            }
        }
        return false;
    }
    public void updateFirstMove(){
        firstMove = false;
    }
    
}
