# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
#Time Complexity : O(n)
#Space Complexity : O(1)
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        slow = head
        fast = head

        while fast.next != None and fast.next.next != None:
            slow = slow.next
            fast = fast.next.next
        
        # reverse second half
        prev = None
        curr = slow.next
        slow.next = None

        while curr != None:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        head2 = prev
        head1 = head
        # reorder
        while head1 and head2:
            temp = head1.next
            head1.next = head2
            head2 = head2.next
            head1.next.next = temp
            head1 = temp
    
            