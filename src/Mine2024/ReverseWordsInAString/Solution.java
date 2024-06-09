package Mine2024.ReverseWordsInAString;


class Solution {
    public static void main(String[] arg){

        String s = "the sky is  blue";
        Solution solution = new Solution();
        String result = solution.reverseWords(s);
        System.out.println(result);
    }
    public String reverseWords(String s) {

        String result="";
        s= s.trim();
        s= s.replaceAll("\\s+"," ");
        String[] words= s.split(" ");
        for(int i=words.length-1;i>0;i--){
           result = result.concat(words[i] + " ");
        }
        result = result.concat(words[0]);

        return result;

    }
}
