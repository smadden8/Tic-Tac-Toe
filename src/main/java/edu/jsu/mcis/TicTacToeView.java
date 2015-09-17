package edu.jsu.mcis;

import javax.swing.*;

class TicTacToeFrame extends JFrame {
    
    public TicTacToeFrame() {
       
        TicTacToe t = new TicTacToe();
        
        setTitle("Tic Tac Toe");
        setSize(300, 300);
        setLocation(50, 100);
     
}
    public static void main(String[] args) {
        TicTacToeFrame frame = new TicTacToeFrame();
        frame.show();
    }
}