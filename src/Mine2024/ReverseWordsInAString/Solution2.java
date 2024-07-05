package Mine2024.ReverseWordsInAString;

import java.util.Arrays;
import java.util.Collections;

class Solution2 {
    public String reverseWords(String s) {

        String result="";
        s= s.trim();
        String[] words= s.split("\\s+");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);

    }
}
