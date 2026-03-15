class Solution {
    ArrayList<String> res;
    public void fun(int ind,int len,String str,StringBuilder p){
        // System.out.println(p);
        if(ind==str.length() && len == 4){
            // p.deleteCharAt(p.length()-1);
            res.add(p.toString());
            
            return;
        }
        if(len>=4){
            return;
        }
        if(ind>=str.length()){
            return ;
        }
        StringBuilder sb1 = new StringBuilder();
        if(str.charAt(ind)=='0'){
            if(len!=3){
                p.append("0.");
                fun(ind+1,len+1,str,p);
                p.delete(p.length()-2,p.length());
            }
            else{
                p.append("0");
                fun(ind+1,len+1,str,p);
                p.deleteCharAt(p.length()-1);
            }
            return ;
        }
        
        for(int i=ind;i<Math.min(ind+3,str.length());i++){
            sb1.append(str.charAt(i));
            String temp = sb1.toString();
            if(range(temp)){
                 if(len!=3){
                    p.append(sb1.toString()+".");
                    fun(i+1,len+1,str,p);
                    p.delete(p.length()-sb1.length()-1,p.length());
                }
                else{
                    p.append(sb1.toString());
                    fun(i+1,len+1,str,p);
                    p.delete(p.length()-sb1.length(),p.length());
                }
            }
        }
        return ;
    }
    public boolean range(String str){
        int num = Integer.parseInt(str);
        return num>=0 && num<=255;
    }
    public ArrayList<String> generateIp(String s) {
        res = new ArrayList<>();
        fun(0,0,s,new StringBuilder());
        return res;
    }
}