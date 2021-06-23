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
        :TC:O(n)
        :SC:O(1)
        """
        
        # key idea: compute mid---keep first half as it is-- reverse second half -- merge both halfs
        
        if not head: 
            return 
        
        slow=head 
        fast = head
        
        # compute mid
        while fast.next and fast.next.next:
            slow=slow.next
            fast=fast.next.next
            
        # slow will be at middle
        curr=slow.next
        prev=None
        # reverse second half
        while curr:
            nextt=curr.next
            curr.next=prev
            prev=curr
            curr=nextt
        slow.next=None
        
        # merge both
        cur1=head
        cur2 = prev
        
         #step 3: merge lists
        head1, head2 = head, prev
        while head2:
            nextt = head1.next
            head1.next = head2
            head1 = head2
            head2 = nextt
        
        
            