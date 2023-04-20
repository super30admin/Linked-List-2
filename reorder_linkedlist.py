# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
The linked lists are merged by first dividing them into two halves, such that the first is always greater than or 
equal to the second. Then we reverse the second half and use a three pointer approach to finally joint he two lists iteratively
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
        if head == None: return 

        # find the middle
        slow = head
        fast = head

        while fast.next != None and fast.next.next != None:
            slow = slow.next
            fast = fast.next.next

        # Reverse the second half of the LinkedList
        fast = self.reverseList(slow.next)
        slow.next = None
        slow = head

        # merge the two lists together
        while fast != None:
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp


    def reverseList(self, head: Optional[ListNode]) -> ListNode:
        if head == None or head.next == None:
            return head

        prev = None
        curr = head
        fast = head.next

        while fast != None:
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next

        curr.next= prev
        return curr