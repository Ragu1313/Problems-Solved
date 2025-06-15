class Solution {
    public int maxDiff(int num) {
        StringBuilder str = new StringBuilder(String.valueOf(num));
        StringBuilder str2 = new StringBuilder(str);
        int cnt = 0;
        int n = str.length();
        int arr[] = new int[10];
        for(int i=0;i<n;i++){
            if(str.charAt(i)!='9' && arr[i]==0){
                cnt++;
                char ch = str.charAt(i);
                for(int j=i;j<n;j++)
                if(str.charAt(j)==ch){ str.setCharAt(j,'9');  arr[j] = 1;} 
                break;
            }
        }
        cnt = 0;
        // if(n>2){
        Arrays.fill(arr,0);
        
        for(int i=0;i<n;i++){
            
            if(i==0 && str2.charAt(i)!='1'  ){
                // cnt++;
                char ch = str2.charAt(i);
                for(int j=i;j<n;j++){
                    if(str2.charAt(j)==ch){
                    // if(cnt==1)
                        str2.setCharAt(j,'1');
                        arr[Integer.parseInt(""+str2.charAt(j))] = 1;
                    }
                }
                break;
                // if(cnt ==2)  break;
            }
            else if(i!=0 && str2.charAt(i)!='0' && arr[Integer.parseInt(str2.charAt(i)+"")]==0 ){
                cnt++;
                char ch = str2.charAt(i);
                for(int j=i;j<n;j++){
                    if(str2.charAt(j)==ch  )
                    {
                        str2.setCharAt(j,'0');
                        arr[Integer.parseInt(str2.charAt(j)+"")] = 1;
                    }
                }
                // str.setCharAt(i,'1');
                break;
            }
            arr[Integer.parseInt(str2.charAt(0)+"")] = 1;
        } 
        // System.out.println(str.toString()+" "+str2.toString());
        return Integer.parseInt(str.toString())-Integer.parseInt(str2.toString());
    }
}