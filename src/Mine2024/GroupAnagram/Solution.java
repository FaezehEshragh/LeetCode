package Mine2024.GroupAnagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


//Runtime 6  ms  Beats 97.62% of users with Java
//Memory 47.48 MB  Beats 84.06% of users with Java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> output = new ArrayList<>();

        HashMap<String,List<String>> sortedMap = new HashMap<>();

        for(String str:strs){
            char[] strArray = str.toCharArray();
            Arrays.sort(strArray);
            String sortedStr= new String(strArray);
            if(sortedMap.get(sortedStr)!=null){
                sortedMap.get(sortedStr).add(str);
            }else{
                List<String> list=new ArrayList<>();
                list.add(str);
                sortedMap.put(sortedStr, list);
            }
        }

        for (String sortedStr: sortedMap.keySet()) {
            output.add(sortedMap.get(sortedStr));
        }
        return output;
    }
}
