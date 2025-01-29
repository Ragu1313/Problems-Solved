class Solution {
    public int parent(int src,int par[]){
        int p = par[src];
        while(p!=-1){
            src = p;
            p = par[p];
        }
        // if(p==-1){
        return src;
        // }
    }
    public void union(int src,int des,int par[],int p1,int p2){
        par[p2] = p1;
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int par[] = new int[n+1];
        Arrays.fill(par,-1);
        for(int [] edge : edges){
            int src = edge[0];
            int des = edge[1];
            int p1 = parent(src,par);
            int p2 = parent(des,par);
            // par[src] = p1;
            // par[des] = p2;
            if(p1==p2){
                return new int[]{src,des};
            }
            // if(p1!=)
            union(src,des,par,p1,p2);
            // else
            // union(src,des,par,p2);
        }
        return new int[0];
    }
}