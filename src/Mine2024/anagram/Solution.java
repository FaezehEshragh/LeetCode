package Mine2024.anagram;

import java.util.HashMap;


//first solution:
//Runtime 15 ms Beats 27.57% of users with Java
//Memory 45.19 MB Beats 5.10% of users with Java
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character,Integer> chars = new HashMap<Character,Integer>();
        for(char ch : s.toCharArray()){
            if(chars.get(ch)!=null){
                chars.put(ch,chars.get(ch)+1 );
            }else{
                chars.put(ch,1);
            }
        }

        for(char ch : t.toCharArray()){
            if(chars.get(ch)!=null && chars.get(ch)!=0){
                chars.put(ch,chars.get(ch)-1 );
            }else{
                return false;
            }
        }

        return true;



    }
}
