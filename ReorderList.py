#TC:O(n)
#SC:O(1)
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
        if (head==None or head.next==None or head.next.next==None): return 
        def reverse(root):
            prev=None
            curr=root
            fa=root.next
            while(fa!=None):
                curr.next=prev
                prev=curr
                curr=fa
                fa=fa.next
            curr.next=prev
            return curr
                
    
            
        f=s=head
        while(f.next!=None and f.next.next!=None):
            s=s.next
            f=f.next.next
        
        h2=reverse(s.next)
        s.next=None
        h1=head
        while(h2!=None):
            t1=h1
            h1=h1.next
            t1.next=h2
            t2=h2
            h2=h2.next
            t2.next=h1