#Time Complexity = O(n)
#Space Complexity = O(1)

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
        if(head==None or head.next==None):
            return 
        slow = head
        fast = head.next
        while(fast!=None and fast.next!=None ):
            slow = slow.next
            fast = fast.next.next
        dummy = slow.next 
        slow.next = None
        dummy = (self.reverse(dummy))
        s1 = head
        while(dummy!=None):
            f = s1.next
            s1.next = dummy
            dummy = dummy.next
            s1.next.next = f
            s1 = s1.next.next
            

        
    def reverse(self,dummy):
        final = dummy
        prev=  None
        curr = dummy
        fast = dummy.next
        while(fast!=None):
            curr.next = prev
            prev= curr
            curr = fast
            fast = fast.next
        curr.next = prev
        return curr
        
            
        
        
            
        
        
            
        
        