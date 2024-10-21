package Mine2024.uniquePaths;

import java.util.HashMap;
import java.util.Map;

class Solution {
  Map<Pair, Integer> memo = new HashMap<>();
  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.uniquePaths(3, 7));
  }
  public int uniquePaths(int m, int n) {
    if(n==1 || m==1)
      return 1;

    Pair pair = new Pair(m,n);
    if(memo.containsKey(pair)){
      return memo.get(pair);
    }
    int result = uniquePaths(m-1,n)+uniquePaths(m,n-1);
      memo.put(pair,result);
    return result;

  }

  public class Pair{
    int x;
    int y;
    public Pair(int x, int y){
      this.x=x;
      this.y=y;
    }
  }
}
