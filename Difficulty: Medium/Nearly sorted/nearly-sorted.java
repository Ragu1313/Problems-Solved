class Solution {
    public void nearlySorted(int[] arr, int k) {
        int ind = 0;
        PriorityQueue<Integer> p = new PriorityQueue<>((a,b)->a-b);
        for(int i : arr){
            p.add(i);
            if(p.size()>k){
                // System.out.println(ind);
                arr[ind++] = p.poll();
            }
        }
        while(!p.isEmpty()){
            arr[ind++] = p.poll();
        }
        return ;
    }
}
