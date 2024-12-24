class Solution {
    public int findMinArrowShots(int[][] p) {
        Arrays.sort(p,(a,b)->{
            int cmp = Integer.compare(a[0],b[0]);
            if(cmp!=0)  return cmp;
            return Integer.compare(a[1],b[1]);
        });
        int n = p.length;
        // int res = 1;
        int i=0;
        int cnt = 0;
        // for(i=0;i<n;i++){
        //     System.out.println(p[i][0]+" "+p[i][1]);
        // }
        i=0;
        while(i<n){
            // int start = p[i][0];
            int end = p[i][1];
            int j = i+1;
            while(j<n && end>=p[j][0]){
                end = Math.min(end,p[j][1]);
                j++;
                // System.out.println("Hi   ");
            }
            cnt++;

            i = j;
            // i++;
            // System.out.println(i);
        }
        return cnt;
    }
}