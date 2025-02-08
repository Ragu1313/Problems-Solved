class NumberContainers {
public:
    unordered_map<int,set<int>>m;
    unordered_map<int,int> v;
    NumberContainers() {
        
    }
    
    void change(int index, int number) {
        if(v[index]!=0){
            int val = v[index];
            m[val].erase(index);
        }
        m[number].insert(index);
        v[index] = number;
    }
    
    int find(int number) {
        if(m[number].size()!=0){
            for (auto i : m[number]){
                return i;
            }
        }
        return -1;
    }
};

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers* obj = new NumberContainers();
 * obj->change(index,number);
 * int param_2 = obj->find(number);
 */