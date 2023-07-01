/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package info;

/**
 *
 * @author king
 */
public class Users {
  
    public  String username;
    public   int userscore;

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUserscore() {
        return this.userscore;
    }

    public void setUserscore(int userscore) {
        this.userscore = userscore;
    }
   public Users(String username, int userscore) {
        this.username = username;
        this.userscore = userscore;
       // Game.records.add(this);
    }
    

   

   
    
}
