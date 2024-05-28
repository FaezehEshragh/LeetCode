import java.util.ArrayList;

public class IntervalIntersection {
  public static void main(String[] args)
  {
    ArrayList<int[]> result=new ArrayList<int[]>();
int[][] a={{10,12},{18,19}};
int[][] b= {{1,6},{8,11},{13,17},{19,20}};

//    int[][] a={{0,2},{5,10},{13,23},{24,25}};
//    int[][] b={{1,5},{8,12},{15,24},{25,26}};


//    int[][] a={{5,10}};
//    int[][] b={{3,10}};

//    int[][] a={{1,2}};
//    int[][] b={{3,4}};
    int[][] test=intervalIntersection(a,b);
    if(test.length>0) {
      for(int i=0;i<test.length;i++) {
        System.out.println("["+test[i][0]+","+test[i][1]+"]");
      }
    }else
      System.out.println("no intersection");
    }


  public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
    ArrayList<int[]> result=new ArrayList<int[]>();

    if (firstList.length==0 || secondList.length==0){
      int[][] a= {};
      return a;
    }

    int i=0;
    int j=0;
    while (i<firstList.length && j<secondList.length){
      int[] intersection=intersection(firstList[i],secondList[j]);
      if(intersection.length>0){
        result.add(intersection);
      }
      // i++? j++?
      if(secondList[j][1]>firstList[i][1]){
        i++;
      }else if(firstList[i][1]>secondList[j][1]){
        j++;
      }else{
        i++;
        j++;
      }
    }

    int[][] resultArray=new int[result.size()][2];
    int index=0;
    for(int[] a:result){
      resultArray[index]=a;
      index++;
    }
    return resultArray;

  }
  public static  int[] intersection(int[] alpha, int[] beta){
    int[] result={};
    if(beta[0]>alpha[1])
      return result;
    if(alpha[0]>beta[1])
      return result;


    result=new int[2];
//1
    if(alpha[0]<=beta[0] && alpha[1]>=beta[1]){
      result[0]=beta[0];
      result[1]=beta[1];
    }
//2
    if(beta[0]<=alpha[0] && beta[1]>=alpha[1]){
      result[0]=alpha[0];
      result[1]=alpha[1];
    }
//3
    if(alpha[0]<=beta[0] && alpha[1]<=beta[1]){
      result[0]=beta[0];
      result[1]=alpha[1];
    }
//4
    if(beta[0]<=alpha[0] && beta[1]<=alpha[1]){
      result[0]=alpha[0];
      result[1]=beta[1];

    }
    if(beta[1]==alpha[0]){
      result[0]=beta[1];
      result[1]=beta[1];
    }
    if(alpha[1]==beta[0]){
      result[0]=beta[0];
      result[1]=beta[0];
    }
    return result;
  }
}
