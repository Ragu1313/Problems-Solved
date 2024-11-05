class Solution {
public:
    int rangeBitwiseAnd(int left, int right) {
        int l = left;
        int r = right;
        int diff = right-left;
        int res = 0;
        long  long c = 1;
        while(l>0 && r>0){
            if(diff<c){
                if(l&1>0 && r&1>0){
                    res = res+c;
                }
            }
            c = c*2;
            l =l>>1;
            r = r>>1;
        }
        return res;
    }
};