# Time Complexity : O(n) where n is the numner of nodes
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# We find the midpoint of the list
# we reverse the second half of the list
# we join both list with alternatively

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

        if head is None or head.next is None:
            return

        fast = head.next
        slow = head

        while fast is not None and fast.next is not None:
            fast = fast.next.next
            slow = slow.next

        head2 = slow.next
        slow.next = None

        temp = head2
        prev = None

        while temp is not None:
            nextHead = temp.next
            temp.next = prev
            prev = temp
            temp = nextHead

        while prev is not None:
            temp = head.next

            temp2 = prev.next

            head.next = prev

            prev.next = temp

            head = temp

            prev = temp2



