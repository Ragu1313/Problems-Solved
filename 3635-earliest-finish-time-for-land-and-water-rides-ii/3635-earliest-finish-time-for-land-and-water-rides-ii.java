class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int max = Integer.MAX_VALUE;

        int landfirst = max;
        int waterfirst = max;
        int landlen = landStartTime.length;
        int waterlen = waterStartTime.length;
        int landres = max;
        int waterres = max;
        for(int i=0;i<landlen;i++){
            landfirst = Math.min(landfirst,landStartTime[i]+landDuration[i] );
        }

        for(int i=0;i<waterlen;i++){
            waterfirst = Math.min(waterfirst,waterStartTime[i] + waterDuration[i] );
            if(landfirst>=waterStartTime[i]){
                
                landres = Math.min(landres,landfirst+waterDuration[i]);
                // System.out.println(landres);
            }
            else{
                landres = Math.min(landres,waterStartTime[i]+waterDuration[i]);
            }
        }

        for(int i=0;i<landlen;i++){
            if(waterfirst>=landStartTime[i]){
                waterres = Math.min(waterres,waterfirst+landDuration[i]);
            }
            else{
                waterres = Math.min(waterres,landStartTime[i]+landDuration[i]);
            }
        }

        return Math.min(landres,waterres);
    }
}