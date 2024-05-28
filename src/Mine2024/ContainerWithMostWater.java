package Mine2024;

class Solution {
    public int maxArea(int[] height) {
        int max=0;
        int i=0;
        int j=height.length-1;
        while(i<j){
            int[] firstPair={i,height[i]};
            int[] secondPair={j, height[j]};
            int area=calcArea(firstPair,secondPair);
            if (area>max){
                max=area;
            }
            if(height[i]>height[j]){
                j--;
            }else if(height[j]>height[i]){
                i++;
            }else{
                i++;
                j--;
            }


        }

        return max;
    }
    public int calcArea(int[] firstPair, int[] secondPair){
        return (Math.abs(firstPair[0]-secondPair[0])*Math.min(firstPair[1],secondPair[1]));
    }
}
