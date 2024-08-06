class Solution {
     public static void quicksort(int low,int high,int end[]){
        if(low>=high)
			 return ;
        int i = low;
        int j = high;
        int mid = i+(j-i)/2;
        int pivot = end[mid];
        while(i<=j){
            while(end[i]>pivot)
            i++;
            while(end[j]<pivot)
            j--;
            if(i<=j){
                int temp = end[i];
                end[i] = end[j];
                end[j] = temp;
                i++;
                j--;
            }
        }
        quicksort(low,j,end);
        quicksort(i,high,end);
    }
    public int minimumPushes(String word) {
        int [] arr = new int [26];
       
        for(int i=0;i<word.length();i++)
            arr[word.charAt(i)-'a']++;
        quicksort(0,25,arr);
        int total =0;
        for(int i=0;i<26;i++){
            if(arr[i]==0) break;
            int temp = i/8 +1;
            total = total + temp*arr[i];
        }
        return total;
    }
}