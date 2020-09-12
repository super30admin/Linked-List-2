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
        # 1. point to middle element of the LL
        # 2. reverse the second part of LL
        # 3. rejoin the two list
        
        if(head == None):
            return None
        
        slow = head
        fast = head
        
        while(fast and fast.next):
            slow = slow.next
            fast = fast.next.next
        
        head2 = self.reverse(slow.next)
        slow.next = None
        
        self.merge(head, head2)
        
    def reverse(self, root):
        prev = None
        current = root
        next = None
        
        while(current):    
            next = current.next
            current.next = prev
            prev = current
            current = next
            
        return prev
        
    def merge(self, head1, head2):
        while(head2):
            temp1 = head1.next
            head1.next = head2
            temp2 = head2.next
            head2.next = temp1
            head1 = temp1
            head2 = temp2
