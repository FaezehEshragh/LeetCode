import java.util.List;

public class minSubArrayLen {
  public static void main(String[] args) {

    int[] input= {2,3,1,2,4,3};
    int target=7;
    int a=minSubArrayLen(target,input);
    System.out.println(a);

  }

  public static int minSubArrayLen(int target, int[] nums) {
    int minSize=Integer.MAX_VALUE;
    int startIndex=0;
    int endIndex=0;
    int sum=nums[startIndex];
    while(startIndex<nums.length){
      if(sum<target && endIndex<nums.length-1){
        endIndex++;
        sum+=nums[endIndex];

      }else{
        int windowSize=endIndex-startIndex;
        if(windowSize<minSize){
          minSize=windowSize;
        }
        sum-=nums[startIndex];
        startIndex++;
      }
    }

    if(minSize<Integer.MAX_VALUE){
      return minSize;
    }else{
      return 0;
    }

  }
}
