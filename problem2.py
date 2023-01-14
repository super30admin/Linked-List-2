# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        if headA == None or headB == None:
            return None

        A_pointer = headA
        B_pointer = headB

        while A_pointer != B_pointer:
            if A_pointer == None:
                A_pointer = headB 
            else:
                A_pointer=A_pointer.next
            if B_pointer == None:
                 B_pointer = headA
            else:
                B_pointer=B_pointer.next

        return A_pointer
            