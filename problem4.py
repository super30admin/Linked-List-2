#intersection of two linked list
#time complexity:O(n+m) where n and m are two sepectre list nodes
#space compliexty:O(1)

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        A = headA
        B = headB
        while A!=B:
            A = headB if A is None else A.next
            B = headA if B is None else B.next
        
        return A