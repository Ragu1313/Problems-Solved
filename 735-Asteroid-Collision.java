class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> a = new Stack<>();
        a.push(arr[0]);
        for(int i=1;i<arr.length;i++){
            int t = arr[i];
            int temp1 = t;
            int temp2 ;
            // try{
            if(!a.isEmpty())
                temp2= a.peek();
            else{
                a.push(temp1);
                continue;
            }
            if(!a.isEmpty()){
                while(!a.isEmpty()){
                    if((temp1>=0 && temp2>=0) || (temp1<0 && temp2<0) || (temp2<0 && temp1>0)){
                        a.push(temp1);
                        break;
                    }
                    else if(temp1+temp2==0){
                        a.pop();
                        break;
                    }
                    else{
                            int res = temp1+temp2;
                            if(temp2<0 && temp1>=0){
                                a.push(temp1);
                                break;
                            }
                            if(res>0)
                                break;
                            // else if(res==0){
                            //     a.pop();
                            //     break;
                            // }
                            else if(res<0){
                                a.pop();
                                if(!a.isEmpty())
                                    temp2 = a.peek();  
                                else{
                                    a.push(temp1);
                                    break;
                                }
                                     
                            }
                    }
                }
            }
            else
                a.push(t);    
        }
        int [] ar = new int[a.size()];
        for(int i=a.size()-1;i>=0;i--)
            ar[i] = a.pop();
        return ar;
    }
}