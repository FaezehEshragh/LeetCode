public class rotationCypher {
  public static void main(String[] args) {
    String input="abcdZXYzxy-999.@";
    String output=rotationalCipher(input,200);
    System.out.println(output);
    System.out.println(output.equals("stuvRPQrpq-999.@"));
  }

  public static String rotationalCipher(String input, int rotationFactor) {
    String result ="";
    for(int i=0;i<input.length();i++){
      char c=input.charAt(i);
      if(!Character.isLetterOrDigit(c)){
        result+=c;
      }else{
        int originalNumericValue=c;
        int numericValue;
        char replacement='t';
        if(c>='a'&& c<='z'){
          int rotationFactorletter=rotationFactor%26;
          numericValue=originalNumericValue+rotationFactorletter;
          while(numericValue>122){
            numericValue-=26;
          }
          replacement=(char)numericValue;
        }else if(c>='A' && c<='Z'){
          int rotationFactorletter=rotationFactor%26;
          numericValue=originalNumericValue+rotationFactor;
          while(numericValue>90){
            numericValue-=26;
          }
          replacement=(char)numericValue;
        }else if(Character.isDigit(c)){
          int rotationFactornumber=rotationFactor%10;
          numericValue=c+rotationFactornumber;
          while(numericValue>57){
            numericValue-=10;
          }
          replacement=(char)numericValue;
        }
        result+=replacement;
      }
    }
    return result;
  }

}
