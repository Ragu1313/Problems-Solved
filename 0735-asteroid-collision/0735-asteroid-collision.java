class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        int n = asteroids.length;
        for(int i=0;i<n;i++){
            if(!st.isEmpty()){
                if(asteroids[i]<0){
                    if(asteroids[st.peek()]<0){
                        st.push(i);
                        // System.out.println(st);
                        continue;
                    }
                    else{
                        while(!st.isEmpty() && asteroids[st.peek()]>0 &&  asteroids[st.peek()]+asteroids[i]<0) st.pop();
                        if(!st.isEmpty()) {
                            if(asteroids[st.peek()]+asteroids[i]==0){
                                st.pop();
                            }
                            else if(asteroids[st.peek()]+asteroids[i]<0){
                                // System.out.println(st);
                                st.push(i);
                            }
                        }
                        else    st.push(i);
                    }
                }
                else{
                    // if(asteroids[st.peek()]<0 || asteroids[st.peek()]>0){
                        st.push(i);
                        // continue;
                   
                }
            }
            else{
                st.push(i);
            }
        }
        int c = st.size();
        int res[] = new int[c];
        c--;
        while(!st.isEmpty()){
            res[c] = asteroids[st.pop()];
            c--;
        }
        return res;
    }
}