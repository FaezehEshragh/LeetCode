import java.util.Arrays;

public class productSubarray {

  public static void main(String[] arg){
    int[] nums={10,9,10,4,3,8,3,3,6,2,10,10,9,3};
    int result=numSubarrayProductLessThanK(nums,19);
    System.out.println("done: "+result);
  }
  public static int numSubarrayProductLessThanK(int[] nums, int k) {
    if (k <= 1) return 0;
    int prod = 1, ans = 0, left = 0;
    for (int right = 0; right < nums.length; right++) {
      prod *= nums[right];
      while (prod >= k) prod /= nums[left++];
      ans += right - left + 1;
    }
    return ans;
  }
  }

