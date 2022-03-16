
package termproject_chess;

import java.util.ArrayList;

public class ChessSys {

    public static ArrayList<ArrayList<Piece>> board;
    public static Location focused = new Location(-1, -1); 
    public static boolean turn;// false : white pieces turn. ; true : black peices turn.
    
    private static void addToBoard(Location loc, Piece p){
        if (!loc.onBoard())
            return;
        p.loc = loc;
        board.get(loc.getY()).set(loc.getX(), p);
    }
    
    private static void updateMoveables(){
        for (int i = 0; i < 8; i++){
            for (int k = 0; k < 8; k++){
                if (board.get(i).get(k) != null) 
                    board.get(i).get(k).updateMoveable();
            }
        }
    }
    
    public static void init(){
        board = new ArrayList<>(8);
        for (int i = 0; i < 8; i++){
            board.add(new ArrayList<>(8));
            for (int k = 0; k < 8; k++)
                board.get(i).add(null);
        } 
        for (int k = 0; k < 8; k++){
            addToBoard(new Location(k, 1), new Pawn(false));
            addToBoard(new Location(k, 6), new Pawn(true));
        }
        
        addToBoard(new Location(0, 0), new Rook(false));
        addToBoard(new Location(1, 0), new Knight(false, true));
        addToBoard(new Location(2, 0), new Bishop(false, true));
        addToBoard(new Location(3, 0), new Queen(false));
        addToBoard(new Location(4, 0), new King(false));
        addToBoard(new Location(5, 0), new Bishop(false, false));
        addToBoard(new Location(6, 0), new Knight(false, false));
        addToBoard(new Location(7, 0), new Rook(false));

        addToBoard(new Location(0, 7), new Rook(true));
        addToBoard(new Location(1, 7), new Knight(true, true));
        addToBoard(new Location(2, 7), new Bishop(true, true));
        addToBoard(new Location(3, 7), new Queen(true));
        addToBoard(new Location(4, 7), new King(true));
        addToBoard(new Location(5, 7), new Bishop(true, false));
        addToBoard(new Location(6, 7), new Knight(true, false));
        addToBoard(new Location(7, 7), new Rook(true));
        
        turn = false;// set to whites turn
        
        updateMoveables();
    }
    
    public static void moveOnBoard(Location location, Location newLocation){
        board.get(newLocation.getY()).set(newLocation.getX(), board.get(location.getY()).set(location.getX(), null));// this statement returns a piece so if i want to add the dead pieces i can return this piece and collect it in the BoardFrame.java class
        board.get(newLocation.getY()).get(newLocation.getX()).loc.set(newLocation.getX(), newLocation.getY());
        updateMoveables();
        ChessSys.focused.set(-1, -1);
        turn = !turn;
        
        if (board.get(newLocation.getY()).get(newLocation.getX()) instanceof Pawn){
            ((Pawn) board.get(newLocation.getY()).get(newLocation.getX())).updateFirstMove();
        }
        else if (board.get(newLocation.getY()).get(newLocation.getX()) instanceof Rook){
            ((Rook) board.get(newLocation.getY()).get(newLocation.getX())).updateFirstMove();
        }
        else if (board.get(newLocation.getY()).get(newLocation.getX()) instanceof King){
            ((King) board.get(newLocation.getY()).get(newLocation.getX())).updateFirstMove();
        }
    }
    
}
