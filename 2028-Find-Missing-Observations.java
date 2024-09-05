class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int sum = 0;
        for(int i : rolls)
            sum+=i;
        int d = m+n;
        int tot = (d*mean) - sum;
        float an = (float)tot/n;
        int ans = (int)an;
        if(ans*n < n || an <=0 || an > 6)
            return new int[0];
        
        int res[] = new int[n];
        sum = 0;
        for(int i=0;i<n-1;i++){
            sum+=ans;
            res[i] = ans;
        }
        d = tot-sum;
        if(d>6){
            int i = 0;
            while(i<n-1)
            {
                int temp = 6-res[i];
                res[i] = res[i] + temp;
                d = d-temp;
                if(d<=6)
                    break;
                i++;
            }
        }
        res[n-1] = d;
        return res;
    }
}