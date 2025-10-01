class Solution {
    static Set<ArrayList<Integer>> set ;
    public static void f(int arr[],int flag[],ArrayList<Integer> li,int n ){
        if(li.size()==n){
            set.add(new ArrayList<>(li));
            return ;
        }
        for(int i=0;i<n;i++){
            if(flag[i]==0){
                flag[i] = 1;
                li.add(arr[i]);
                f(arr,flag,li,n);
                li.remove(li.size()-1);
                flag[i] = 0;
            }
        }
    }
    public static ArrayList<ArrayList<Integer>> uniquePerms(int[] arr) {
        set = new LinkedHashSet<>();
        int n = arr.length;
        Arrays.sort(arr);
        f(arr,new int[n],new ArrayList<>(),n);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(ArrayList<Integer> i : set){
            res.add(i);
        }
        // res.sort((temp1,temp2)->temp1.get(0).compareTo(temp2.get(0)));                                                                                                                                        ;
        return res;
    }
};