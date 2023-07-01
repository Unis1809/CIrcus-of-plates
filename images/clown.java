/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package images;

import eg.edu.alexu.csd.oop.game.GameObject;

/**
 *
 * @author king
 */
public class clown extends ImageObject implements GameObject {
    private int y;
    private int x;
    
    public clown(int posX, int posY, String path) {
        super(posX, posY, path);
        this.y=posY;
    }
      public clown(int posX, int posY) {
        super(posX, posY);
        this.x=posX;
       // this.y=posY;
    }
    
   @Override
	public int getY() {
		return y;
	}

	@Override
	public void setY(int mY) {
		
	} 
    
    
    
    
    
    
}
