class RandomizedSet {

    private Set<Integer> set;
    public RandomizedSet() {
        set = new HashSet<>();
    }
    
    public boolean insert(int val) {
        return set.add(val);
        
    }
    
    public boolean remove(int val) {
        if(set.add(val)){
            set.remove(val);
            return false;
        }
        set.remove(val);
        return true;
    }
    
    public int getRandom() {
        int size = set.size();
        int random = (int)(Math.random()*size );
        int c=0;
        for(int i:set){
            
            if(c==random){
                return i;
            }
            c++;
        }
        return -1;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */