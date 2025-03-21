class Solution {

    public void f(Queue<String> q , Map<String,List<String>> map,Set<String> res,Map<String,Integer> cnt){
        while(!q.isEmpty()){
            String temp = q.poll();
            res.add(temp);
            for(String s : map.get(temp)){
                cnt.put(s,cnt.get(s)-1);
                if(cnt.get(s)==0){
                    q.add(s);
                }
            }
        }        
    }

    public List<String> findAllRecipes(String[] recipes, 
        List<List<String>> ingredients, String[] supplies) {
        
        Map<String ,List<String>> map = new HashMap<>();

        Map<String,Integer> cnt = new HashMap<>();

        Set<String> res = new HashSet<>();
        Map<String,Integer> contain = new HashMap<>();
        for(String s : supplies){
            contain.put(s,1);
        }
        for(String s : recipes){
            contain.put(s,1);
        }
        for(int i=0;i<recipes.length;i++){
            String des = recipes[i];
            for(String src : ingredients.get(i)){
                map.putIfAbsent(src,new ArrayList<String>());
                map.putIfAbsent(des,new ArrayList<String>());
                if(contain.get(src)!=null){
                    map.get(src).add(des); 
                    cnt.put(src,cnt.getOrDefault(src,0));
                }
                cnt.put(des,cnt.getOrDefault(des,0)+1);
                
            }
        }
        Queue<String> q = new LinkedList<>();
        for(String s : cnt.keySet()){
            if(cnt.get(s)==0){
                q.add(s);
                // System.out.println(s);
            }
        }
        f(q,map,res,cnt);
        List<String> ans = new ArrayList<>();
        for(String s : recipes){
            if(res.contains(s)){
                ans.add(s);
            }
        }
        return ans;
    }
}