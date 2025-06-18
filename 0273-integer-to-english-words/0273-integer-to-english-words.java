class Solution {
    public String numberToWords1(int num,int flag){
        String []single = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        String [] tens = {"Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        int n = 1+(int)Math.log10(num);
        // if(num==0) return "Zero";
        if(flag==0 && num==0)   return "Zero";
        // System.out.println(n);
        if(n==1){
            return single[num];
        }
        else if(n==2){
            if(num<=19)  return single[num];
            if(single[num%10].length()==0)
            return tens[num/10-1];
            return tens[num/10-1]+" "+single[num%10];
        }
        else if(n==3){
            String s = String.valueOf(num);
            String temp = numberToWords1(Integer.parseInt(s.substring(1,s.length())),1);
            if(temp.length()==0)
            return single[num/100]+" Hundred";
            return single[num/100]+" Hundred "+temp; 
        }
        else if(n<=5){
            String s = String.valueOf(num);
            // String res = "";
            if(n==4){
                String temp = numberToWords1(Integer.parseInt(s.substring(1,s.length())),1);
                if(temp.length()==0)
                return numberToWords1(Integer.parseInt(s.substring(0,1)),1) + " Thousand";
                else
                return  numberToWords1(Integer.parseInt(s.substring(0,1)),1) + " Thousand "+temp;

            }
            else if(n==5){
                String temp = numberToWords1(Integer.parseInt(s.substring(2,s.length())),1);
                if(temp.length()==0)
                return numberToWords1(Integer.parseInt(s.substring(0,2)),1) + " Thousand";
                return numberToWords1(Integer.parseInt(s.substring(0,2)),1) + " Thousand "+temp;
            }
           
        }
        else if(n<=7){
            String s = String.valueOf(num);
            String res = "";
            if(n==6){
                String temp = numberToWords1(Integer.parseInt(s.substring(3,s.length())),1);
                if(temp.length()>0)
                res = numberToWords1(Integer.parseInt(s.substring(0,3)),1)+" Thousand "+ temp;
                else
                res = numberToWords1(Integer.parseInt(s.substring(0,3)),1)+" Thousand";
            }
            else{
                String temp = numberToWords1(Integer.parseInt(s.substring(1,s.length())),1);
                if(temp.length()==0)
                res = numberToWords1(Integer.parseInt(s.substring(0,1)),1) + " Million";
                else
                res = numberToWords1(Integer.parseInt(s.substring(0,1)),1) + " Million " + temp;
            }
            return res ;
        }
        else if(n<=9){
            String s = String.valueOf(num);
            String res = "";
            if(n==8){
                res = numberToWords1(Integer.parseInt(s.substring(2,s.length())),1);
                if(res.length()==0)
                return numberToWords1(Integer.parseInt(s.substring(0,2)),1)+" Million";
                return numberToWords1(Integer.parseInt(s.substring(0,2)),1)+" Million "+res;
            }
            else{
                res = numberToWords1(Integer.parseInt(s.substring(3,s.length())),1);
                if(res.length()==0)
                return numberToWords1(Integer.parseInt(s.substring(0,3)),1) + " Million";
                return numberToWords1(Integer.parseInt(s.substring(0,3)),1) + " Million "+res;
            }
            // return res ;
        }
        else if(n==10){
            String s = String.valueOf(num);
            String res = numberToWords1(Integer.parseInt(s.substring(1,s.length())),1);
            if(res.length()==0)
                return numberToWords1(Integer.parseInt(s.substring(0,1)),1)+" Billion";
            return  numberToWords1(Integer.parseInt(s.substring(0,1)),1) + " Billion "+res;
        }
        return "";
    }
    public String numberToWords(int num) {
        return numberToWords1(num,0);
    }
}