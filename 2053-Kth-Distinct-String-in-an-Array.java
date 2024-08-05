class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String,Integer> a = new LinkedHashMap<>();
        for(String ch : arr)
            a.put(ch,a.getOrDefault(ch,0)+1);
        int c=1;
        for(String ch :a.keySet()){
            if(a.get(ch)==1){
                if(c==k){
                    return ch;
                }
                c++;
            }
        }
        return "";
    }
}