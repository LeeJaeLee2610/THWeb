/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Legion 5
 */
public class User {
    private int ip;
    private String user;
    private String pass;

    public User() {
    }

    public User(int ip, String user, String pass) {
        this.ip = ip;
        this.user = user;
        this.pass = pass;
    }

    public User(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }
    
    

    public int getIp() {
        return ip;
    }

    public void setIp(int ip) {
        this.ip = ip;
    }

    

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    
}
