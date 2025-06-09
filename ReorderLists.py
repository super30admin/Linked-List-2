# // Time Complexity : o(n)
# // Space Complexity : o(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : concept of reversed List fast and slow pointer pattern


# // Your code here along with comments explaining your approach
# observe the list that needs to be merged it is reversed from middle so 
# first find middle using slow and fast revese the list from the middle and then merge them by adjusting the pointers

from typing import Optional
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        slow ,fast = head ,head
        def reverse(curr):
            prev = None
            while curr:
                temp = curr.next
                curr.next = prev
                prev = curr
                curr = temp
            return prev

        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        fast = reverse(slow.next)
        slow.next = None
        slow = head
        # merge the lists
        while fast:
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp
        return head 


        