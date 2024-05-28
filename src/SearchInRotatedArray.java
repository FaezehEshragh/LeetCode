import java.util.Arrays;

public class SearchInRotatedArray {
  public static void main(String[] args) {

    int[] nums={1};
    int result=search(nums,0);
    System.out.println("done: "+result);


  }
  public static int search(int[] nums, int target) {
    //find pivot
    // using to index start and end

    if(nums.length==1){
      if(nums[0]==target){
        return 0;
      }else{
        return -1;
      }
    }
    int pivot=0;
    int index=0;
    int firstElement=nums[0];
    int endElement=nums[nums.length-1];
    if(firstElement<=endElement){
      index= Arrays.binarySearch(nums,target);
    }else{ //find pivot
      int low=0;
      int high=nums.length-1;
      while (low <= high) {
        int mid = low  + ((high - low) / 2);
        if(nums[mid]>nums[mid+1]){
          pivot=mid;
          break;
        }else{
          if(nums[mid]>nums[high]){
            low=mid;
          }else if(nums[mid]<nums[low]){
            high=mid;
          }
        }
      }
    }

    if(nums[0]<=target && target<=nums[pivot]){
      index=Arrays.binarySearch(nums,0,pivot+1,target);
    }else if(nums[pivot+1]<=target && target<=nums[nums.length-1]){
      index= Arrays.binarySearch(nums,pivot+1,nums.length,target);
    }else{
      index=-1;
    }

    return index>=0?index:-1;

  }
}
