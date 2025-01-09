class Solution {
    public int maxArea(int[] height) {
        int i=0;
        int j = height.length-1;
        int area=0;
        int m=0;
        while(i<=j){
            int temp = j-i;
            area =temp * Math.min(height[i],height[j]);
            if(m<area)
               m = area;
            if(height[i]<height[j])
                i++;
            else
                j--;
        }
        return m;
    }
}