class Solution {
    public int[] dailyTemperatures(int[] arr) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        int flag = 0;
        int res[] = new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            flag = 0;
            if(!s1.isEmpty()){
                while(!s1.isEmpty()){
                    int temp = s1.peek();
                    int ind = s2.peek();
                    if(temp>arr[i]){
                        res[i] = ind-i;
                        flag = 1;
                        s1.push(arr[i]);
                        s2.push(i);
                        break;
                    }
                    else{
                        s1.pop();
                        s2.pop();
                    }
                }
            }
            else{
                s1.push(arr[i]);
                s2.push(i);
            }
            if(flag==0){
                s1.push(arr[i]);
                s2.push(i);
                res[i] = 0;
            }
                
            
        }
        return res;
    }
}