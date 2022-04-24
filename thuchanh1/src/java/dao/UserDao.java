/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dbHelper.DatabaseHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.User;

/**
 *
 * @author Legion 5
 */
public class UserDao {
    public List<User> getAll(){
        List<User> list = new ArrayList<>();
        String sql = "select * from user_demo";
        try {
            Connection con = DatabaseHelper.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                User u = new User();
                u.setUser(rs.getString("username"));
                u.setPass(rs.getString("password"));
                list.add(u);
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public User layIP(String username) throws Exception{
        String sql = "select * from user_demo where username = ?";
        try (
            Connection con = DatabaseHelper.getConnection();
            PreparedStatement ps = con.prepareCall(sql);
                ){
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                User u = new User();
                u.setIp(rs.getInt("ip"));
                u.setPass(rs.getString("password"));
                return u;
            }
            return null;
        }
        
    }
    
    public boolean insert(User user) throws Exception{
        String sql = "insert into user_demo(username, password) values(?, ?)";
        try(
            Connection con = DatabaseHelper.getConnection();
            PreparedStatement ps = con.prepareCall(sql);
        ) {
            ps.setString(1, user.getUser());
            ps.setString(2, user.getPass());
            return ps.executeUpdate() > 0;
        }
    }
    
    public static void main(String args[]) throws Exception{
        UserDao tmp = new UserDao();
        List<User> list = tmp.getAll();
        for(User i:list){
            System.out.println(i.getUser() + " " + i.getPass());
        }
//        User user = new User("admin", "1");
//        tmp.insert(user);
//        User u = tmp.layIP("cuong");
//        if(u != null){
//            System.out.println(u.getIp());
//        }
    }
}
