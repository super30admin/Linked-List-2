'''
Time Complexity : O(n)
Space Complexity : O(1)
'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next


class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        length = 0
        slow = head
        while(slow != None):
            slow = slow.next
            length += 1
        if length == 1 or length == 2:
            return head
        slow = head
        fast = head

        while(fast.next != None and fast.next.next != None):
            slow = slow.next
            fast = fast.next.next
        prev = None
        if length % 2 == 0:
            slow = slow.next
        curr = slow.next
        fast = curr.next
        slow.next = None
        while(fast != None):
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next
        curr.next = prev
        slow = head

        while(curr != None):
            temp = slow.next
            slow.next = curr
            curr = curr.next
            slow.next.next = temp
            slow = temp
        return head
