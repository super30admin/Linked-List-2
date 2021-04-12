# Time Complexity : O(n), where n is the number of nodes
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

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
        if head.next is None or head.next.next is None:
            return head

        # Find middle element
        slow = head
        fast = head

        while fast is not None and fast.next is not None:
            slow = slow.next
            fast = fast.next.next

        # Reverse the second half
        prev = None
        curr = slow.next
        fast = curr.next

        while fast is not None:
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next

        curr.next = prev

        # Break list at mid element
        slow.next = None

        # Merge lists
        ptr1 = head
        ptr2 = curr
        temp1 = ptr1.next
        temp2 = ptr2.next

        while temp2 is not None:
            ptr1.next = ptr2
            ptr2.next = temp1

            ptr1 = temp1
            temp1 = temp1.next

            ptr2 = temp2
            temp2 = temp2.next

        ptr1.next = ptr2
        ptr2.next = temp1

        return head
