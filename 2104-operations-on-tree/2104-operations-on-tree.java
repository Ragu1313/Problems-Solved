class LockingTree {

    List<List<Integer>> child = new ArrayList<>();
    int track_lock[];
    int parent[];
    int n ;
    public LockingTree(int[] parent) {
        this.parent = parent;
        n = parent.length;
        track_lock = new int[n];
        Arrays.fill(track_lock,-2);
        for(int i=0;i<n;i++){
            child.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            if(parent[i]!=-1)
            child.get(parent[i]).add(i);
        }   
    }
    
    public boolean lock(int num, int user) {
        
        if(track_lock[num]==-2 ){
            track_lock[num] = user;
            // System.out.println(track_lock[num]);
            return true;
        }
        return false;
    }
    
    public boolean unlock(int num, int user) {
        if(track_lock[num]==user){
            track_lock[num] = -2;
            return true;
        }
        return false;
    }
    
    public boolean upgrade(int num, int user) {
        if(track_lock[num]!=-2) return false;
        int tempnum = num;
        while(parent[num]!=-1){
            int par = parent[num];
            if(track_lock[par]>=0)  return false;
            num = par;
        }
        int flag = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(tempnum);
        // for(List<Integer> l : child){
        //     System.out.println(l);
        // }
        // for(int j : track_lock){
        //     System.out.print(j+ " ");
        // }
        while(!q.isEmpty()){
            int temp = q.poll();
            for(int j : child.get(temp)){
                if(track_lock[j]>=0){
                    flag = 1;
                    track_lock[j] = -2;
                }
                q.add(j);
            }
        }
        if(flag==1){
            track_lock[tempnum] = user;
            return true;
        }
        return false;
    }
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */