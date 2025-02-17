class Solution {
public:
    int flag = 0;
    bool check(int i,int num,vector<int>& arr){
        return arr[i+num]==0;
    }
    void f(int ind,vector<int>& arr,vector<int>& vis,int size,int n){
        if(ind==size)  {
            flag=1;
            // cout<<endl<<ind;
            return ;
        }
        if(flag==1) return;
        if(arr[ind]!=0){
            f(ind+1,arr,vis,size,n);
            // return ;
        }
        else{
            for(int i=n;i>0;i--){
                if(vis[i]==0 ){
                    
                    if(i==1){
                         vis[i] = 1;  
                        arr[ind] = i;
                        f(ind+1,arr,vis,size,n);
                        if(flag==1) return ;
                        arr[ind] = 0; 
                         vis[i] = 0;
                    }
                    if(i>1 && ind+i<size &&  check(ind,i,arr)){
                        vis[i] = 1;
                        arr[ind] = i;
                        arr[ind+i] = i;
                        f(ind+1,arr,vis,size,n);
                        if(flag==1) return ;
                        arr[ind] = 0;
                        arr[ind+i] = 0;
                        vis[i] = 0;
                    }
                   
                    
                }

            }
        }
        
    }
    
    vector<int> constructDistancedSequence(int n) {
        int size = n*2-1;
        vector<int> vis(n+1,0);
        vector<int> arr(size,0);
        f(0,arr,vis,size,n);
        return arr;
    }
};