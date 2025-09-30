class Solution {
    ArrayList<String> arr ;
    public void helper(int n,StringBuilder sb){
        if(n==sb.length()){
            arr.add(new String(sb.toString()));
            return ;
        }
        int len = sb.length();
        sb.append('0');
        helper(n,sb);
        sb.setLength(len);
        sb.append('1');
        helper(n,sb);
        sb.setLength(len);
    }
    
    public ArrayList<String> binstr(int n) {
        arr = new ArrayList<>();
        helper(n,new StringBuilder());
        return arr;
    }
}
