# Time Complexity :O(m+n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode :Yes       
# Any problem you faced while coding this :No

class Solution(object):
    def getIntersectionNode(self, headA, headB):
        countA,countB=0,0
        curr=headA
        while(curr!=None):
            countA+=1
            curr=curr.next
        curr=headB
        while(curr!=None):
            countB+=1
            curr=curr.next

        if(countA>countB):
            curr=headA
            for i in range(countA-countB):
                curr=curr.next

            back=headB
            while(curr!=back):
                curr=curr.next
                back=back.next
            return back

        else:
            curr=headB
            for i in range(countB-countA):
                curr=curr.next
            
            back=headA
            while(curr!=back):
                curr=curr.next
                back=back.next
            return back
        

