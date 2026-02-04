# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:

        if not headA or not headB:
            return

        curr = headA
        lengthA = 0

        while curr:
            lengthA += 1
            curr = curr.next

        lengthB = 0
        curr = headB

        while curr:
            lengthB += 1
            curr = curr.next

        slow = headA
        fast = headB

        while lengthA > lengthB:
            slow = slow.next
            lengthA -= 1

        while lengthB > lengthA:
            fast = fast.next
            lengthB -= 1


        while slow != fast:
            slow = slow.next
            fast = fast.next

        return slow        
    
# Time Complexity : O(m+n)
# Space Complexity: O(1)