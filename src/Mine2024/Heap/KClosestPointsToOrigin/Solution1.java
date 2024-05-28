package Mine2024.Heap.KClosestPointsToOrigin;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution1
{
    public static void main(String[] args) {
        int[][] points = {{3,3},{5,-1},{-2,4}};
        int k = 2;
        Solution1 s = new Solution1();
        int[][] result = s.kClosest(points, k);
        System.out.println(result);
    }
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> closests = new PriorityQueue<>(new PointComparator());

        for(int[] point:points){  //O(NLogN)
            closests.add(point);
            // if(closests.size()>k){
            //     closests.poll();
            // }
        }

        int[][] result = new int[k][2];
        for(int i=0;i<k;i++){ //O(NLogN)
            result[i]=closests.remove();
        }
        return result;

    }

    public double calcDistanceToCenter(int[] point1){
        return Math.sqrt(Math.pow(point1[0],2)+Math.pow(point1[1],2));
    }

    class PointComparator implements Comparator<int[]>
    {

        // Overriding compare()method of Comparator
        // for descending order of distance
        public int compare(int[] a, int[] b) {
            if ( calcDistanceToCenter(a)< calcDistanceToCenter(b))
                return -1;
            else if ( calcDistanceToCenter(a)> calcDistanceToCenter(b))
                return 1;
            return 0;
        }
    }
}
