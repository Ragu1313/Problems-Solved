class Pair {
    int val, ind;
    public Pair(int val, int ind) {
        this.val = val;
        this.ind = ind;
    }
}

class Solution {
    static int flag = 0;
    static int arr[] = new int[100001];
    
    static void f() {
        Arrays.fill(arr, 0);
        arr[0] = arr[1] = 1; 
        for (int i = 2; i * i < 100001; i++) {
            if (arr[i] == 0) {
                for (int j = i * i; j < 100001; j += i) {
                    arr[j] = 1;
                }
            }
        }
    }
    
    public int maximumScore(List<Integer> nums, int k) {
        if (flag == 0) {
            f();
            flag = 1;
        }
        
        int n = nums.size();
        int s[] = new int[n];
        
        for (int i = 0; i < n; i++) {
            int num = nums.get(i);
            int cnt = 0;
            for (int j = 2; j * j <= num; j++) {
                if (num % j == 0) {
                    if (arr[j] == 0) cnt++; 
                    while (num % j == 0) num /= j;
                }
            }
            if (num > 1 && arr[num] == 0) cnt++; 
            s[i] = cnt;
        }
        
        int pre[] = new int[n];
        Arrays.fill(pre, -1);
        int suf[] = new int[n];
        Arrays.fill(suf, n);
        
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            while (!st1.isEmpty() && s[st1.peek()] < s[i]) {
                st1.pop();
            }
            if (!st1.isEmpty()) {
                pre[i] = st1.peek();
            }
            st1.push(i);
        }
        
        for (int i = n - 1; i >= 0; i--) {
            while (!st2.isEmpty() && s[st2.peek()] <= s[i]) {
                st2.pop();
            }
            if (!st2.isEmpty()) {
                suf[i] = st2.peek();
            }
            st2.push(i);
        }
        
        PriorityQueue<Pair> p = new PriorityQueue<>((a, b) -> Integer.compare(b.val, a.val));
        
        for (int i = 0; i < n; i++) {
            p.add(new Pair(nums.get(i), i));
        }
        long res = 1;
        int MOD = 1000000007;
        
        while (k > 0) {
            Pair temp = p.poll();
            long left = pre[temp.ind]==-1?0:pre[temp.ind]+1;
            long right = suf[temp.ind]==n?n:suf[temp.ind];
            long totalVal = (temp.ind - left + 1) * (right - temp.ind);
            if (totalVal > k) {
                totalVal = k;
            }
            k -= totalVal;
            
            long temp11 = pow(temp.val,totalVal,MOD);
            res = (res*temp11)%MOD;
        }
        
        return (int) res;
    }
    public long pow(long n,long m,int mod){
        long temp = n;
        long res = 1;
        while(m>0){
            if((m&1)==1){
                res = (res*temp)%mod;
                m--;
            }
            else{
                temp = (temp*temp)%mod;
                m/=2;
            }
        }
        return res;
    }
}
