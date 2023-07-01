/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package info;

/**
 *
 * @author king
 */
public class State {
    public void getnextstate(){
        if (Game.strategy instanceof easy)
            Game.strategy =new medium();
       
        if (Game.strategy instanceof medium)
            Game.strategy=new hard();
        
   
    }
       
}
