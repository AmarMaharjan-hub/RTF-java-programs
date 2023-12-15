/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newjavaprograms;
import java.util.HashMap;
/**
 *
 * @author Admin
 */
public class PhoneBook {
    
    
    
    public static void main(String[] args) {
        HashMap<String,Contacts> info = new HashMap<>();
        
        info.put("Home", new Contacts("Ram","987654321"));
        info.put("Sim1", new Contacts("Ram", "982734234"));
        info.put("Ncell", new Contacts("Shyam", "92837423"));
        
        System.out.println(info);
    }
}
