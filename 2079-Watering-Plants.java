class Solution {
    public int wateringPlants(int[] plants, int cap) {
        int res = 0;
        int c = cap;
        for(int i=0;i<plants.length;i++){
            if(plants[i]<=c){
                c = c-plants[i];
                res++;
            }
            else{
                c = cap-plants[i];
                res = res+i+(i+1);
            }
        }
        return res;
    }
}