import java.util.List;
import java.util.Stack;

public class backspaceString {
  public static void main(String[] args) {

//    String s="db##",t= "c#d#";
//    String s="ab##", t = "c#d#";
    String s = "a##c", t = "#a#c";
    boolean a=backspaceCompare(s,t);
    System.out.println(a);

  }
  public static boolean backspaceCompare(String s, String t) { //stack: space:o(n)
    s=applyBackspace(s);
    s=s.replace("#","");
    t=applyBackspace(t);
    t=t.replace("#","");

    return s.equals(t);
  }

//without stack
  public static String applyBackspace(String s) {
    int NoOfBS = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
      char c = s.charAt(i);
      if (c == '#') {
        NoOfBS++;
      } else {
        if (NoOfBS > 0) { //replace c with #
          s = replaceCharUsingCharArray(s, '#', i);
          NoOfBS--;

        }
      }

    }
      return s;

  }

  public static String replaceCharUsingCharArray(String str, char ch, int index) {
    char[] chars = str.toCharArray();
    chars[index] = ch;
    return String.valueOf(chars);
  }

  //using stack

//  public static String applyBackspace(String s) {
//    //using stack
//    Stack<Character> stack=new Stack<Character>();
//    for(int i=0;i<s.length();i++){
//      char c=s.charAt(i);
//    if(c=='#' && !stack.empty()){
//      stack.pop();
//    }else{
//      stack.push(c);
//    }
//    }
//    return String.valueOf(stack);
//
//  }


//public static String applyBackspace(String s){
//  for(int i=0;i<s.length();i++){
//    char c=s.charAt(i);
//    if(c=='#'){
//      char bs;
//      int numOfBS = 1;
//      String replacement = "#";
//      if(i+1<s.length()) {
//        bs = s.charAt(i + numOfBS);
//        while (bs == '#' && i + numOfBS < s.length()) {
//          replacement += "#";
//          numOfBS++;
//          bs = s.charAt(i + numOfBS);
//        }
//      }
//      if(i>numOfBS){
//        s=s.substring(0,i-numOfBS)+replacement+s.substring(i,s.length());
//      }else if(i==numOfBS){
//        s=replacement+s.substring(i,s.length());
//      }
//    }
//  }
//return s;
//}

}
