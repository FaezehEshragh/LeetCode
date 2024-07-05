package Mine2024.TopKFrequentElements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.BiFunction;

class Solution {

    public static void main(String[] args){
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        Solution s= new Solution();
        int[] result = s.topKFrequent(nums, k);
        for(int i= 0; i<k;i++)
        {
            System.out.println(result[i]);
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];

        Map<Integer,Integer> map = new HashMap<>();

        PriorityQueue<NumFreq> pq = new PriorityQueue<>((a,b)-> (b.frequency-a.frequency));

        for(int i= 0; i<nums.length; i++){
            map.computeIfPresent(nums[i], (currentIndex, currentValue)-> currentValue+1);
            map.putIfAbsent(nums[i], 1);
        }
//Could do this instead
//        for (int num : nums) {
//            map.put(num, frequencyMap.getOrDefault(num, 0) + 1);
//        }

        for(Integer key:map.keySet()){
            NumFreq numFreq = new NumFreq(key, map.get(key));
            pq.offer(numFreq);

        }

        for(int j= 0; j<k; j++){
            result[j] = pq.poll().number;
        }

        return result;
    }

    public class NumFreq{
        int number;
        int frequency;

        public NumFreq(int number, int frequency)
        {
            this.number = number;
            this.frequency = frequency;
        }
    }
}
