import java.util.*;

public class Sum3 {
  public static void main(String[] args) {

    int[] input= {-1,0,1,2,-1,-4};
    List<List<Integer>> a=threeSum(input);
    System.out.println("done");

  }

  public static List<List<Integer>> threeSum(int[] nums) {
    ArrayList<List<Integer>> result=new ArrayList<List<Integer>>();

    Arrays.sort(nums);



    for(int i=nums.length-1;i>1;i--){
      int target=0-nums[i];
      int[] copiedNums = Arrays.copyOf(nums, i);
      List<List<Integer>> resultForThisElement=twoSum(copiedNums,target);

      for(int j=0;j<resultForThisElement.size();j++){
        resultForThisElement.get(j).add(nums[i]);
        result.add(resultForThisElement.get(j));
      }


    }

    return result;

  }

//     public List<List<Integer>> threeSum(int[] nums) {
//         ArrayList<List<Integer>> result=new ArrayList<List<Integer>>();


//         if(nums.length<3){
//             return result;
//         }

//         Arrays.sort(nums); //nlogn
//         if(nums[0]*nums[nums.length-1]>0) {//both positive or negative and non zero
//             return result;
//              }
//         int i=0;
//         int j=nums.length-1;
//         while(i<j){
//             int a= nums[i];
//             int b= nums[j];
//             int closestSumToZero=Integer.MAX_VALUE;
//             int k=i+1;
//             while(k<j){
//                 int sum=a+b+nums[k];
//                 if(sum==0){
//                     ArrayList<Integer> sum0=new ArrayList<Integer>();
//                     sum0.add(a);
//                     sum0.add(b);
//                     sum0.add(nums[k]);
//                     if(!result.contains(sum0))
//                       result.add(sum0);
//                 }else{
//                     if(sum<closestSumToZero){
//                         closestSumToZero=sum;
//                     }
//                 }
//                 k++;
//             }
//             if(closestSumToZero<0){
//                 i++;
//             }else{
//                 j--;
//             }
//         }
//         return result;
//     }


  public static List<List<Integer>> twoSum(int[] nums, int target) {
    int[] output=new int[2];

    ArrayList<List<Integer>> result=new ArrayList<List<Integer>>();
    Map<Integer,Integer> map=new HashMap<Integer,Integer>();

    for(int i=0;i<nums.length;i++){
      if(map.get(target-nums[i])!=null && map.get(target-nums[i])==0 ){
        List<Integer> res=new ArrayList<Integer>();
        res.add(target-nums[i]);
        res.add(nums[i]);
        result.add(res);
        map.put(target-nums[i],1);
      }else{
        map.put(nums[i],0);
      }
    }

    return result;
  }
}
