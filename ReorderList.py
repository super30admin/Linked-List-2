#Time Complexity : O(n) since we iterate through the linked list. 
#Space Complexity : O(1) since we are not using any extra space
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this :No

#Approach: We divide the problem in 3 parts: 
# 1. Find the middle of the linked list using slow and fast pointer, where slow would reach the middle element.abs
# 2. Reverse the second half of the linked list starting from the next element of the middle element. Then break the connection
# between the them but pointing next of middle element to None.abs
# 3. Now we merge the two linkedlist alternatively.


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
        if head is None or head.next is None or head.next.next is None: return
        #Find mid
        slow = head
        fast = head
        while fast.next is not None and fast.next.next is not None:
            slow = slow.next
            fast = fast.next.next
        # Reverse the second half
        fast = self.reverseList(slow.next)
        # Break the two linkedlist
        slow.next = None
        slow = head
        # Merge the two linkedlist alternatively
        while fast is not None:
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp
    
    def reverseList(self, head):
        prev = None
        curr = head
        fast = curr.next
        while fast is not None:
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next
        curr.next = prev
        return curr