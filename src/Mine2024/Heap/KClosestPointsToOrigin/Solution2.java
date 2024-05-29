package Mine2024.Heap.KClosestPointsToOrigin;

import java.util.PriorityQueue;

public class Solution2
{
    public static void main(String[] args) {
        int[][] points = {{3,3},{5,-1},{-2,4}};
        int k = 2;
        Solution2 s = new Solution2();
        int[][] result = s.kClosest(points, k);
        System.out.println(result);
    }
    public int[][] kClosest(int[][] points, int k) {

        // Defining the comparator like this will make the heap a max heap.
        // Using the lambda function will make the code run faster per leetcode but doesn't affect the time complexity.
        PriorityQueue<int[]> closests =new PriorityQueue<>((a, b) -> (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1]));

        for(int[] point:points){ // O(NlogK)

            closests.add(point);
            if(closests.size()>k){
                closests.poll();
            }

        }

        int[][] result = new int[k][2];
        int w = 0;
        while (!closests.isEmpty()) { // O(KlogK)
            result[w++] = closests.poll();
        }

        return result;

    }
}

