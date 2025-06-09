# // Time Complexity :O(M+N)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach
# find differnce between lengths if two nodes move high pointer to that pos so that both lengths would be equal and then start comparing / or use set 


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        l1,l2=0,0
        headAt=headA
        headBt=headB
        while(headA):
            l1+=1
            headA=headA.next
        while(headB):
            l2+=1
            headB=headB.next
        headA,headB=headAt,headBt
        if l1>=l2:
            k=l1-l2
            while(k):
                headAt=headAt.next
                k-=1
        else:
            k=l2-l1
            while(k):
                headBt=headBt.next
                k-=1
        while(headAt is not None):
            # print(headA.val)
            if headAt==headBt:return headBt
            headAt=headAt.next
            headBt=headBt.next
        return None

################################################################################################################
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        s=set()
        while(headA):
            s.add(headA)
            headA=headA.next
        while(headB):
            if headB in s:return headB
            headB=headB.next
        return None
        
