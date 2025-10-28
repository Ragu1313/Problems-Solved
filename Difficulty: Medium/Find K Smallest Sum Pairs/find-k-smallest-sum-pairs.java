class Solution {
    public ArrayList<ArrayList<Integer>> kSmallestPair(int[] arr1, int[] arr2, int k) {
        PriorityQueue<int[]> p = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        // p.add(new int[]{arr1[0]+arr2[0],0,0});
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(int i=0;i<arr1.length;i++){
            p.add(new int[]{arr1[i]+ arr2[0] , i,0});
        }
        while(k-->0 && !p.isEmpty() ){
            int temp [] = p.poll();
            ArrayList<Integer> li = new ArrayList<>();
            int i = temp[1];
            int j = temp[2];
            li.add(arr1[i]);
            li.add(arr2[j]);
            res.add(li);
            // int ii = i + 1;
            int jj = j + 1;
            // if(ii<arr1.length){
            //     p.add(new int[]{arr1[ii]+arr2[j],ii,j } );
            // }
            if(jj<arr2.length){
                p.add(new int[]{arr1[i]+arr2[jj],i, jj} );
            }
        }
        return res;
    }
}
