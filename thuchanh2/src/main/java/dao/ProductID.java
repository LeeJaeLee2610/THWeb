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
import java.util.regex.Pattern;
import model.Product;

/**
 *
 * @author LeeJaeLee
 */
public class ProductID {
    public List<Product> getAllProducts(){
        String sql = "select * from product";
        List<Product> list = new ArrayList<>();
        try {
            Connection con = DatabaseHelper.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public void addProduct(Product product){
        String sql = "insert into product(code, description, price) values(?, ?, ?)";
        try {
            Connection con = DatabaseHelper.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, product.getCode());
            ps.setString(2, product.getDescription());
            ps.setDouble(3, product.getPrice());
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public void updateProduct(String code, String des, String price){
        String sql = "update product set description = ?, price = ? where code = ?";
        try {
            Connection con = DatabaseHelper.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(3, code);
            ps.setString(1, des);
            ps.setString(2, price);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public void updateProduct1(String id, String code, String des, String price){
        String sql = "update product set code = ?, description = ?, price = ? where id = ?";
        try {
            Connection con = DatabaseHelper.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, code);
            ps.setString(2, des);
            ps.setString(3, price);
            ps.setString(4, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public void deleteProduct(String id){
        String sql = "delete from product where id = ?";
        try {
            Connection con = DatabaseHelper.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public Product getProductByID(String id){
        String sql = "select * from product where id = ?";
        try {
            Connection con = DatabaseHelper.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public static void main(String[] args) {
        ProductID pid = new ProductID();
        List<Product> list = pid.getAllProducts();
        for(Product p:list){
            System.out.println(p.getCode() + p.getDescription());
        }
        String reg = "^[0-9.]+";
        if(Pattern.matches(reg, "123.45")){
            System.out.println("Ok");
        }
        else{
            System.out.println("No");
        }
//        Product p = pid.getProductByID("1");
//        System.out.println(p.getDescription());
        String tmp = "27";
    }
}
