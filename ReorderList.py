# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

# Space Complexity - o(1)
# Time Complexity - o(n)
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        slow = head
        fast = head

        while fast.next and fast.next.next: # Time Complexity - o(n)

            slow = slow.next
            fast = fast.next.next

        
        curr = slow.next
        slow.next = None
        prev = None

        while curr:                         # Time Complexity - o(n)
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp

        
        slow = head

        while prev:                         # Time Complexity - o(n)
            temp = slow.next
            slow.next = prev
            prev = prev.next
            slow.next.next = temp
            slow = temp

        