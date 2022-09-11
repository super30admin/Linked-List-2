# // Time Complexity : O(m+n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :

# First we move both the lists to last and calculate the length
# then we move the ptrs which are at the head of the list
# we see which len is greater and move that pointer until the lenth is same
# After the length is same then, we move poth the pointers until both are same
# #Return any one of the pointer 

# // Your code here along with comments explaining your approach

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        len1,len2=0,0
        pt1,pt2=headA,headB
        
        while headA:
            headA=headA.next
            len1+=1
            
        while headB:
            headB=headB.next
            len2+=1
            
        
        while len1>len2:
            pt1=pt1.next
            len1-=1
        
        while len2>len1:
            pt2=pt2.next
            len2-=1
                
        while pt1!=pt2:
            pt1=pt1.next
            pt2=pt2.next
            
        return pt2