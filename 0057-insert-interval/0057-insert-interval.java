class Solution {
    public int[][] insert(int[][] in, int[] ne) {
        int cnt = 0;
        int i = 0;
        int n = in.length;
        int start = 0;
        int end = 0;
        int arr1[][] = new int[n+1][2];
        // int cnt = 0;
        if(n==0)    return new int[][]{{ne[0],ne[1]}};
        int flag = 0;
        for(i=0;i<n;i++){
            if(ne[0]<=in[i][0] && flag == 0) {
                arr1[cnt][0] = ne[0];
                arr1[cnt++][1] = ne[1];
                flag = 1;
            }
            arr1[cnt][0] = in[i][0];
            arr1[cnt++][1] = in[i][1];
        }
        if(flag==0){
            arr1[cnt][0] = ne[0];
            arr1[cnt++][1] = ne[1];
        }
        n++;
        // List<int[]> arr = new ArrayList<>();
        // for(i=0;i<n;i++){
        //     System.out.println(arr1[i][0]+" "+arr1[i][1]);
            // if(arr1[i][0]!=-1){
            //     res[cnt][0] = arr1[i][0];
            //     res[cnt++][1] = arr1[i][1];
            // }
        // }
        cnt = 0;
        i=0;
        while(i<n){
            start = arr1[i][0];
            end = arr1[i][1];
            int j = i+1;
            while(j<n && end>=arr1[j][0]){
                end =Math.max(end,arr1[j][1]);
                arr1[j][0] = -1;
                j++;  
            }
            // System.out.println(j);
            arr1[i][1] = end;
            // arr.add(new int[]{start,end});
            cnt++;
            if(i!=j-1)
            i = j-1;
            i++;
        }
        int res[][] = new int[cnt][2];
        cnt = 0;
        for(i=0;i<n;i++){
            // System.out.println(in[i][0]+" "+in[i][1]);
            if(arr1[i][0]!=-1){
                res[cnt][0] = arr1[i][0];
                res[cnt++][1] = arr1[i][1];
            }
        }
        
        return res;

    }
}