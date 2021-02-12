'''
Time complexity: O(N)
Space complexity: O(1)
'''
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if head is None:
            return None
        
        # Find middle
        slow = head
        fast = head
        
        while fast and slow and fast.next:
            slow = slow.next
            fast = fast.next.next
        
        # Reverse second half and split
        fast = self.reverseS(slow.next)
        slow.next = None
        
        # Combine
        slow = head
        while fast and slow:
            nextS = slow.next
            nextF = fast.next
            slow.next = fast
            fast.next = nextS
            slow = nextS
            fast = nextF
        
    def reverseS(self, head):
        curr = head
        prev = None
        next = None
        
        while curr:
            next = curr.next
            curr.next = prev
            prev = curr
            curr = next
        return prev
        