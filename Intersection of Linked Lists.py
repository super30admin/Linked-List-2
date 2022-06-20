# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

"""
TC: O(n)
SC: O(1)
"""
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        pa = headA
        pb = headB
        
        while pa != pb :
            pa = headB if pa is None else pa.next
            pb = headA if pb is None else pb.next
        
        return pa
