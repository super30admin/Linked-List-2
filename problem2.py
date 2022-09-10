"""
Time Complexity  : O(n) where n is the number of nodes in the Linked List
Space Complexity : O(1) No auxillary data structure is use
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
1. Find mid point of the LinkedList
2. Reverse the Linked List
3. Reorder and Merge the Linked List
"""
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reversedList(self, head):
        if head == None or head.next == None:
            return head
        
        prev = None
        curr = head
        fast = head.next
        
        while(fast != None):
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next
        
        curr.next = prev
        
        return curr
            
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if head == None or head.next == None:
            return
        
        slow  = head
        fast = head
        
        #Find the mid
        while fast.next != None and fast.next.next != None:
            slow = slow.next
            fast = fast.next.next
        
        #Reverse the List
        fast = self.reversedList(slow.next)
        
        slow.next = None
        slow = head
        
        #Reorder and Merge the list
        while fast != None:
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp
        
        
       
    
        