'''
Time Complexity : 0(n)
Space Complexity : 1
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : Faced issue in updating the ptr's but resolved 
it


// Your code here along with comments explaining your approach
'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    
    def reverseLinkedList(self,head,prev,temp):
        
        # Use Iterative Way
        while head != None:
            
            prev = head
            head = head.next
            prev.next = temp
            temp = prev
        
        head = prev
        prev= None
        temp = None
        
        return head
    
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        
        # Step 1: Iterate slow and fast ptr
        slow = head
        fast = head
        
        while fast.next != None and fast.next.next != None:
            # slow by 1x speed
            slow = slow.next
            # fast by 2x speed
            fast = fast.next.next
            continue
        
        # Step 2: Reverse my linked-list from slow.next
        fast = self.reverseLinkedList(slow.next,None,None)
        
        # Step 3: Break the link b/w slow and reverse linked list
        slow.next = None
        slow = head
        
        # Step 4: Update the ptrs to reorder the list
        while (fast != None):
            tempSlow = slow.next
            slow.next = fast
            
            tempFast = fast.next
            fast.next = tempSlow
            
            slow = tempSlow
            fast = tempFast
            
            continue
        
        return head