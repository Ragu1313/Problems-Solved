/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer,Integer> map = new HashMap<>();
        Map<Integer,List<Integer>> adj = new HashMap<>();
        int n = employees.size();
        int res = 0;
        for(int i=0;i<n;i++){
            Employee emp = employees.get(i);
            int val1 = emp.id;
            int imp = emp.importance;
            map.put(val1,imp);
            for(int j : emp.subordinates){
                adj.putIfAbsent(val1,new ArrayList<>());
                adj.putIfAbsent(j,new ArrayList<>());
                adj.get(val1).add(j);
                // adj.get(j).add(val1);
            }
        }
        Map<Integer,Integer> set = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        res += map.get(id);
        set.put(id,1);
        while(!q.isEmpty()){
            int temp = q.poll();
            // System.out.println(temp);
            // System.out.println(adj.get(temp));
            if(adj.get(temp)!=null){
                for(int i : adj.get(temp)){
                    if(set.get(i)==null){
                        set.put(i,1);
                        q.add(i);
                        res += map.get(i);
                    }
                }
            }
        }
        return res;
    }
}