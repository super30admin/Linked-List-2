# Time Complexity : O(m+n)
# Space Complexity : O(1);
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def helper(self, head):
        prev = None
        curr = head
        next = head.next
        while next:
            curr.next = prev
            prev = curr
            curr = next
            next = next.next
        curr.next = prev
        return curr

    def reorderList(self, head):
        """
        Do not return anything, modify head in-place instead.
        """
        if not head.next:
            return
        slow = head
        fast = head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        last = self.helper(slow.next)
        slow.next = None
        start = head
        while last:
            temp1 = start.next
            temp2 = last.next
            start.next = last
            last.next = temp1
            start = temp1
            last = temp2
        return head

    def printList(self):
        temp = self.reorderList(check)
        while temp:
            print(temp.val, end=" ")
            temp = temp.next


check = ListNode(1)
check.next = ListNode(2)
check.next.next = ListNode(3)
check.next.next.next = ListNode(4)
check.next.next.next.next = ListNode(5)
check.next.next.next.next.next = ListNode(6)
check.next.next.next.next.next.next = ListNode(7)
check.next.next.next.next.next.next.next = ListNode(8)
Solution().printList()


# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
#
#
# class Solution:
#     def __init__(self):
#         self.last = None
#
#     def helper(self, head):
#         if head.next is None:
#             return
#         self.last = head.next
#         self.helper(head.next)
#         head.next.next = head
#         head.next = None
#
#     def reorderList(self, head):
#         """
#         Do not return anything, modify head in-place instead.
#         """
#         if not head.next:
#             return head
#         slow = head
#         fast = head
#         while fast.next and fast.next.next:
#             slow = slow.next
#             fast = fast.next.next
#         if not slow.next.next:
#             self.last = slow.next
#         else:
#             self.helper(slow.next)
#         slow.next = None
#         start = head
#         while self.last:
#             temp1 = start.next
#             temp2 = self.last.next
#             start.next = self.last
#             self.last.next = temp1
#             start = temp1
#             self.last = temp2
#         return head
#
#     def printList(self):
#         temp = self.reorderList(check)
#         while temp:
#             print(temp.val, end=" ")
#             temp = temp.next
#
#
# check = ListNode(1)
# check.next = ListNode(2)
# check.next.next = ListNode(3)
# check.next.next.next = ListNode(4)
# check.next.next.next.next = ListNode(5)
# check.next.next.next.next.next = ListNode(6)
# check.next.next.next.next.next.next = ListNode(7)
# check.next.next.next.next.next.next.next = ListNode(8)
# Solution().printList()
