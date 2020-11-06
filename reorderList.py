#Time Complexity : O(n) where n is number of elements in the tree
#Space Complexity : O(h)

#Did this code successfully run on Leetcode : Yes
#Three line explanation of solution in plain english: First find the half of the linked list, then after reverse this second half of the linkedlist and then this gives us two linked list, which we need to merge.

#Your code here along with comments explaining your approach

# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if not head or not head.next:
            return

        fast, slow = head, head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next

        curr = slow.next
        prev = slow.next = None
        while curr:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp

        h1, h2 = head, prev
        while h2:
            t1, t2 = h1.next, h2.next
            h1.next = h2
            h2.next = t1
            h1, h2 = t1, t2

        return head
