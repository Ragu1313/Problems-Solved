class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<String,String> map = new HashMap<>();
        Map<String,String> map2 = new HashMap<>();
        int poi = 0;
        int n = pattern.length();
        int ind = 0;
        int n1 =s.length();
        while(poi<n && ind<n1){
            StringBuilder sb = new StringBuilder();
            while(ind<n1 && s.charAt(ind)!=' '){
                sb.append(s.charAt(ind)+"");
                ind++;
            }
            String temp = map.get(pattern.charAt(poi)+"");
            String temp2 = map2.get(sb.toString());
            if( temp!=null && !temp.equals(sb.toString()) ){
                // System.out.println(ind + " " +sb.toString());
                return false;
            }
            if(temp2!=null && !temp2.equals(pattern.charAt(poi)+"")){
                return false;
            }
            map.put(pattern.charAt(poi)+"",sb.toString());
            map2.put(sb.toString(),pattern.charAt(poi)+"");
            poi++;
            ind++;
        }
        if(ind!=n1+1 || poi!=n)    return false;
        // if(poi==n && ind<n1)    return false;
        while(ind<n1){
            StringBuilder sb = new StringBuilder();
            while(ind<n1 && s.charAt(ind)!=' '){
                sb.append(s.charAt(ind)+"");
                ind++;
            }
            if(map2.containsKey(sb.toString())) return false;
            ind++;
        }
        return true;
    }
}