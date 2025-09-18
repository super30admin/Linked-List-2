# Time Complexity : O(N) where N is the number of nodes in the linked list
# Space Complexity : O(1) as we only use a constant amount of extra space for pointers
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# We will use the slow and fast pointer technique to find the middle of the linked list.
# We will then reverse the second half of the linked list.
# Finally, we will merge the two halves of the linked list.


from typing import Optional
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        slow = head
        fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        second = slow.next
        slow.next = None
        node = None
        while second:
            temp = second.next
            second.next = node
            node = second
            second = temp
        first = head
        second = node
        while second:
            temp1,temp2 = first.next,second.next
            first.next ,second.next = second,temp1
            first,second = temp1,temp2

