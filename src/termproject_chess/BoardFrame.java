package termproject_chess;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JTextArea;

public class BoardFrame extends javax.swing.JFrame {
    // get images and resize them to 100x100 images
    private ImageIcon w_Pawn = new ImageIcon(new ImageIcon(getClass().getResource("White/Pawn.png")).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
    private ImageIcon w_Rook = new ImageIcon(new ImageIcon(getClass().getResource("White/Rook.png")).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
    private ImageIcon w_Knight_L = new ImageIcon(new ImageIcon(getClass().getResource("White/KnightL.png")).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
    private ImageIcon w_Knight_R = new ImageIcon(new ImageIcon(getClass().getResource("White/KnightR.png")).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
    private ImageIcon w_Bishop_L = new ImageIcon(new ImageIcon(getClass().getResource("White/BishopL.png")).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
    private ImageIcon w_Bishop_R = new ImageIcon(new ImageIcon(getClass().getResource("White/BishopR.png")).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
    private ImageIcon w_Queen = new ImageIcon(new ImageIcon(getClass().getResource("White/Queen.png")).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
    private ImageIcon w_King = new ImageIcon(new ImageIcon(getClass().getResource("White/King.png")).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
    
    private ImageIcon b_Pawn = new ImageIcon(new ImageIcon(getClass().getResource("Black/Pawn.png")).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
    private ImageIcon b_Rook = new ImageIcon(new ImageIcon(getClass().getResource("Black/Rook.png")).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
    private ImageIcon b_Knight_L = new ImageIcon(new ImageIcon(getClass().getResource("Black/KnightL.png")).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
    private ImageIcon b_Knight_R = new ImageIcon(new ImageIcon(getClass().getResource("Black/KnightR.png")).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
    private ImageIcon b_Bishop_L = new ImageIcon(new ImageIcon(getClass().getResource("Black/BishopL.png")).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
    private ImageIcon b_Bishop_R = new ImageIcon(new ImageIcon(getClass().getResource("Black/BishopR.png")).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
    private ImageIcon b_Queen = new ImageIcon(new ImageIcon(getClass().getResource("Black/Queen.png")).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
    private ImageIcon b_King = new ImageIcon(new ImageIcon(getClass().getResource("Black/King.png")).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
    
    private ArrayList<ArrayList<JPanel>> panels = new ArrayList<>();
    private ArrayList<ArrayList<JLabel>> imageLabels = new ArrayList<>();
    
    private JButton resetBtn = new JButton();
    
    private JTextArea ta = new JTextArea();
    public void changeTaText(String s){
        ta.setText(s);
    }
    
    private MouseAdapter panelMouseClickListener = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e){
            for (int y = 0; y < 8; y++)// for loop to find which panel is clicked
                for (int x = 0; x < 8; x++)
                    if (panels.get(y).get(x).equals(e.getComponent())){
                        if (ChessSys.board.get(y).get(x) != null){
                            if (ChessSys.turn){// if its black side turn
                                if (!ChessSys.board.get(y).get(x).isWhite){
                                    if (ChessSys.focused.onBoard())
                                        panels.get(ChessSys.focused.getY()).get(ChessSys.focused.getX()).setBackground(((ChessSys.focused.getX() + ChessSys.focused.getY()) % 2 == 0) ? Color.WHITE : Color.BLACK);
                                    ChessSys.focused.set(x, y);
                                }
                                else if (ChessSys.focused.onBoard() && ChessSys.board.get(ChessSys.focused.getY()).get(ChessSys.focused.getX()).moveable.get(y).get(x)){
                                    ChessSys.moveOnBoard(ChessSys.focused, new Location(x, y));
                                    resetHighlights();
                                }
                            }
                            else {// if its white side turn
                                if (ChessSys.board.get(y).get(x).isWhite){
                                    if (ChessSys.focused.onBoard())
                                        panels.get(ChessSys.focused.getY()).get(ChessSys.focused.getX()).setBackground(((ChessSys.focused.getX() + ChessSys.focused.getY()) % 2 == 0) ? Color.WHITE : Color.BLACK);
                                    ChessSys.focused.set(x, y);
                                }
                                else if (ChessSys.focused.onBoard() && ChessSys.board.get(ChessSys.focused.getY()).get(ChessSys.focused.getX()).moveable.get(y).get(x)) {
                                    ChessSys.moveOnBoard(ChessSys.focused, new Location(x, y));
                                    resetHighlights();
                                }
                            }
                            if (ChessSys.focused.onBoard()){
                                for (int i = 0; i < 8; i++) {
                                    for (int k = 0; k < 8; k++) {
                                        if (ChessSys.board.get(ChessSys.focused.getY()).get(ChessSys.focused.getX()).moveable.get(i).get(k)) {
                                            panels.get(i).get(k).setBackground(Color.yellow);
                                        } else {
                                            panels.get(i).get(k).setBackground(((i + k) % 2 == 0) ? Color.WHITE : Color.BLACK);
                                        }
                                    }
                                }
                            }
                        }
                        else if (ChessSys.focused.onBoard() && ChessSys.board.get(ChessSys.focused.getY()).get(ChessSys.focused.getX()).moveable.get(y).get(x)){
                            panels.get(ChessSys.focused.getY()).get(ChessSys.focused.getX()).setBackground(((ChessSys.focused.getX() + ChessSys.focused.getY()) % 2 == 0) ? Color.WHITE : Color.BLACK);
                            ChessSys.moveOnBoard(ChessSys.focused, new Location(x, y));
                            resetHighlights();
                        }
                        if (ChessSys.focused.onBoard()) {
                            panels.get(ChessSys.focused.getY()).get(ChessSys.focused.getX()).setBackground(Color.blue);
                        }
                        updateTA();
                        setImages();
                        return;
                    }
        }
    };
    
    private void updateTA() {
        String taText = ChessSys.turn ? "Blacks Turn\n" : "Whites Turn\n";
        for (int i = 0; i < 8; i++)
            for (int k = 0; k < 8; k++)
                if (ChessSys.board.get(i).get(k) != null)
                    taText += ChessSys.board.get(i).get(k).toString() + "\n";
        ta.setText(taText);
    }
    
    private JLabel getNewJLabel(){
        JLabel l = new JLabel();
        l.setBounds(0, 0, 100, 100);
        return l;
    }
    
    private void resetHighlights(){
        for (int i = 0; i < 8; i++)
            for (int k = 0; k < 8; k++)
                panels.get(i).get(k).setBackground(((i + k) % 2 == 0) ? Color.WHITE : Color.BLACK);
    }

    public BoardFrame() {
        initComponents();
        ChessSys.init();
        
        this.setSize(1206, 936);
        this.setLocationRelativeTo(null);
        for (int i = 0; i < 8; i++){
            panels.add(i, new ArrayList<>());
            imageLabels.add(i, new ArrayList<>());
            for (int k = 0; k < 8; k++){
                panels.get(i).add(k, new JPanel());
                panels.get(i).get(k).setLocation(110 * k + 10, 110 * i + 10);
//                panels.get(i).get(k).setSize(110, 110);// for gapless board
                panels.get(i).get(k).setSize(105, 105);
//                panels.get(i).get(k).setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));;
//                panels.get(i).get(k).setLayout(null);
                
                panels.get(i).get(k).setBackground(((i + k) % 2 == 0) ? Color.WHITE : Color.BLACK);
                
                imageLabels.get(i).add(k, getNewJLabel());
                panels.get(i).get(k).addMouseListener(panelMouseClickListener);
                panels.get(i).get(k).add(imageLabels.get(i).get(k));
                this.add(panels.get(i).get(k));
            }
        }
        ta.setRows(100);// ?
        ta.setColumns(1);// ?
        ta.setSize(275, 540);
        ta.setLocation(900, 20);
        ta.setEditable(false);
        this.add(ta);
        resetBtn.setSize(150, 25);
        resetBtn.setLocation(900, 580);
        resetBtn.setText("Reset Board");
        resetBtn.addActionListener((event) -> {ChessSys.init(); updateTA(); setImages();});
        this.add(resetBtn);
        updateTA();
        setImages();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private ImageIcon getImageForInstance(Piece p){
        if (p instanceof Pawn){
            return p.getIsWhite() ? w_Pawn : b_Pawn;
        }
        else if (p instanceof Rook){
            return p.getIsWhite() ? w_Rook : b_Rook;
        }
        else if (p instanceof Knight) {
            return p.getIsWhite() ? ( ((Knight) p).getIsRight() ? w_Knight_R : w_Knight_L) : ( ((Knight) p).getIsRight() ? b_Knight_R : b_Knight_L);
        }
        else if (p instanceof Bishop){
            return p.getIsWhite() ? ( ((Bishop) p).getIsRight() ? w_Bishop_R : w_Bishop_L) : ( ((Bishop) p).getIsRight() ? b_Bishop_R : b_Bishop_L);
        }
        else if (p instanceof King){
            return p.getIsWhite() ? w_King : b_King;
        }
        else if (p instanceof Queen){
            return p.getIsWhite() ? w_Queen : b_Queen;
        }
        return null;
    }
    
    private void setImages(){
        for (int i = 0; i < 8; i++)
            for (int k = 0; k < 8; k++)
                imageLabels.get(i).get(k).setIcon(getImageForInstance(ChessSys.board.get(i).get(k)));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
