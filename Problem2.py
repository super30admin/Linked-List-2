# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        
        if head == None or head.next == None:
            return head
        
        slow = head
        fast = head
        
        while fast.next != None and fast.next.next != None:
            slow = slow.next
            fast = fast.next.next
            
        head2 = slow.next
        slow.next = None
        
        head2 = self.reversesetL(head2)
        head1 = head
        while head2 != None and head1 != None:
            temp1 = head1.next
            temp2 = head2.next
            
            head1.next = head2
            head2.next = head1
            
        return head
        
        
    def reversesetL(self,head):
        p1 = None
        p2 = head
        p3 = head.next
        
        while p3 != None:
            p2.next = p1
            p1 = p2
            p2 = p3
            p3 = p3.next
        
        p2.next = p1
        return p2
        
