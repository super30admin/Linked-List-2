# Time Complexity :O(n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no


# Your code here along with comments explaining your approach
# Find the middle of the linked list and split it into two halves.
# Reverse the second half of the list in-place.
# Merge both halves alternately to reorder the list.

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
        slow = head
        fast = head
        # go to mid and break into 2 parts
        while fast.next and fast.next.next:
            fast = fast.next.next
            slow = slow.next
        
        head1 = head
        head2 = slow.next
        slow.next = None
        prev= None
        #reverse the second half
        while head2 != None:
            temp = head2.next
            head2.next = prev
            prev = head2
            head2 = temp
        head2 = prev
    
        while head2 != None:
            temp = head1.next
            head1.next = head2
            temp1 = head2.next
            head2.next = temp
            head1 = temp
            head2 = temp1


        