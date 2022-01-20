#TimeComplexity:O(n)
#SpaceComplexity:O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this :No
# We can solve this using two pointers approach.
# First we find the mid point and then we reverse the second half.
# We then merge the two lists one after another





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
        
        curr = head
        l = 1
        
        if head == None or head.next == None:
            return head
        
  
        
        slow = head
        fast = head
        
        while(fast.next != None and fast.next.next != None):
            
            slow = slow.next
            fast = fast.next.next

        # print(slow.val)
        
        fast = self.reverse(slow.next)
        
        slow.next = None 
        
        slow = head
        
        temp = None
        
        while(fast != None):
            
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp
        
        
        
    
    def reverse(self,node):
        
        prev = None
        curr = node
        fast = node.next
        while(fast !=None):
            
            
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next
        curr.next = prev
        
        return curr
    
        
        
            
        
        