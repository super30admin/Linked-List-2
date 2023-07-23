# Time complexity : O(n)
# Space complexity : O(1)

#Brute force ways-
# 1. Use an array and get all elements and form a new LL the way you want using the array.
# 2. Make a new reverese LL and make the pattern needed. 
# Above both use O(n) space, so won't work in interview

# It's a 3 parter.
# 1. Find the middle use slow(1x) and fast(2x) method till fast==None
# 2. Reverse the 2nd part
# 3. Then join the 2 sorted lists

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
        #1. Find middle
        slow=fast=head

        while fast.next!=None and fast.next.next!=None: #slow is at the mid point
            slow=slow.next
            fast=fast.next.next
        
        #2. Reverse the 2nd part
        def reverseLL(head):
            if head==None or head.next==None:
                return head
            rev=reverseLL(head.next)
            head.next.next=head
            head.next=None
            return rev
        
        fast=reverseLL(slow.next) #reverse the 2nd of the LL
        slow.next=None #mid point to next LL the link will still be there
        slow=head

        #3. Join the 2 sorted lists
        while slow and fast:
            temp=slow.next
            slow.next=fast
            fast=fast.next
            slow.next.next=temp
            slow=temp
        
        return head
        
            
            


        
        

        