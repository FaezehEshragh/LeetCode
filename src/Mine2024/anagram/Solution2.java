package Mine2024.anagram;

import java.util.Arrays;

//Runtime 4 ms Beats 74.05%of users with Java
//Memory 44.43MB Beats 41.25%of users with Java
class Solution2 {
    public boolean isAnagram(String s, String t) {
        char[] sArray=s.toCharArray();
        Arrays.sort(sArray);
        char[] tArray=t.toCharArray();
        Arrays.sort(tArray);
        if(Arrays.equals(sArray,tArray)){
            return true;
        }
        return false;

    }
}
