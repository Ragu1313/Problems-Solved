 public static void quicksort(int low,int high,int start[],int end[]){
        if(low>=high)
			 return ;
        int i = low;
        int j = high;
        int mid = i+(j-i)/2;
        int pivot = end[mid];
        while(i<=j){
            while(end[i]<pivot)
            i++;
            while(end[j]>pivot)
            j--;
            if(i<=j){
                int temp = end[i];
                end[i] = end[j];
                end[j] = temp;
                temp = start[i];
                start[i] = start[j];
                start[j] = temp;
                i++;
                j--;
            }
        }
        quicksort(low,j,start,end);
        quicksort(i,high,start,end);
    }
