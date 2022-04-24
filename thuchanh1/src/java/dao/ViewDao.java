/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dbHelper.DatabaseHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Legion 5
 */
public class ViewDao {
    public int getView(){
        String sql = "select * from view_demo";
        int dem = 0;
        try {
            Connection con = DatabaseHelper.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                dem =  rs.getInt("viewed");
            }
        } catch (Exception e) {
        }
        return dem;
    }
    
    public void updateView(){
        String sql = "update view_demo set viewed = viewed + 1";
        try {
            Connection con = DatabaseHelper.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public static void main(String args[]){
        ViewDao tmp = new ViewDao();
        tmp.updateView();
    }
}
