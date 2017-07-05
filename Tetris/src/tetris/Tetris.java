package tetris;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Konrad
 */
public class Tetris extends JFrame{

	private JLabel statusBar;
	
    /**
     * Funkcja tworzy i dodaje komponenty. Usala rozmiar okna.
     */
    public Tetris() {
		statusBar = new JLabel("0"); 
		add(statusBar, BorderLayout.SOUTH);
		Board board = new Board(this);
		add(board);
		
		board.start();
		board.newPiece();
		board.repaint();
		
		setSize(200,400);
		setTitle("Tetris");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

    public JLabel getStatusBar() {
		return statusBar;
	}

    /**
     * Funkcja main. Centruje oraz pokazuje okno w obszarze pulpitu.
     * @param args
     */
    public static void main(String[] args) {
		Tetris myTetris = new Tetris();
		myTetris.setLocationRelativeTo(null);
		myTetris.setVisible(true);	
	}	
}