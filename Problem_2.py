"""
Time Complexity : O(n) 
Space Complexity : O(1) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach:
This solution is combination of 3 sub problems. First we need to divide our list into half. We do that
by using slow and fast pointer. Then we reverse our second list. We have made a separete method for that.
Third step would be combining both the lists in an alternate fashion.

"""
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next


class Solution(object):
    def reorderList(self, head):
        if not head or not head.next:
            return head
        slow, fast = head, head
        # Find mid
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        # Reverse the second half
        fast = self.reverse(slow.next)
        slow.next = None
        slow = head
        curr = ListNode()
        # Merge 2 lists
        while fast:
            curr = slow
            slow = slow.next
            curr.next = fast
            fast = fast.next
            curr.next.next = slow
        return head

    def reverse(self, head):
        prev = None
        curr = ListNode()
        curr = head
        fast = head.next
        while fast:
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next
        curr.next = prev
        return curr
