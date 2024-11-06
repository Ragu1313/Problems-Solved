class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int [] > p = new PriorityQueue<>((a,b)->a[0]-b[0]);
        Set<Pair<Integer,Integer>> vis = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        p.add(new int []{nums1[0]+nums2[0],0,0});
        vis.add(new Pair<Integer,Integer>(0,0));
        while(k-->0 && !p.isEmpty()){
            int [] arr = p.poll();
            int i = arr[1];
            int j = arr[2];
            List<Integer> a = new ArrayList<>();
            a.add(nums1[i]);
            a.add(nums2[j]);
            res.add(a);
            // String s = String.valueOf(i+1)+String.valueOf(j);
            if(i+1<nums1.length && !vis.contains(new Pair<Integer,Integer>(i+1,j)) ){
                p.add(new int[]{nums1[i+1]+nums2[j],i+1,j});
                vis.add(new Pair<Integer,Integer>(i+1,j));
            }
            // String s1 = String.valueOf(i)+String.valueOf(j+1);
            if(j+1<nums2.length  && !vis.contains(new Pair<Integer,Integer>(i,j+1)) ){
                p.add(new int[]{nums1[i]+nums2[j+1],i,j+1});
                vis.add(new Pair<Integer,Integer>(i,j+1));
            }
        }
        return res;
    }
}