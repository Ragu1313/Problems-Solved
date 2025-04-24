class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        
        char ch[] = s.toCharArray();
        int n = ch.length;
        int starcnt[] = new int[n];
        int leftcandle[] = new int[n];
        int rightcandle[] = new int[n];
        int leftpoi = -1;
        int rightpoi = -1;
        int star = 0;
        // int j ;
        for(int i=0,j=n-1;i<n && j>=0;i++,j--){
            if(ch[i]=='*'){
                starcnt[i] = i>0? starcnt[i-1]+1 : 0;
                star++;
                if(leftpoi>=0)  leftpoi++;
                // star++;
                
            }
            else{
                // star = 0;
                starcnt[i] = i>0? starcnt[i-1] : 0;
                leftpoi = 0;
            }
            
            leftcandle[i] = leftpoi;
            if(ch[j]=='*'){
                if(rightpoi>=0)  rightpoi++;  
            }
            else{
                rightpoi = 0;
            }
            rightcandle[j] = rightpoi;
            // System.out.println(" ");
        }
        // for(int i=0;i<n;i++){
        //     System.out.println(leftcandle[i]+" "+rightcandle[i]+" "+starcnt[i]);
        // }
        int m = queries.length;
        int cnt = -1;
        int res[] = new int[m];
        for(int i[] : queries){
            cnt++;
            if(rightcandle[i[0]]==-1 || leftcandle[i[1]]==-1)   continue;
            int left =i[0] + rightcandle[i[0]];
            int right = i[1] - leftcandle[i[1]];
            if(left<=i[1] && right>=i[0])  
            // System.out.print(starcnt[rightcandle[i[0]]]+" "+starcnt[leftcandle[i[1]]]);
            // System.out.println(" "+rightcandle[i[0]]+" "+leftcandle[i[1]]);
            res[cnt] = starcnt[right] - starcnt[left];
            else    res[cnt] = 0;
            
        }
        return res;
    }
}