class Solution(object):
    def maxDistance(self, arrays):
        curmin,curmax = arrays[0][0],arrays[0][-1]
        res=0
        for i in range(1,len(arrays)):
            arr = arrays[i]
            res = max(arr[-1]-curmin,curmax-arr[0],res)
            curmin = min(curmin,arr[0])
            curmax = max(curmax,arr[-1])
        return res
        