class FindBySize{
    int size[] ;
    int par[];
    public FindBySize(int n){
        size = new int[n];
        par = new int[n];
        for(int i=0;i<n;i++){
            size[i] = 1;
            par[i] = i;
        }
    }
    public int parent(int u){
        if(par[u]==u){
            return u; 
        }
        int temp = parent(par[u]);
        par[u] = temp;
        return temp;
    }
    public void join(int u,int v){
        int p1 = parent(u);
        int p2 = parent(v);
        if(size[p1]>size[p2]){
            size[p1]+=size[p2];
            par[p2] = p1;
        }
        else{
            size[p2]+=size[p1];
            par[p1] = p2;
        }
    }
    
}

class Solution {
    public int removeStones(int[][] stones) {
        int mr = 0,mc = 0;
        int count = 0;
        for(int i[] : stones){
            mr = Math.max(i[0],mr);
            mc = Math.max(i[1],mc);
            count++;
        }
        mr++;
        mc++;
        if(mr>mc){
            mc = mr;
        }
        else{
            mr = mc;
        }
        FindBySize f = new FindBySize(mr+mc);
        for(int i[] : stones){
            f.join(i[0],mc + i[1]);
        }
        Set<Integer> set = new HashSet<>();
        for(int i[]:stones){
            int p1 = f.parent(i[0]);
            int p2 = f.parent(mc+i[1]);
            set.add(p1);
            set.add(p2);
        }
        return count - set.size();
    }
}