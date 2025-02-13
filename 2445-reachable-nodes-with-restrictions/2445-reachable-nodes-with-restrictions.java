class Dis{
    // Vector<Integer> par;
    // Vector<Integer> size;
    int par[];
    int size[];
    public Dis(int n){
        par = new int[n];
        for(int i=0;i<n;i++){
            par[i] = i; 
        }
        size = new int[n]; 
        Arrays.fill(size,1);
    }
    public int parent(int v){
        if(par[v]==v)   return v;
        return par[v] = parent(par[v]);   
    }
    public int getSize(int i){
        return size[i];
    }
    public void join(int u,int v){
        int p1 = parent(u);
        int p2 = parent(v);
        if(size[p1]>size[p2]){
            size[p1] += size[p2];
            par[p2] = p1;
        }
        else{
            size[p2] += size[p1];
            par[p1] = p2;
        }
    }
}

class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Dis dis = new Dis(n);
        Set<Integer> set = new HashSet<>();
        for(int i : restricted){
            set.add(i);
        }
        int n1 = edges.length;
        for(int i=0;i<n1;i++){
            int src = edges[i][0];
            int des = edges[i][1];
            if(set.contains(src) || set.contains(des)){
                continue;
            }
            dis.join(src,des);
        }
        return dis.getSize(dis.parent(0));
    }
}