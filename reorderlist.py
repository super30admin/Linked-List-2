# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    #O(N)
    #O(1)
    def reorderList(self, head):
        """
        :type head: ListNode
        :rtype: None Do not return anything, modify head in-place instead.
        """
        #1>>locate middle
        if not head:
            return
        s=head
        f=head
        while f and f.next:
            s=s.next
            f=f.next.next
            if s==f:
                mid=s
                break
        #2>>split into 2 sublist
        f=s.next
        s.next=None
        s=head
        #3>>reverse 2nd half
        def rev(h):
            if not h or not h.next:
                return h
            revnode=rev(h.next)
            h.next.next=h
            h.next=None
            return revnode
        f=rev(f)
        #4>>reorder
        while f:
            t=s.next
            s.next=f
            f=f.next
            s.next.next=t
            s=t
        
        
            
            
        