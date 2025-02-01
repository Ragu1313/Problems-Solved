class Solution {
    public int maxFreeTime(int event, int[] start, int[] end) {
        int n = end.length;
        int s[] = new int[n + 2];
        int e[] = new int[n + 2];
        s[0] = 0;
        e[0] = 0;
        for (int i = 0; i < n; i++) {
            s[i + 1] = start[i];
            e[i + 1] = end[i];
        }
        n = n + 2;
        s[n - 1] = event;
        e[n - 1] = event;

        int pre[] = new int[n];
        int suf[] = new int[n];
        // int maxi = 0;
        for (int i = 1; i < n; i++) {
            pre[i] = Math.max(pre[i - 1], s[i] - e[i - 1]);
            // maxi;
        }
        // maxi = 0;
        for (int i = n - 2; i >= 0; i--) {
            suf[i] = Math.max(suf[i + 1], s[i + 1] - e[i]);
            // suf[i] = maxi;
        }
        // for(int i=0;i<n;i++){
        // System.out.print(s[i]+" ");
        // }
        // System.out.println();
        // for(int i=0;i<n;i++){
        // System.out.print(e[i]+" ");
        // }
        // System.out.println();
        // for (int i = 0; i < n; i++) {
        //     System.out.print(pre[i] + " ");
        // }
        // System.out.println();
        // for (int i = 0; i < n; i++) {
        //     System.out.print(suf[i] + " ");
        // }
        // System.out.println();
        int res = 0;
        for (int i = 0; i < n - 2; i++) {
            // System.out.println(e[i] + " " + s[i + 2]);
            int dif = s[i + 2] - e[i];
            int tar = e[i + 1] - s[i + 1];
            if (i - 1 >= 0 && pre[i ] >= tar) {
                res = Math.max(dif, res);
                // System.out.println(dif);
            } else if (i + 3 < n && suf[i + 2] >= tar) {
                res = Math.max(dif, res);
                // System.out.println(dif);
            } else {
                dif = dif - (e[i + 1] - s[i + 1]);
                // System.out.println(dif);
                res = Math.max(dif, res);
            }
        }
        res = Math.max(s[n - 1] - e[n - 2], res);
        return res;
    }
}