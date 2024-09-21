class Solution {
    public List<Integer> lexicalOrder(int n) {
        String [] arr = new String[n];
        int c = 1;
        for(int i=0;i<n;i++){
            arr[i] = String.valueOf(c++);
        }
        Arrays.sort(arr);
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            res.add(Integer.parseInt(arr[i]));
        }
        return res;
    }
}