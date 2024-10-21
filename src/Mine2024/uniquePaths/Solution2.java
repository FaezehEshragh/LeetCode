package Mine2024.uniquePaths;

public class Solution2 {

  public static void main(String[] args) {
    Solution2 solution = new Solution2();

    System.out.println(solution.uniquePaths(3, 7));
  }
  public int uniquePaths(int m, int n) {
    int[][] dp = new int[m][n];
    dp[0][0]=1;

    return calcPaths(m,n,dp);
  }

  public int calcPaths(int m, int n , int[][] dp){
    if(m==0 || n==0){
      return 0;
    }

    for(int i=0;i<m;i++){
      for(int j=0;j<n;j++){
        if(i==0 || j==0){
          dp[i][j]=1;
        } else{
          dp[i][j]= dp[i-1][j]+dp[i][j-1];
        }
      }
    }
    return dp[m-1][n-1];
  }
}
