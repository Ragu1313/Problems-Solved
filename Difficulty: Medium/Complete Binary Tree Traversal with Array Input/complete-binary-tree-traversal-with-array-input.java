class Solution {
    public ArrayList<ArrayList<Integer>> levelSort(int[] arr) {
        int n = 1;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int i = 0;
        while(i<arr.length){
            ArrayList<Integer> temp = new ArrayList<>();
            Stack<Integer> st = new Stack<>();
            int end = Math.min(i+n,arr.length);
            while(i<end){
                st.add(arr[i]);i++;
            }
            while(!st.isEmpty()){
                temp.add(st.pop());
            }
            Collections.sort(temp);
            n = n*2;
            res.add(temp);
        }
        return res;
    }
}