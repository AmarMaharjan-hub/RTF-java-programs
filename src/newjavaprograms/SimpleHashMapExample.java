/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newjavaprograms;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 *
 * @author Admin
 */
public class SimpleHashMapExample {
    
    public static void main(String[] args) {
        //Creating simple Hash Map
        HashMap<String, Integer> simpleMap = new HashMap<>();
//        This can also be done
//        HashMap simpleMap = new HashMap<>();

        //Using put to insert value in map
        simpleMap.put("Hello",1);
        simpleMap.put("world",0);
        
        //size to get the size of the map
        System.out.println("size = " + simpleMap.size());
        
        System.out.println(simpleMap);
        
//        using containsKey to search for value using key
        if(simpleMap.containsKey("Hello")){
            System.out.println("Value of Hello is : " + simpleMap.get("Hello"));
        }
        
//        using containsValue
        if(simpleMap.containsValue(0)){
//            entrySet() declared by a Map interface returns a set containing the map entries
            for(Entry<String, Integer> entry: simpleMap.entrySet()){
                if(entry.getValue() == 0){
                    System.out.println("Key of value 0 is : " + entry.getKey());
                }
            }
            
//            If another way was used. simpleMap is an object that cannot be converted into Enty<Stirng,Integer>
//            HashMap<String, Integer> anoMap = new HashMap<>(simpleMap);
//            for(Entry<String, Integer> entry: anoMap.entrySet()){
//                if(entry.getValue() == 0){
//                    System.out.println("Key of value 0 is : " + entry.getKey());
//                }
//            }
        }else{
            System.out.println("There is no key with a value of 0");
        }
        
//        Duplicate entry of key replaces the key
        simpleMap.put("Hello", 12);
//        Using the remove key
        simpleMap.remove("world");
        simpleMap.put("Book", 12);
        simpleMap.put("Uni",22);
        if(!simpleMap.isEmpty()){
            System.out.println(simpleMap);
        }
    }
    
    
}
