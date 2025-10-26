class Solution {
    public int minOperations(int[] arr) {
        PriorityQueue<Double> p = new PriorityQueue<>((a,b)->Double.compare(b,a));
        double sum = 0f;
        double k = 0.f;
        for(int i : arr){
            p.add((double)(i));
            sum += i;
            k+=i;
        }
        double temp = sum;
        k = k/2;
        int res = 0;
        // System.out.println(temp+" "+k);
        while(temp>k){
            double t = p.poll();
            temp -= (t/2.0);
            p.add((t/2.0));
            res++;
        }
        return res;
    }
}