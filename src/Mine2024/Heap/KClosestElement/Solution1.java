package Mine2024.Heap.KClosestElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Solution1
{

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k = 4;
        int x = 3;
        Solution1 s = new Solution1();
        List<Integer> result = s.findClosestElements(arr, k, x);
        System.out.println(result);
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k-1,new ElementComparator(x));

        int maxDistance = Integer.MIN_VALUE;;
        for (int element:arr){
            if (!(minHeap.size() == k && Math.abs(element-x)>maxDistance)){
                maxDistance = Math.max(Math.abs(element-x), maxDistance);
                minHeap.add(element);
            }
        }

        List<Integer> result = new ArrayList<>(minHeap);

        // for(int i=0;i<k;i++){
        //     result.add(minHeap.remove());

        // }
        Collections.sort(result);
        return result;

    }

        class ElementComparator implements Comparator<Integer>{
            private final int x;

            public ElementComparator(int x) {
                this.x = x;
            }
            // Overriding compare()method of Comparator
            // for descending order of cgpa
            public int compare(Integer a, Integer b) {
                if (Math.abs(a-x) < Math.abs(b-x))
                    return -1;
                else if (Math.abs(a-x) > Math.abs(b-x))
                    return 1;
                else if (Math.abs(a-x) == Math.abs(b-x) && a<b)
                    return -1;
                else if (Math.abs(a-x) == Math.abs(b-x) && b<a)
                    return 1;
                return 0;
            }
        }
    }

