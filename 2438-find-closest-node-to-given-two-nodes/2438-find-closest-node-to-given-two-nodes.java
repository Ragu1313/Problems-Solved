class Solution {

    public int[] f(int node1,int edges[]){
        int n = edges.length;
        int dis[] = new int[n];
        Arrays.fill(dis,-1);
        int d = 0;
        int vis[] = new int[n];
        while(node1!=-1 && vis[node1]==0){
            vis[node1] = 1;
            dis[node1] = d;
            d++;
            node1 = edges[node1];
        }
        return dis;
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int dis1[] = f(node1,edges);
        int dis2[] = f(node2,edges);
        int n = edges.length;
        int res = -1;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(dis1[i]!=-1 && dis2[i]!=-1){
                if(min>Math.max(dis1[i],dis2[i])){
                    min =Math.max( dis1[i],dis2[i]);
                    res = i;

                    // System.out.println(res+" "+dis1[i]+" "+dis2[i]);
                }
            }
        }
        return res;
    }
}