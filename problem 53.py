#  https://leetcode.com/problems/reorder-list/


# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach

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
        while fast.next is not None and fast.next.next is not None: # go until end 2 conditions because for even length and odd length
            slow = slow.next
            fast = fast.next.next
        
        fast = self.reverse(slow.next) # reverse the list
        slow.next = None # severe the link after slow pointer
        slow = head # reset slow to start

        while(fast is not None): # go until the end again
            temp = slow.next # store the next in slow in temp
            slow.next = fast # now connect slow with the fast pointer in ll2
            fast = fast.next # move fast pointer
            slow.next.next = temp # creating link from second LL to first LL
            slow = temp # moving slow pointer


    def reverse(self, head: Optional[ListNode]) :
        prev = None
        curr = head
        while(curr is not None): # reverse the LL
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        return  prev

