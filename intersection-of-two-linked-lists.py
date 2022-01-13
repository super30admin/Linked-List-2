# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

# Time Complexity: O(m)
# Space Complexity: O(1)
class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        l1 = 0
        l2 = 0
        
        curr = headA
        while curr != None:
            curr = curr.next
            l1 += 1
        
        curr = headB
        while curr != None:
            curr = curr.next
            l2 += 1
        
        while l2 > l1:
            headB = headB.next
            l2 -= 1
        
        while l1 > l2:
            headA = headA.next
            l1 -= 1
        
        while headA != headB:
            headA = headA.next
            headB = headB.next
        return headA