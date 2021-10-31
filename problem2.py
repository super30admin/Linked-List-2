#Time complexity O(n) space O(1)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        s=f=head
     #Finding the midpoint   
        while f.next and f.next.next:
            s=s.next
            f=f.next.next
    #calling the reverse function        
        head2 = s.next
        s.next=None
        head2=self.helper(head2)
# Merging two lists       
        while head2:
            temp=head.next
            head.next=head2
            head2=head2.next
            head.next.next=temp
            head=temp
        
#Reverse function to reverse list after mid      
    def helper(self,head):
        if head is None:
            return None
        cur=head
        prev=None
        nxt=head.next
     
        while cur:
            cur.next=prev
            prev=cur
            cur=nxt
            
            if nxt:
                nxt =nxt.next
                
        return prev
