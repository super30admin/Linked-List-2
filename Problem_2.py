# Time Complexity: O(n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

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
        if (not head) or (not head.next) or (not head.next.next):
            return
        first, sec = head, head
        while sec.next and sec.next.next:
            first = first.next
            sec = sec.next.next
        headnode = first.next
        first.next = None
        num = ListNode(0, None)
        while headnode:
            temp = headnode.next
            headnode.next = num.next
            num.next = headnode
            headnode = temp
        headNode = head
        headnode = num.next
        while headNode and headnode:
            temp = headnode
            headnode = headnode.next
            temp.next = headNode.next
            headNode.next = temp
            headNode = headNode.next.next