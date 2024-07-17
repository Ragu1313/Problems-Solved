package problem;

class HeapSort{
    public void heapify(int arr[],int i,int n){
        int largest = i;
        int left = (i*2)+1;
        int right = (i*2 ) +2;
        if(left<n && arr[left]>arr[largest])
            largest = left;
        if(right<n && arr[right]>arr[largest])
            largest = right;
        if(i!=largest){
            // swap(arr[i],arr[largest]);
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr,largest,n);
        }
    }
    // public void swap(int a,int b){
    //     int temp = a;
    //     a=b;
    //     b=a;
    // }

    public void heapsort(int arr[]){
        int n = arr.length;
        int i;
        for(i=n/2-1;i>=0;i--)
            heapify(arr,i,n);
        for(i=n-1;i>0;i--){
            // swap(arr[0],arr[n]);
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp; 
            heapify(arr,0,i);
        }
    }
    public static void main(String [] args){
        int [] arr = {20,30,1,4,7,3};
        // int n = 5;
        HeapSort h = new HeapSort();
        h.heapsort(arr);
        for(int i=0;i<6;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
