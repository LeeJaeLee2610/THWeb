/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IOFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import model.User;

/**
 *
 * @author Legion 5
 */
public class UserIO {
    public static void viet(User user, String fileName){
        try {
            File file = new File(fileName);
            PrintWriter pw = new PrintWriter(new FileWriter(fileName, true));
            pw.println(user.getUser() + " " + user.getPass());
            pw.close();
        } catch (Exception e) {
        }
    }
    
    public static String doc(String fileName){
        String res = "";
        try {
            File file = new File(fileName);
            InputStreamReader isr = new InputStreamReader(new FileInputStream(file));
            BufferedReader reader = new BufferedReader(isr);
            String line = "";
            while((line = reader.readLine()) != null){
                res += line + " ";
            }
        } catch (Exception e) {
        }
        return res;
    }
    
    public static void main(String args[]){
        UserIO tmp = new UserIO();
        List<String> list = new ArrayList<>();
        System.out.println(tmp.doc("D:/webPTIT/THWeb/thuchanh1/web/WEB-INF/Login.txt"));
    }
}
