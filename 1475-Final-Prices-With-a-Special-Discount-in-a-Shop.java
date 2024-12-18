class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int arr[] = prices;
        Stack<Integer> s = new Stack<>();
        // s.push(prices[n-1]);
        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty() && s.peek()>prices[i]){
                // System.out.println("pop "+s.peek());
                s.pop();
            }
            int dis = s.isEmpty()?0:s.peek();
            // if(!s.isEmpty() ){
            s.push(prices[i]);
            prices[i] -= dis;
            // }
            // System.out.println("arrr "+prices[i]);
            
            // System.out.println(s);
        }
        return arr;
    }
}