
package termproject_chess;

public class Location implements OnBoardInterface {
    private int x, y;
    
    public Location(){}
    
    public Location(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public void set(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public boolean equals(Location l){
        return (this.x == l.getX() && this.y == l.getY());
    }
    
    @Override
    public boolean onBoard(){
        return(x < 8 && x > -1 && y < 8 && y > -1);
    }
    
    @Override
    public String toString(){
        return "(" + this.x + ", " + this.y + ")";
    }
    
}
