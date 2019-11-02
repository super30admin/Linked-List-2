# leet code- 143
# Time complexity -O(N)
#space complexity-O(1)
# Approach - First we need to find the middle node. Then we have to reverse the second half nodes. First pointer starts from the begining of first half and second pointer starts from begining  of second half.


# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reorderList(self, head):
        """
        :type head: ListNode
        :rtype: None Do not return anything, modify head in-place instead.
        """
        #edge case
        if head==None or head.next==None:
            return
        
        
        mid = self.middle(head)
        head2 = self.reverse(mid.next)
        head1=head
        mid.next=None
        
        while head1 and head2:
            temp=head2.next
            head2.next=head1.next
            head1.next=head2
            head2=temp
            head1=head1.next.next
            
        return head
            
        
    #finding the middle elemnet
    def middle(self,head):
        slow=head
        fast=head
        while fast.next!=None and fast.next.next!=None:
            slow=slow.next
            fast=fast.next.next

        return slow
    
          
    #reversing function
    def reverse(self,head):
        prev=None
        cur=head
        while cur!=None:
            temp=cur.next
            cur.next=prev
            prev=cur
            cur=temp
        return prev
            
        