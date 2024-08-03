class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        HashMap<Integer,Integer> a = new HashMap<>();
        for(int i=0;i<target.length;i++)
            a.put(target[i], a.getOrDefault(target[i], 0) + 1);
        System.out.println(a.get(target[0]));
        for(int i=0;i<arr.length;i++){
            if(a.containsKey(arr[i]) && a.get(arr[i])>0)
                a.put(arr[i],a.get(arr[i])-1);
            else
                return false;
        }
        for(int i : a.values()){
            if(i!=0)
                return false;
        }
        return true;
    }
}