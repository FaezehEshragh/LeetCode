import java.util.Arrays;
import java.util.HashMap;

public class SearchRange {
  public static void main(String[] args) {

    int[] nums={2,2};
    int[] result=searchRange(nums,2);
    System.out.println("done: "+result[0]+","+result[1]);


  }
  public static int[] searchRange(int[] nums, int target) {

    int[] result={-1,-1};

    //find one
    int firstFoundIndex= Arrays.binarySearch(nums,target);


    if(firstFoundIndex>=0){ //found at least one
      result[0] =firstFoundIndex;
      result[1]=firstFoundIndex;
      //find start
      int startIndex=firstFoundIndex;
      while(startIndex>=0) { //???
        result[0] = startIndex;
        startIndex = Arrays.binarySearch(nums, 0, startIndex , target);
      }
      int endIndex=firstFoundIndex;
      while(endIndex>=0) { //???
        result[1] = endIndex;
        if((endIndex+1)!=(nums.length-1))
          endIndex = Arrays.binarySearch(nums, endIndex+1, nums.length-1, target);
        else{
          if(nums[endIndex+1]==target)
            endIndex++;
            result[1] = endIndex;
          break;
        }

      }

    }


    return result;
  }

}



