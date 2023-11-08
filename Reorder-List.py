# Time Complexity - O(n)
# Space Complexity - O(1)

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        # middle of list
        slow, fast = head, head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            
        # reverse the second half of the list
        prev, curr = None, slow
        while curr:
            curr.next, prev, curr = prev, curr, curr.next
            
        # merge the lls
        first, second = head, prev
        
        while second.next:
            first.next, first = second, first.next
            second.next, second = first, second.next
        