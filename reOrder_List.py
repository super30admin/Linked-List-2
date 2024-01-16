""" Explanation: The reorderList function first finds the middle of the linked list using the slow and fast pointer approach.
    It then reverses the second half of the linked list.
    Finally, it merges the first half with the reversed second half by alternating the nodes.
    Time complexity of O(n)
    Space complexity of O(1).
    All TC's passed on LC: Yes
    """


# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution(object):
    def reorderList(self, head):
        """
        :type head: ListNode
        :rtype: None Do not return anything, modify head in-place instead.
        """
        if not head or not head.next:
            return head

        # Step 1: Find the middle of the linked list
        slow, fast = head, head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        # Step 2: Reverse the second half of the linked list
        prev, curr = None, slow
        while curr:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp

        # prev now points to the reversed second half

        # Step 3: Merge the first half with the reversed second half
        first, second = head, prev
        while second.next:
            temp1, temp2 = first.next, second.next
            first.next, second.next = second, temp1
            first, second = temp1, temp2
        