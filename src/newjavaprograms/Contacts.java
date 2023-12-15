/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newjavaprograms;

/**
 *
 * @author Admin
 */
public class Contacts {
    
    String name;
    String phoneNumber;
//    Contacts con = new Contacts(name, phoneNumber);
    @Override
    public String toString(){
        return phoneNumber;
    }
    
    
    public Contacts(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
//    public static void main(String[] args) {
//        System.out.println(phoneNumber.toString());
//    }
    
}
