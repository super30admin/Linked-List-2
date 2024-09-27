"""

## Problem2 (https://leetcode.com/problems/reorder-list/)
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.

"""


# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if head == None or head.next == None:
            return

        slow = head
        fast = head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next

        fast = self.reverse(slow.next)
        slow.next = None   #set middle.next to null
        slow = head       # move slow pointer to head

        while fast != None:       # reset the links
            curr = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = curr
            slow = curr

    def reverse(self, head):    # reverse after middle
        prev = None
        curr = head
        while curr != None:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        return prev



    """
    # Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def reorderList(self, head: ListNode) -> None:
        
        Do not return anything, modify head in-place instead.
        
        def reverse(head):
            prev = None
            curr = head
            while curr != None:
                temp = curr.next
                curr.next = prev
                prev = curr
                curr = temp
            return prev 
        
        if head == None or head.next==None:
            return

        slow = head
        fast = head
        while fast.next and fast.next.next:
            slow=slow.next
            fast=fast.next.next

        fast = reverse(slow.next)
        slow.next=None
        slow = head

        while fast != None:
            curr = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next= curr
            slow = curr
              
    """






