class Solution {
    public int[] nextGreaterElements(int[] arr) {
        int [] res = new int[arr.length];
\t\tStack<Integer> s = new Stack<>();
\t\tint count = 0;
        int n = arr.length;
\t\tfor(int i=(2*n)-1;i>=0;i--){
\t\t\twhile(!s.isEmpty() && arr[i%n]>=s.peek()){
\t\t\t\ts.pop();
\t\t\t\tcount++;
\t\t\t}
\t\t\tif(!s.isEmpty()){
\t\t\t\tres[i%n] = s.peek();
\t\t\t}\t
\t\t\telse 
\t\t\t\tres[i%n] = -1;
\t\t\ts.push(arr[i%n]);
\t\t}
\t\t// System.out.println(count);
\t\treturn res;
    }
}