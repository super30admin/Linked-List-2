# Accepted in leetcode(143)
# time - O(N), space - O(1)
# split the list into 2 sub lists and then reverse the second list. Then, take one element from both lists alternatively and then return whole array.
# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):
    def reorderList(self, head):
        """
        :type head: ListNode
        :rtype: None Do not return anything, modify head in-place instead.
        """
        # edge case
        if head is None or head.next is None:
            return None
        slow = head
        fast = head
        # to calculate mid
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        # reverse the second half of linked list
        fast = self.reverse(slow.next)
        slow.next = None  # half the first linked list
        slow = head  # start at head
        temp = ListNode(None)  # declare a temp list node
        while slow != None and fast != None:
            temp = slow.next  # save slow.next to a temp variable
            slow.next = fast  # alternate fast element
            fast = fast.next  # increment fast
            slow.next.next = temp  # slow's next declare it to temp
            slow = temp

    def reverse(self, head):
        prev = None
        curr = head
        temp = curr.next
        while temp:
            curr.next = prev
            prev = curr
            curr = temp
            temp = temp.next
        curr.next = prev
        return curr