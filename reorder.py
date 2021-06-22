# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
# Time Complexity : O(n)
# Space Complexity: O(1)
class Solution(object):
    def reorderList(self, head):
        #         Base Condition
        if not head:
            return
        # Initialize pointers
        sp = head
        fp = head
        #        Initialize current ot head
        curr = head
        #       using slow and fast pointer we will reach to the middle of the list
        while fp and fp.next:
            sp = sp.next
            fp = fp.next.next

        #     We will then reverse the seconf part pf the list( from middle to end)
        # Assigning current to slow pointer
        prev = None
        curr = sp

        #         until there is current then we will assign current next to current previous and move previous to current and so on
        while curr:
            basic = curr.next
            curr.next = prev
            prev = curr
            curr = basic

        # curr.next = prev
        #   now one pointer at head and one pointer at reversed linked list
        f = head
        s = prev

        # and now take one node of current and another node of revered and so on till second pointer is not null
        while s.next:
            trial = f.next
            f.next = s
            f = trial

            trial = s.next
            s.next = f
            s = trial

        """
        :type head: ListNode
        :rtype: None Do not return anything, modify head in-place instead.
        """
