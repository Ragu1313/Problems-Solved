class Solution {
    public int minBitFlips(int start, int goal) {
        String s1 = Integer.toBinaryString(start^goal);
        int count = 0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)=='1')
                count++;
        }
        return count;
    }
}