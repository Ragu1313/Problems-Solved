public class stringsubset{

    public static void subset(String p , String q){
        if(q.isEmpty()){
            System.out.println(p);
        }
        else{
            char a = q.charAt(0);
            subset(p+a ,q.substring(1));
            subset(p , q.substring(1));
        }
    }
    public static void main(String[] args) {
        subset("","abc");
    }
    
}