# Leetcode 143. Reorder List

# Time Complexity :  O(n) where n is the size of the list

# Space Complexity : O(1)

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Traverse to the mid point using slow pointer at 1x speed and fast pointer at 2x unitl 
# fast points to last node. Reverse the second half of the list starting from element next to slow 
# pointer. And move slow to head of the first half. Using another current pointer merge the reversed 
# half of the list with first half

# Your code here along with comments explaining your approach

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
        # Base
        if not head or not head.next:
            return 
        
        slow = head
        fast = head
        
        # Moving fast to the end and slow to middle
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        # Reversing the second half and setting fast to the head of reversed list    
        fast = self.reverse(slow.next)
        # Breaking the connection and seperating into 2 lists for merging
        slow.next = None
        # resetting slow to the head
        slow = head
        
        # Merging slow and fast lists using a current pointer 
        while fast:         #AS fast is the first pointer to reach end of a list
            # use current pointer to track next node in list before breaking connection with head
            curr = slow.next
            # Break connection and point to fast as next element
            slow.next = fast
            # Fast is done with its part move it to the next position in reversed list
            fast = fast.next
            # reConnect the node from reversed to the curr using slow
            slow.next.next = curr
            # Move slow to curr and repeat till fast is at the end
            slow = curr
            
    def reverse(self,head):
        if not head or not head.next:
            return head
        last = self.reverse(head.next)
        head.next.next = head
        head.next = None
        
        return last