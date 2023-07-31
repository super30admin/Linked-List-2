# Time Complexity :O(N)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this :

# Your code here along with comments explaining your approach
    # traverse both lists, find the difference in length, sync the start pointers, and start traversing
    # until we get same pointer. else return null.


class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        l1=0
        l2=0
        t_a=headA
        t_b=headB

        while(t_a):
            l1+=1
            t_a=t_a.next
        while(t_b):
            l2+=1
            t_b=t_b.next
        d=abs(l1-l2)
        t_a=headA
        t_b=headB
        if(l1>l2):
            while(d):
                t_a=t_a.next
                d-=1
        elif(l2>l1):
            while(d):
                t_b=t_b.next
                d-=1
        while(t_a ):
            if(t_a==t_b):
                break
            t_a=t_a.next
            t_b=t_b.next
        return t_a
