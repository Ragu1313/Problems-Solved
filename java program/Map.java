// import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Map{
    public static void main(String args[]){
        HashMap<String,Integer> hmap = new HashMap<>();
        hmap.put("ragu", 1);
        hmap.put("naren", 2);
        hmap.put("nithish", 3);
        hmap.put("chetta", 4);
        Set<String> hkeySet = hmap.keySet();
        System.out.println("Keys in the map:");
        for (String key : hkeySet) {
            System.out.println(hmap.get(key));//if(hmap.get(key)==j)
            System.out.println(key);
        }
    }
}