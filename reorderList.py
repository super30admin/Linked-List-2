# // Time Complexity : O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# // Your code here along with comments explaining your approach:

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        #if no head, simply return 
        if not head:
            return 
        
        #Finding the middle of the list by two pointers
        slow = head
        fast = head
        while fast != None and fast.next != None:
            slow = slow.next
            fast = fast.next.next
        
        #break the list into two individual lists: one would be from start till middle
        #second would be from middle+1 till the end
        head2 = slow.next
        slow.next = None
        curr = head2
        
        #reverse the second list
        temp = None
        prev = None
        while curr != None:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        head2 = prev
        
        #now merge the two lists such that we get our required llist
        h1 = head
        temp1 = None
        temp2= None
        while head2!=None:
            temp1 = h1.next
            h1.next = head2
            temp2 = head2.next
            head2.next = temp1
            head2 = temp2
            h1 = temp1
            
                
            
        