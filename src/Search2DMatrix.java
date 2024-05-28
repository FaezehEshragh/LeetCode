import java.util.Arrays;

public class Search2DMatrix {
  public static void main(String[] args) {
  int [][] matrix={{1}};
  boolean b=searchMatrix(matrix,0);
    System.out.println(b);

  }
  public static boolean searchMatrix(int[][] matrix, int target) {

    //find the right column
    int[] column0= findColumn(matrix,0);

    // find which row target can be in
    int indexInColumn= Arrays.binarySearch(column0,target);
    if(indexInColumn>=0){  //found tatget in the first column
      return true;
    }else{
      int row=(indexInColumn*-1)-2;
      if(row>=0) {
        int indexInRow = Arrays.binarySearch(matrix[row], target);
        if (indexInRow > 0) {
          return true;
        }
      }
    }

    return false;

  }

  public static int[] findColumn(int[][] matrix, int coulmnNumber){

    int[] column=new int[matrix.length];
    for (int i=0;i<matrix.length;i++){
      column[i]=matrix[i][coulmnNumber];
    }
    return column;
  }
}
