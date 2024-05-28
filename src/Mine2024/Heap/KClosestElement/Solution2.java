package Mine2024.Heap.KClosestElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2  // notice that the input is a SORTED list =>//O(K)
{
    public static void main(String[] args) {
        int[] arr = {0,0,1,2,3,3,4,7,7,8};
        int k = 3;
        int x = 5;
        List<Integer> result = findClosestElements(arr, k, x);
        System.out.println(result);
    }
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {


        List result = new ArrayList<>();
        int index = Arrays.binarySearch(arr, x);
        int insertIndex = index<0? -index-1:index;
        int left = insertIndex-(k)>0? insertIndex-(k):0;
        int right =  insertIndex+(k) <arr.length? insertIndex+(k):arr.length-1;

        while((left+k)<=right){
            if(Math.abs(arr[left]-x)>Math.abs(arr[right]-x)){
                left++;
            }else{
                right--;
            }

        }

        for (int i=left;i<=right;i++){
            result.add(arr[i]);
        }
        return result;

    }
}
