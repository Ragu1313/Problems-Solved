class Solution {
    public long pickGifts(int[] gifts, int k) {
       PriorityQueue<int []> p = new PriorityQueue<>((a,b)->b[0]-a[0]);
       for(int i=0;i<gifts.length;i++){
            p.add(new int []{gifts[i],i});
       } 
       long res = 0;
       while(k-->0){
            int  s[] = p.poll();
            int index = s[1];
            int ans = (int)Math.sqrt(s[0]);
            gifts[index] = ans;
            p.add(new int[]{ans,index});
       }
       for(int i: gifts){
        //  System.out.println(i);
         res = res+i;
       }
       return res;
    }
}