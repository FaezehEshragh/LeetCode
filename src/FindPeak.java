public class FindPeak {

  public static void main(String[] arg){
    int[] nums={5,4,3,2};
    int result=findPeakElement(nums);
    System.out.println("done: "+result);
  }
  public static int findPeakElement(int[] nums) {
    if(nums.length==1){
      return 0;
    }

    int low=0;
    int high=nums.length-1;
    while(low<high){

      int mid=low+(high-low)/2;
      System.out.println("low="+low+",high="+high+",mid="+mid);
      int before=Integer.MIN_VALUE;
      int after=Integer.MIN_VALUE;

      if(mid!=0){
        before=nums[mid-1];
      }
      if(mid!=nums.length-1){
        after=nums[mid+1];
      }
      if(before<nums[mid] && nums[mid]>after)
        return mid;
      else if(before<nums[mid] && nums[mid]<after){//increasing, move to the right
        low=mid;
      }
      else if((before>nums[mid] && nums[mid]>after)){//decreasing, move to the left
        high=mid;
      }else{ //fall into a vally
        low=mid;
      }
      if(low==high-1 && nums[low]<nums[high]){
        return high;
      }
    }
    return -1;
  }
}
