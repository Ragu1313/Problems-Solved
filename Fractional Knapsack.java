/*
Fractional Knapsack
Difficulty: MediumAccuracy: 32.46%Submissions: 268K+Points: 4
Given weights and values of n items, we need to put these items in a knapsack of capacity w to get the maximum total value in the knapsack. Return a double value representing the maximum value in knapsack.
Note: Unlike 0/1 knapsack, you are allowed to break the item here. The details of structure/class is defined in the comments above the given function.

Examples :

Input: n = 3, w = 50, value[] = [60,100,120], weight[] = [10,20,30]
Output: 240.000000
Explanation: Take the item with value 60 and weight 10, value 100 and weight 20 and split the third item with value 120 and weight 30, to fit it into weight 20. so it becomes (120/30)*20=80, so the total value becomes 60+100+80.0=240.0 Thus, total maximum value of item we can have is 240.00 from the given capacity of sack. 
Input: n = 2, w = 50, value[] = [60,100], weight[] = [10,20]
Output: 160.000000
Explanation: Take both the items completely, without breaking. Total maximum value of item we can have is 160.00 from the given capacity of sack.
Expected Time Complexity : O(n log n)
Expected Auxilliary Space: O(1)

Constraints:
1 <= n <= 105
1 <= w <= 109
1 <= valuei, weighti <= 104
*/

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class Solution {
    // Function to get the maximum total value in the knapsack.
     public static void quicksort(int low,int high,double end[],Item arr[]){
        if(low>=high)
			 return ;
        int i = low;
        int j = high;
        int mid = i+(j-i)/2;
        double pivot = end[mid];
        while(i<=j){
            while(end[i]>pivot)
            i++;
            while(end[j]<pivot)
            j--;
            if(i<=j){
                double temp = end[i];
                end[i] = end[j];
                end[j] = temp;
                Item t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                i++;
                j--;
            }
        }
        quicksort(low,j,end,arr);
        quicksort(i,high,end,arr);
    }
    
    double fractionalKnapsack(int w, Item arr[], int n) {
        double[] eff = new double[arr.length];
        for(int i=0;i<arr.length;i++){
            Item it = arr[i];
            eff[i] = (double)it.value/it.weight;
        }
        double res=0; 
        quicksort(0,eff.length-1,eff,arr);
        for(int i=0;i<arr.length;i++){
            
            int weight = arr[i].weight;
            int value = arr[i].value;
            // System.out.println(eff[i]+" "+value+" "+weight);
            if(w>=weight){
                res+= value;
                w-=weight;
            }
            else{
                double t = w*eff[i];
                res = res + t;
                w = 0;
            }
            if(w==0)
                break;
        }
        return res;
    }
}
