class Dsu{
    int arr[];
    int size[];
    int val[];
    public Dsu(int n){
        arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = i;
        }
        size = new int[n];
        Arrays.fill(size,1);
        val = new int[n];
        Arrays.fill(val,Integer.MAX_VALUE);
    }

    public int findParent(int v){
        if(arr[v]==v)   return v;
        return arr[v] = findParent(arr[v]);
    }

    public void merge(int u , int v, int wei){
        int par1 = findParent(u);
        int par2 = findParent(v);
        if(size[par1]>size[par2]){
            size[par1] += size[par2];
            arr[par2] = par1;
            val[par1]  = val[par1]&val[par2]&wei ; 
        }
        else{
            size[par2] += size[par1];
            arr[par1] = par2;
            val[par2]  = val[par1]&val[par2]&wei ;
        }
    }

}

class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        Dsu d = new Dsu(n);
        for(int i[] : edges){
            d.merge(i[0],i[1],i[2]);
        }

        int [] res = new int[query.length];
        for(int i=0;i<query.length;i++){
            int temp [] = query[i];
            if(d.findParent(temp[0])==d.findParent(temp[1])){
                 res[i] = d.val[d.findParent(temp[0])];
            }
            else{
                res[i] = -1;
            }
        }
        return res;
    }
}