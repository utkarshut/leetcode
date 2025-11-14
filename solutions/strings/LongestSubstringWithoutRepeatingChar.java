import java.util.*;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingChar{
    public static void main(String[] args){
     String str = "asvsdasefef";
     int storedIndex = 0;
     int res = 0;
     Map<Character, Integer> charMap = new HashMap<>();

     for(int i=0; i<str.length(); i++){
       Character c = str.charAt(i);
       if(charMap.containsKey(c)){
         storedIndex = Math.max(storedIndex, charMap.get(c)+1); 
       }    
       charMap.put(c,i);
       res = Math.max(res,i-storedIndex+1);
     }

     System.out.println(res);
    }
}