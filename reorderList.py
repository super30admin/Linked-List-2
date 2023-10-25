# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def reorderList(self, head):
        """
        :type head: ListNode
        :rtype: None Do not return anything, modify head in-place instead.
        """
        # T: O(N)
        # S: O(1)
        slow = head
        fast = head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next

        fast = slow.next
        slow.next = None
        # reverse the list
        prev = None
        while fast:
            temp = fast.next
            fast.next = prev
            prev = fast
            fast = temp
        slow = head
        while prev and slow:
            temp1 = slow.next
            temp2 = prev.next
            slow.next = prev
            prev.next = temp1
            prev = temp2
            slow = slow.next.next

