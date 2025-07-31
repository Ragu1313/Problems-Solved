class Solution {
    
    public String numberToWords(int num) {
        String [] single = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
        String [] twenty = {"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        String [] tens = {"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        if(num==0)  return "Zero";
        
        if(num<10) return single[num];

        if(num<=19)  return twenty[num%10];

        if(num<100)  return tens[num/10] + (num%10!=0?" "+single[num%10]:"");

        if(num<1000)  return single[num/100] + " Hundred" + (num%100!=0 ? " "+ numberToWords(num%100): "" );

        if(num<1000000){
            return numberToWords(num/1000) +" Thousand" + (num%1000!=0 ?" "+numberToWords(num%1000) : "" );
        }

        if(num<1000000000){
            return numberToWords(num/1000000) + " Million" + (num%1000000!=0 ? " "+numberToWords(num%1000000) : "");
        }

        return numberToWords(num/1000000000) + " Billion" + (num%1000000000!=0 ? " "+numberToWords(num%1000000000) :"");

    }
}