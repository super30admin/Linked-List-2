# Time Complexity : O(n) - n is number of elements in the linked list
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

"""

Find mid of the linked list
Reverse the second half of the linked list
Disconnect mid from original mid.next
Move slow to head
Move fast to head of the reversed list
Now iterate over slow and fast to create the required order

"""


# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def reverse(self, head):
        prev = None
        curr = head

        while curr is not None:
            tmp = curr.next
            curr.next = prev
            prev = curr
            curr = tmp

        return prev

    def reorderList(self, head):
        """
        :type head: Optional[ListNode]
        :rtype: None Do not return anything, modify head in-place instead.
        """

        # find the middle of the linked list
        slow = head
        fast = head

        while fast.next is not None and fast.next.next is not None:
            slow = slow.next
            fast = fast.next.next

        # reverse the second half of the linked list
        fast = self.reverse(slow.next)
        slow.next = None

        slow = head

        while fast is not None:
            tmp = slow.next
            slow.next = fast
            tmp2 = fast
            fast = fast.next
            tmp2.next = tmp
            slow = tmp






