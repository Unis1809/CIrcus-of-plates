/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mains;

import static info.Game.records;
import info.Users;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.Iterator;
/**
 *
 * @author king
 */
public class filescore {
  /*  public void readFromFile()
    {
    try{    
        String filename = new String();
   
      File file = new File (filename);  
      Scanner sc = new Scanner (file);  
      while(sc.hasNextLine())
      {
       String n = sc.nextLine();
       records.add(n);
          
      }
      sc.close();
    } catch  (FileNotFoundException e)
    {
        System.out.println("error");
    }
        
    }*/
    public void read(String filename){
       JSONParser p=new JSONParser();
         Object ob;
        try {
            ob = p.parse(new FileReader(filename));
              JSONArray a=   (JSONArray)ob;
              for(int i=0;i<a.size();i++)
          {
              JSONObject jo=(JSONObject) a.get(i);
              
               String usern = (String) jo.get("Name");
         //System.out.println(shname);
       
            // System.out.println("Circle");
             String userscore = (String) jo.get("score"); 
             int scor=Integer.parseInt(userscore);
             
          Users u =new Users(usern,scor);
              
            records.add(u);   
          }
          
        } catch (FileNotFoundException ex) {
            Logger.getLogger(filescore.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(filescore.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(filescore.class.getName()).log(Level.SEVERE, null, ex);
        }
          
           
         
          
     
       
       
       
       
       
       
       
   }


    public void save(String filename)
   {
       int i;
        JSONArray list=new JSONArray();
     
     for(i=0;i<records.size();i++)
     {
             JSONObject obj=new JSONObject(); 
     
         obj.put("Name",records.get(i).getUsername() );
              obj.put("score", Integer.toString(records.get(i).getUserscore()));
       
         
     
       list.add(obj);
      
     }
      // obj.put("Shapes", list);
       try(FileWriter g=new FileWriter(filename)){
           g.write(list.toString());
           g.flush();
           
           
       } catch (IOException ex) {
          ex.getStackTrace();
       }

}
}