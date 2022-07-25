# Time Complexity : O(N)  //Where n is the size of the list we are iterating
#  Space Complexity : O(1)  //We are not using any extra space
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : N/A

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
        #Base Case
        if not head or not head.next:
            return None
        
        #Declare our pointers
        slow = head
        fast = head
        
        #Traverse the linked list to finf the middle point with help of slow and fast
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        
        #Reverse second half of linked list
        fast = self.reverse(slow.next)
        slow.next = None
        
        #Merging the two halves. We merge the two halves by alternatively adding node from both halves
        slow = head
        tmp = None
        while fast:
            tmp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = tmp
            slow = tmp
        
    #Our helper function that reverses half the linked list with help of prev current and the fast node 
    def reverse(self, head):
        if head == None or head.next == None:
            return head
        
        prev = None
        curr = head
        fast = head.next
        
        while fast:
            curr.next = prev  
            prev = curr
            curr = fast
            fast = fast.next
        
        curr.next = prev
        return curr