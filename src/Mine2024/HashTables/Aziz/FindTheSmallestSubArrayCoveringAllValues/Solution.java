package Mine2024.HashTables.Aziz.FindTheSmallestSubArrayCoveringAllValues;

import java.util.HashMap;
import java.util.Map;

public class Solution
{

    public static void main(String[] args){
        String[] arr = {"apple", "banana", "apple", "apple", "dog", "cat", "apple", "dog", "banana", "apple", "cat", "dog"};
        String[] values = {"banana", "cat", "dog"};
        int[] result = findSmallestSubArray(arr, values);
        System.out.println(result[0] + " " + result[1]);
    }

    private static int[] findSmallestSubArray(String[] paragraph, String[] searchWords)
    {
        int[] result =  {-1,-1};

        int left = 0;
        int right = 0;
        int minSubArrayLength = Integer.MAX_VALUE;
        int remainingWords = searchWords.length;
        Map<String,Integer> searchWordsMap = new HashMap<>();
        for(String word:searchWords){
            if(searchWordsMap.get(word)!=null){
                searchWordsMap.put(word, searchWordsMap.get(word)+1);
            }else{
                searchWordsMap.put(word,1);
            }
        }
        while(right<paragraph.length-1 )
        {
            //advance right till you see all the search words and remainingWords gets to 0
                if (searchWordsMap.get(paragraph[right]) != null && searchWordsMap.get(paragraph[right])!=0 )
                {
                    int wordCount = searchWordsMap.get(paragraph[right]);
                    if (wordCount == 1)
                    {
                        remainingWords--;
                    }
                    searchWordsMap.put(paragraph[right], wordCount - 1);

                }
                if(remainingWords==0){
                    result[0]=left;
                    result[1]=right;
                    minSubArrayLength = Math.min(minSubArrayLength, right-left+1);
                } else
                {
                    right++;
                }

            //won't get in here unless we have all the search words between left and right
            //and won't get out of this loop unless left reaches a search word which means advancing from left will add one word to the remaining count
            while(left< right  && remainingWords == 0){
                while (left< right  && (searchWordsMap.get(paragraph[left])==null)){
                    left++;
                }
                if(left< right )
                {
                    result[0] = left;
                    minSubArrayLength = Math.min(minSubArrayLength, right - left + 1);
                    // the next left will not form a result subarray with the right index
                    searchWordsMap.put(paragraph[left], 1);
                    left++;
                    right++;
                    remainingWords++;
                }
            }



        }



        return result;
    }


}
