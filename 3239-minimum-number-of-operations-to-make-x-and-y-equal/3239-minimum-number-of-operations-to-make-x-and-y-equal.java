class Solution {
    // int res = 0;
    public int minimumOperationsToMakeEqual(int x, int y) {
        // return f(x,y);
        Set<Integer> set = new HashSet<>();
        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        set.add(x);
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                int temp = q.poll();
                if(temp==y){
                    return cnt;
                }
                if(set.add(temp+1))
                    q.add(temp+1);
                if(temp>y){
                    if(temp%5==0 && set.add(temp/5)){
                        q.add(temp/5);
                    }
                    if(temp%11==0 && set.add(temp/11) ){
                        q.add(temp/11);
                    }
                    if(set.add(temp-1))
                    q.add(temp-1);
                }
                
            }
            cnt++;
        }
        return -1;
    }
}