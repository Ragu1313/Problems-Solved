
class Pair{
    int val;
    int time;
    public Pair(int val,int time){
        this.val = val;
        this.time = time;
    }
}
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int n1 = tasks.length;
        int cnt[] = new int[26];
        for(char ch : tasks)
            cnt[ch-'A']++;
        // List<Integer> l = new ArrayList<>(;
        PriorityQueue<Integer> q1 = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        for(int i : cnt){
            if(i>0) q1.add(i);
        }
        // Collections.reverse(l);
       
        Queue<Pair> q2 = new LinkedList<>();
        int temptime = 0;
        while(!q1.isEmpty() || !q2.isEmpty()){
            if(!q2.isEmpty()){
                Pair dup = q2.peek();
                if(dup.time==temptime) {
                    q1.add(dup.val);q2.poll();
                    // temptime = 
                } 
            }
            if(q1.isEmpty()){
                Pair dup = q2.poll();
                q1.add(dup.val);
                if(temptime<dup.time)
                temptime = dup.time;
            }
            int temp = q1.poll();
            // if(q1.isEmpty() && q2.isEmpty())    return temptime;
            temptime++;
            // System.out.println(temp+" "+temptime);
            if(temp-1==0) continue;
            q2.add(new Pair(temp-1,temptime+n));
            
        }
        return temptime;
    }
}