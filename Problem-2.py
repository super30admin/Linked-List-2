'''
    Time Complexity: O(n)
    Space Complexity: O(1)
'''
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
        if not head.next:
            return
            
        slow, fast = head, head.next

        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        fast = slow.next
        slow.next = None

        prev = None

        while fast and fast.next:
            temp = fast.next
            fast.next = prev
            prev = fast
            fast = temp

        fast.next = prev
        slow = head
        
        while slow and fast:
            temp = slow.next
            slow.next = fast
            slow = temp
            temp = fast.next
            fast.next = slow
            fast = temp


        