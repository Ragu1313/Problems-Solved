class Solution {
    public static int minCost(int[] arr) {
     PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int rope : arr) {
            pq.add(rope);
        }

        int totalCost = 0;

        while (pq.size() > 1) {
            int cost = pq.poll() + pq.poll();
            totalCost += (cost);
            pq.add(cost);
        }

        return totalCost;
        
    }
}