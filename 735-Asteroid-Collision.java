class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<arr.length;i++){
            if(stack.isEmpty()){
                stack.push(arr[i]);
            }
            else{
                int prev = stack.peek();
                if(arr[i]<0 && prev>=0){
                    // int temp = -arr[i];
                    // int flag = 0;
                    while(!stack.isEmpty()){
                        prev = stack.peek();
                        if(prev+arr[i]<=0  && prev>=0){
                            stack.pop();
                            if(prev+arr[i]==0)
                                break;
                            if(stack.isEmpty()){
                                stack.push(arr[i]);
                                break;
                            }
                            // flag = 1;
                            // stack.push(arr[i]);
                        }
                        else if (prev<0){
                            // flag = 0;
                            stack.push(arr[i]);
                            break;
                        }
                        else{
                            // flag = 0;
                            break;
                        }
                    }
                }
                else{
                    stack.push(arr[i]);
                }
            }
        }
        int res[] = new int[stack.size()];
        for(int i=stack.size()-1;i>=0;i--){
            res[i] = stack.pop();
        }
        return res;
    }
}