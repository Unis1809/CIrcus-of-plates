package mains;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.Rectangle;
import java.awt.Shape;

import eg.edu.alexu.csd.oop.game.GameEngine;
import eg.edu.alexu.csd.oop.game.GameEngine.GameController;
import info.Game;
import static info.Game.MAX_TIME;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class Main   {
  
  
  public Main(){
        System.out.println("Uncomment any of the lines in the Main to run a new game, Have Fun :)");

		/* -------------------------------------------------------------------- */
		/* using default background color */
//		GameEngine.start("Very Simple Game in 99 Line of Code", new eg.edu.alexu.csd.oop.game.sample.world.Gold(400, 400));
		
		/* -------------------------------------------------------------------- */
		/* using background color at the game */
//		GameEngine.start("Very Simple Game in 99 Line of Code", new eg.edu.alexu.csd.oop.game.sample.world.Ball(700, 400), Color.YELLOW);
		
		/* -------------------------------------------------------------------- */
		/* controlling the behavior of the close button
		 * alternatively, you can use JFrame.DISPOSE_ON_CLOSE, JFrame.HIDE_ON_CLOSE */
//		GameEngine.start("Very Simple Game in 99 Line of Code", new eg.edu.alexu.csd.oop.game.sample.world.Bubles(600, 600), JFrame.EXIT_ON_CLOSE);

//		/* using menus in the game */
//		JMenuBar  menuBar = new JMenuBar();;
//		JMenu menu = new JMenu("File");
//		JMenuItem  exitMenuItem = new JMenuItem("Exit");
//		exitMenuItem.addActionListener(new ActionListener() {
//			@Override public void actionPerformed(ActionEvent e) {
//				System.exit(0);
//			}
//		});
//		menu.add(exitMenuItem);
//		menuBar.add(menu);
//		GameEngine.start("Very Simple Game in 99 Line of Code", new eg.edu.alexu.csd.oop.game.sample.world.StarWar(800, 600), menuBar, Color.BLACK);

		/* -------------------------------------------------------------------- */
		/* allow pause, resume, and restart multiple worlds in the same frame */
		JMenuBar  menuBar = new JMenuBar();;
		JMenu menu = new JMenu("File");
		JMenuItem newMenuItem = new JMenuItem("New");
		JMenuItem pauseMenuItem = new JMenuItem("Pause");
		JMenuItem resumeMenuItem = new JMenuItem("Resume");
		menu.add(newMenuItem);
		menu.addSeparator();
		menu.add(pauseMenuItem);
		menu.add(resumeMenuItem);
		menuBar.add(menu);
             
                
                    
		final GameController gameController =GameEngine.start("AHMY", new info.Game(1200, 700), menuBar, Color.WHITE);
                        //GameEngine.start("Very Simple Game in 99 Line of Code", new eg.edu.alexu.csd.oop.game.sample.world.Gold(800, 400));
        //               
         
                		/* using default background color */
		
		
		/* -------------------------------------------------------------------- */
		/* using background color at the game */
//		GameEngine.start("Very Simple Game in 99 Line of Code", new eg.edu.alexu.csd.oop.game.sample.world.Ball(700, 400), Color.YELLOW);
		
		/* -------------------------------------------------------------------- */
		/* controlling the behavior of the close button
		 * alternatively, you can use JFrame.DISPOSE_ON_CLOSE, JFrame.HIDE_ON_CLOSE */
//		GameEngine.start("Very Simple Game in 99 Line of Code", new eg.edu.alexu.csd.oop.game.sample.world.Bubles(600, 600), JFrame.EXIT_ON_CLOSE);


                
		newMenuItem.addActionListener(new ActionListener() {
		@Override public void actionPerformed(ActionEvent e) {
				//gameController.changeWorld(new info.Game(1200, 700));
        //   gameController.changeWorld(new info.Game(1200, 700));
            
			}
		});
		pauseMenuItem.addActionListener(new ActionListener() {
		@Override public void actionPerformed(ActionEvent e) {
                    
				gameController.pause();
			}
		});
		resumeMenuItem.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				gameController.resume();
			}
		}
                
                
                );
                final JFrame gameFrame = (JFrame) menuBar.getParent().getParent().getParent();
        gameFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        gameFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(gameFrame, "Are you sure you want to close this game?",
                        "End Game?", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                    st frame=new st();
                    frame.setVisible(true);
                     Game.MAX_TIME=1 * 90 * 2000;
                     Game.startTime= System.currentTimeMillis();
                     Game.timeout = System.currentTimeMillis() - Game.startTime > MAX_TIME; 
              filescore f=new filescore();
        f.save("clownscores"); 
            //  gameController.changeWorld(new info.Game(1200, 700));
                    gameFrame.setVisible(false);
                    
                    
                }
           
            }
               	});
          
  }
}  
          

        
    
    
	