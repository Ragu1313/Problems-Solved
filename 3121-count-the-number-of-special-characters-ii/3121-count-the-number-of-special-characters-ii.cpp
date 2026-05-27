class Solution {
public:
    int numberOfSpecialChars(string word) {
        vector<int> arr(59);
        vector<int> cnt(59);
        for(int i=0;i<word.size();i++){
            arr[word[i]-'A']++;
        }
        int res = 0;
        for(int i=0;i<word.size();i++){
            int temp = word[i];
            cnt[temp-65]++;
            if(temp>=65 && temp<=91){
                temp = temp+32;
                if( arr[temp-65]!=0 && cnt[temp-65]==arr[temp-65]){
                    res++;
                    arr[temp-65] = 0;
                }
                else{
                    arr[temp-65] = 0;
                }
            }
        }
        return res;
    }
};