class Solution {
    public String simplifyPath(String path) {
        Stack<String> s = new Stack<>();
        String[] p = path.split(\/\);
        String res = \\;
        for(int i=0;i<p.length;i++){
            String str = p[i];
            
            if(str.length()==0 || (str.length()==1 && str.charAt(0)=='.'))   continue;
            if(str.length()==2 && str.charAt(0)=='.' && str.charAt(1)=='.'){
                if(!s.isEmpty())
                s.pop();
                continue;
            }
            s.push(str);

            // System.out.println(p[i]);
            
        }
        if(!s.isEmpty()){
            res = s.pop();
        }
        while(!s.isEmpty()){
            res = s.pop()+\/\+res;
        }
        
        return \/\+res;
    }
}