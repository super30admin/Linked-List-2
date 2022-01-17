
# // Time Complexity : O(M+N) => O(N)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :


# // Your code here along with comments explaining your approach



# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        lenA = 0
        lenB = 0
        curr = headA
        while(curr != None):
            curr = curr.next
            lenA += 1

        curr = headB
        while(curr != None):
            curr = curr.next
            lenB += 1

        while(lenA > lenB):
            headA = headA.next
            lenA -= 1

        while(lenB > lenA):
            headB = headB.next
            lenB -= 1

        while(headA != headB):
            headA = headA.next
            headB = headB.next

        return headA
        
        
    