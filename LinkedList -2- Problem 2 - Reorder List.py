"""
FAANMG Problem #53 {Medium}

143. Reorder List

Time Complexity : O(N)


Space Complexity : O(1)


Did this code successfully run on Leetcode : Yes
  

First We are trying to find the middle of the Linked List by using the slow and the fast pointer
Where slow pointer moves 1 step
Fast pointer moves 2x step

Once we get the middle:
    Slow is pointing to the middle and fast is pointing to the end of the linlked list
 
As slow is behind the head of LL to be reversed, we pass slow.next to the reverse funtion

Reverse Funtion uses 3 pointers 
prev
curr 
fast

After the list is reversed we will now mnerge both the list together alternatively



@name: Rahul Govindkumar_RN27JUL2022
"""

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
        
        # function to reverse the list
        def reverse(head):
            prev = None
            curr = head
            fast = head.next

            while(fast):
                curr.next =prev
                prev = curr
                curr = fast
                fast = fast.next
            curr.next=prev
            return curr
        
        if(head is None or head.next is None):
            return
        
        
        #find middle of the list
        
        slow = head
        fast = head
        
        while(fast.next is not None and fast.next.next is not None):
            
            slow= slow.next
            fast = fast.next.next
         
       #As slow is behind the head of LL to be reversed
        
        fast = reverse(slow.next)
        slow.next = None
        slow = head
        

        #merging two list
        
        while(fast):
            temp = slow.next
            slow.next=fast
            fast = fast.next
            slow.next.next =temp
            slow =temp
            
            
        
        