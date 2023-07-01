package info;

import java.util.LinkedList;
import java.util.List;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import images.ImageObject;
import images.clown;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import mains.filescore;
import static sun.jvm.hotspot.HelloWorld.e;

public class Game implements World{
	public static int MAX_TIME = 1 * 60 * 1000;	// 2 minute
	private int score = 0;
	public static long startTime = System.currentTimeMillis();
	private final int width;
	private final int height;
	private final List<GameObject> constant = new LinkedList<GameObject>();
	private final List<GameObject> moving = new LinkedList<GameObject>();
	private final List<GameObject> control = new LinkedList<GameObject>();
        public static List <Users> records= new ArrayList<Users>();
        int lli=0;
        int lri=0;
        int offset=10;
        public static int cs=3;
      public static boolean timeout;
       int [] left=new int[100];
       int [] right=new int[100];
       int li=0,ri=0;
       Users u;
       public static Strategy strategy;
        String[] pic=new String[] {"/circleblue.png", "/circlered.png", "/circlegreen.png","/plateblue.png", "/platered.png", "/plategreen.png","/Bomb.png" }; 
                int[] type={1,2,3,1,2,3,0};
	public Game(int screenWidth, int screenHeight) {
		width = screenWidth;
		height = screenHeight;
		// control objects (hero)
               
                int j=0;
                int k=0;
               
		control.add(new clown(screenWidth/2-80,(int)(screenHeight*0.77), "/clown.png"));
                
        moving.add( new ImageObject(360 ,100, pic[6],type[6]));
        moving.add( new ImageObject((width - 420 ),100,pic[j],type[j]));
        moving.add( new ImageObject(360 ,160, pic[j],type[j]));
        moving.add( new ImageObject((width - 420 ),160,pic[6],type[6]));
        constant.add(new ImageObject(0,0,"/th.jpeg"));
           u=new Users(mains.Userdata.name,score);
           u.setUsername(mains.Userdata.name);
           records.add(u);
       
        
	}
	private  boolean intersectleft(GameObject o1, GameObject o2){
//		return (Math.abs((o1.getX()+o1.getWidth()/2) - (o2.getX())) <= o1.getWidth()/2) && (Math.abs((o1.getY()+o1.getHeight()/2) - (o2.getY())) <= o1.getHeight());
		return (Math.abs(o1.getX() - o2.getX()) <= o1.getWidth()/2) && (Math.abs((o1.getY()+o1.getHeight()) - (o2.getY())) <= o1.getHeight()/2);
	}
        private  boolean intersectright(GameObject o1, GameObject o2){
//		return (Math.abs((o1.getX()+o1.getWidth()/2) - (o2.getX()+o2.getWidth())) <= o1.getWidth()) && (Math.abs((o1.getY()+o1.getHeight()/2) - (o2.getY())) <= o1.getHeight());
		return (Math.abs((o1.getX()+o1.getWidth()) - (o2.getX()+o2.getWidth())) <= o1.getWidth()/2) && (Math.abs((o1.getY()+o1.getHeight()) - (o2.getY())) <= o1.getHeight()/2);
	}
        
        public void movingAdd (int flag)
        {
        int j=0, k=0;
        
        if(moving.size()<3){
        for(int i=1; i<8; i++){
                        j= (int) (Math.random() * 6);
                        moving.add( new ImageObject(k ,40, pic[j],type[j]));
                        
                        j= (int) (Math.random() * 6);
                        k=k+60;
			moving.add( new ImageObject(( width - k),40,pic[j],type[j]));
                       // k = k+60;
                    
                }
       
        moving.add( new ImageObject(360 ,100, pic[6],type[6]));
        moving.add( new ImageObject((width - 420 ),100,pic[j],type[j]));
        int y=160;
         for(int i=1; i<8; i++){
                        j= (int) (Math.random() * 6);
                        moving.add( new ImageObject(360 ,y, pic[j],type[j]));
                        
                        j= (int) (Math.random() * 6);
                        moving.add( new ImageObject(( width - 420),y,pic[j],type[j]));
                        y=y+60;
                        
                }
           State s=new State();
                     s.getnextstate();
        moving.add( new ImageObject(360 ,y, pic[j],type[j]));
        moving.add( new ImageObject((width - 420 ),y,pic[6],type[6]));
        if (flag >=1)
        {
          moving.remove(0);
          moving.remove(0);
          
        }
        control.get(0).setX(width/2-80);
                
        }
        }
        
       public void adjustLRarrays (int k)
       {    
            int  i;
            System.out.println("k"+k);
            for(i=0  ; i< li; i++)
                if (left[i]>k)
                    left[i] = left[i] - 1;
            for(i=0  ; i< ri; i++)
                if (right[i]>k)
                    right[i] = right[i] - 1;
       
           
       }
      

       public void getaction (int lorr)
       {
          if(lorr==1)
          {
            if(li>2)
            {
              int typeone=  ((ImageObject)control.get(left[li-1])).getType();   
              int typetwo= ((ImageObject)control.get(left[li-2])).getType();
              int typethree=((ImageObject)control.get(left[li-3])).getType();
              if(typeone==typetwo&&typetwo==typethree)
                {
                    score = Math.max(0, score+10);
                    control.remove(left[li-1]);
                    adjustLRarrays(left[li-1]);
                    control.remove(left[li-2]);
                    adjustLRarrays(left[li-2]);
                    control.remove(left[li-3]);
                    adjustLRarrays(left[li-3]);
                    this.audio("D:\\Java\\Java FinalProject\\Sample\\res\\shalaboka.wav");
                    li=li-3;
                    if(li>0)
                        lli=left[li-1];
                     else
                        lli=0;
                    if(ri>0)
                       lri=right[ri-1];
                     else
                        lri=0;
                   

                }
            }   
          }
          if(lorr==2)
          {
            if(ri>2)
            {
              int typeone=  ((ImageObject)control.get(right[ri-1])).getType();   
              int typetwo= ((ImageObject)control.get(right[ri-2])).getType();
              int typethree=((ImageObject)control.get(right[ri-3])).getType();
              if(typeone==typetwo&&typetwo==typethree)
                {
                    score = Math.max(0, score+10);
                    control.remove(right[ri-1]);
                    adjustLRarrays(right[ri-1]);
                    control.remove(right[ri-2]);
                    adjustLRarrays(right[ri-2]);
                    control.remove(right[ri-3]);
                    adjustLRarrays(right[ri-3]);
 this.audio("D:\\Java\\Java FinalProject\\Sample\\res\\shalaboka.wav");
                    ri=ri-3;
                    if(ri>0)
                       lri=right[ri-1];
                     else
                        lri=0;
                    if(li>0)
                        lli=left[li-1];
                     else
                        lli=0;

                }
            }   
          }
        
         u.setUserscore(score);
           
       }
       public void adjustControlPosition()
       {
           int i;
           GameObject clownr, clownl ,m;
                        clownr=control.get(0);
                        for  (i=0; i<ri; i++)
                        {m=control.get(right[i]);
                         m.setX(clownr.getX()+clownr.getWidth()- m.getWidth());
                         m.setY(clownr.getY()-20);
                         clownr=m;   
                        }
                        clownl=control.get(0);
                        for  (i=0; i<li; i++)
                        {m=control.get(left[i]);
              		 m.setX(clownl.getX());
                         m.setY(clownl.getY()-20);
                         clownl=m;   
                        }
       }                
     
//------------------------------------
	@Override
	public boolean refresh() {
		 timeout = System.currentTimeMillis() - startTime > MAX_TIME; // time end and game over
		GameObject clownl= control.get(lli);
                GameObject clownr=control.get(lri);
                
		// moving starts
                this.movingAdd(1);
                int i;
//		for(GameObject m : moving){
                for (i=0; i< moving.size(); i++){
                  
                    ImageObject m;
                     m = (ImageObject) moving.get(i);
                     if ((m.getX() < 360) || (m.getX() > getWidth()-420))
                         if (m.getX() < getWidth()/2) 
                             m.setX((m.getX() + 1));
                         else
                             m.setX((m.getX() - 1));
                     else
                     {
 			m.setY((m.getY() + 1));
			if(m.getY()>640){
                                {
                                m.setY(40);
                                if (m.getX() > getWidth()/2)
                                    m.setX(getWidth() -60);
                                else
                                    m.setX(0);
                                }
                        }

                     }
			if(!timeout & intersectleft(m,clownl) ){
                                    
                		m.setX(clownl.getX());
                                m.setY(clownl.getY()-20);
				control.add(m);
                                moving.remove(i);
                                lli=control.indexOf(m);
                                left[ li] = lli;
                                li++;

                                if(m.getType()==0){
                                   timeout=true;
                                   MAX_TIME=0;
                                   this.audio("D:\\Java\\Java FinalProject\\Sample\\res\\ad.wav");
                                   break;   
                                 }
                                System.out.println("1Br"+lri+","+ri+"-->l"+lli+","+li);
                                this.getaction(1);
                                System.out.println("1Ar"+lri+","+ri+"-->l"+lli+","+li);
                                
                        }
                        if(!timeout & intersectright(m, clownr) ) {
                                m.setX(clownr.getX()+clownr.getWidth()- m.getWidth());
                                m.setY(clownr.getY()-20);
				control.add(m);
                                moving.remove(i);
                                lri=control.indexOf(m);
                                
                                right[  ri  ] =lri;
                                ri++;
                                if(m.getType()==0){
                                   timeout=true;
                                   MAX_TIME=0;
                                   this.audio("D:\\Java\\Java FinalProject\\Sample\\res\\ad.wav");
                                   break;
                                }
                                System.out.println("2Br"+lri+","+ri+"-->l"+lli+","+li);
                                this.getaction(2);
                                System.out.println("2Ar"+lri+","+ri+"-->l"+lli+","+li);

                                
                       }
                        this.adjustControlPosition();
                      
                       // if(1000<clownl.getX()){
                                //  m.setX(clownl.getX());
                                 // System.out.println("2");
                           //control.remove(i);
                           //m=control.get(i);
                           //constant.add(i, m);
                          //  m.setY(clownl.getY());
                       //   moving.add(m);
                    //   }
                              
		}
                
		// collecting astronauts
                /*------------- MY-B
		for(GameObject c : constant){
			if(c.isVisible()){
				if(intersect(c, spaceShip)){
					score++;	// get score
					((ImageObject)c).setVisible(false);
				}else if(Math.random() > 0.999)
					((ImageObject)c).setVisible(false);	// lost the astronauts
			}else{
				((ImageObject)c).setVisible(true);
				// reuse the astronaut in another position
				c.setX((int)(getWidth()*0.9*Math.random()));
				c.setY((int)(getHeight()*0.9*Math.random()));
			}
		}
                MY-E--------------*/
                
		return !timeout;
	}
               public void audio(String path){
            
             File f = new File(path);
    AudioInputStream audioIn;  
        try {
            audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());
              Clip clip = AudioSystem.getClip();
    clip.open(audioIn);
    clip.start();
        } catch (MalformedURLException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        }
        
	@Override
	public int getSpeed() {	
		
               return strategy.getSpeed();
	}
	@Override
	public int getControlSpeed() {	
		return 10;
	}
	@Override
	public List<GameObject> getConstantObjects() {	
		return constant;	
	}
	@Override
	public List<GameObject> getMovableObjects() {	
		return moving;	
	}
	@Override
	public List<GameObject> getControlableObjects() {	
		return control;	
	}
	@Override
	public int getWidth() {	
		return width; 
	}
	@Override
	public int getHeight() { 
		return height; 
	}
	@Override
	public String getStatus() {
		return "Score=" + score + "   |   Time=" + Math.max(0, (MAX_TIME - (System.currentTimeMillis()-startTime))/1000);	// update status
	}
}