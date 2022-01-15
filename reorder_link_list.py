
# Definition for singly-linked list.

# sc :O(1)
# tc :O(n)
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

from typing import Optional


def reverse_link_list(head):
    if not head:
        return head
    
    prev = None
    curr = head
    forw = head.next
    
    while curr :
        curr.next = prev
        prev = curr
        curr = forw
        if forw:
            forw = forw.next
    
    return prev
        
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        slow = head
        fast = head 
        
        while fast.next and fast.next.next:
            fast = fast.next.next
            slow = slow.next
        
        head2 = slow.next
        slow.next = None
        head2 = reverse_link_list(head2)
        
        while (head2):
            temp = head.next
            head.next = head2
            head2 = head2.next
            head.next.next = temp
            head = temp
        
        
        