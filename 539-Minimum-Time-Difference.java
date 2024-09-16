class Solution {
    public int findMinDifference(List<String> timePoints) {
        int [] arr = new int [timePoints.size()];
        for(int i=0;i<timePoints.size();i++){
            String s[] = timePoints.get(i).split(":");
            int n = Integer.parseInt(s[0])*60 + Integer.parseInt(s[1]);
            arr[i] = n;
        }
        Arrays.sort(arr);
        int res = 1440+arr[0] - arr[arr.length-1];
        for(int i=1;i<arr.length;i++){
            res = Math.min(res,arr[i]-arr[i-1]);
        }
        return res;
    }
}