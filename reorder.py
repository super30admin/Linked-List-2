#Time complexity: O(n)
#Space complexity: O(1)

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverse(self, head):
        prev = None
        curr = head
        fast = head.next
        while fast is not None:
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next
        curr.next = prev
        return curr
        
    def reorderList(self, head: Optional[ListNode]) -> None:
        if head is None or head.next is None or head.next.next is None:
            return
        #mid
        slow = head
        fast = head
        while fast.next is not None and fast.next.next is not None:
            slow = slow.next
            fast = fast.next.next
        fast = self.reverse(slow.next)
        slow.next = None
        slow = head
        while fast is not None:
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp
        
        """
        Do not return anything, modify head in-place instead.
        """
        
