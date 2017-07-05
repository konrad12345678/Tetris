package tetris;

import java.util.Random;

/**
 *
 * @author Konrad
 */

/**
 * Klasa w której ustalone są kształty klocków
 * 
 */

public class Shape {
    
	enum Tetrominos {
		NoShape(new int[][] { { 0, 0}, { 0, 0}, { 0, 0}, { 0, 0 } }),
		MirrorLShape(new int [][] {{ 1, -1}, { 0, -1}, { 0, 0}, { 0, 1 } }),
		SShape(new int [][] {{ 0, -1}, { 0, 0}, { 1, 0}, { 1, 1 } }),
                LShape(new int [][] {{ -1, -1}, { 0, -1}, { 0, 0}, { 0, 1 } }),
		LineShape(new int [][] {{ 0, -1}, { 0, 0}, { 0, 1}, { 0, 2 } }),
		TShape(new int [][] {{ -1, 0}, { 0, 0}, { 1, 0}, { 0, 1 } }),
		SquareShape(new int [][] {{ 0, 0}, { 1, 0}, { 0, 1}, { 1, 1 } }),
                ZShape(new int [][] {{ 0, -1}, { 0, 0}, { -1, 0}, { -1, 1 } })
		;
		
		public int[][] coords;
		
		private Tetrominos (int [][] coords) {
			this.coords = coords;
		}
	}
	
	private Tetrominos pieceShape;
	private int[][] coords;
	
    /**
     * Konstruktor dla klasy.
     */
    public Shape() {
		coords = new int[4][2];
		setShape(Tetrominos.NoShape);
	}
	
    /**
     * 
     * @param shape
     */
    public void setShape(Tetrominos shape){
		for (int i = 0; i<4; i++){
			for (int j = 0; j < 2; ++j) {
				coords[i][j]= shape.coords[i][j];
			}
		}	
		pieceShape = shape;	
	}
	
    /**
     * Współrzędna x
     * @param index
     * @param x
     */
    public void setX(int index, int x) {
		coords [index][0] = x;	
	}
	
    /**
     * Współrzedna y
     * @param index
     * @param y
     */
    public void setY(int index, int y) {
		coords[index][1] = y;
	}
	
    /**
     *
     * @param index
     * @return
     */
    public int x(int index){
		return coords[index][0];
	}
        
    /**
     *
     * @param index
     * @return
     */
    public int y(int index) {
		 return coords[index][1];	 
	}
	
    /**
     *
     * @return
     */
    public Tetrominos getShape() {
		return pieceShape;
	}
        
    /**
     * Funkcja generuje losowy klocek.
     */
    public void setRandomShape() {
		Random r = new Random();
		int x = Math.abs(r.nextInt()) % 7+ 1;
		Tetrominos[] values = Tetrominos.values();
		setShape(values[x]);
	}
        
    /**
     *
     * @return
     */
    public int minX(){
		int m = coords[0][0];
		
		for (int i=0; i<4; i++) {
			m= Math.min(m, coords[i][0] );
		}	
		return m;	
	}
	
    /**
     *
     * @return
     */
    public int minY(){
		int m = coords[0][1];
		
		for (int i=0; i<4; i++) {
			m= Math.min(m, coords[i][1] );
		}
		return m;
	}

    /**
     * Metoda, która obraca klocek w lewo. 
     * @return
     */
    public Shape rotate() {
		if (pieceShape == Tetrominos.SquareShape)
			return this;
		
		Shape result = new Shape();
		result.pieceShape = pieceShape;
		
		for (int i =0; i<4; i++) {
			result.setX(i , y(i));
			result.setY(i, -x(i));
		}
			return result;
	}
}
	