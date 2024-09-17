class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String,Integer> map = new HashMap<>();
        s1.trim();
        String[] arr1 = s1.split(" ");
        String[] arr2 = s2.split(" ");
        for(int i=0;i<arr1.length;i++)
            map.put(arr1[i],map.getOrDefault(arr1[i],0)+1);
        for(int i=0;i<arr2.length;i++)
            map.put(arr2[i],map.getOrDefault(arr2[i],0)+1);
        int c = 0;
        for(String key : map.keySet()){
            if(map.get(key)==1)
                c++;
        }
        String res[] = new String[c];
        c = 0;
        for(String key : map.keySet()){
            if(map.get(key)==1){
                res[c++] = key;
            }
        }
        return res;
    }
}