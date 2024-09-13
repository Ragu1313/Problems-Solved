class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        res = 1
        l = []
        flag = 0
        for i in nums:
            if(i==0):
                flag = flag +1
            else:
                res = res*i
        for i in nums:
            if(flag==0):
                l.append(res//i)
            if (flag>1 or flag==1 and i!=0):
                l.append(0)
            elif(flag == 1 and i==0):
                l.append(res)
        return l

        