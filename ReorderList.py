#// Time Complexity : O(n) 
# // Space Complexity : O(1)   
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no i saw the class and then did the problem

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
        def reverse(node):
            prev = None
            curr = node
            while curr!= None:
                temp = curr.next
                curr.next = prev
                prev = curr
                curr = temp
            return prev

        #middle
        slow = head
        fast = head
        while fast.next != None and fast.next.next!=None:
            slow = slow.next
            fast = fast.next.next
        #reverse
        fast = reverse(slow.next)
        slow.next = None
        slow = head

        while fast !=None:
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp

# Approach:
# 1. Find the middle of the linked list
# 2. Reverse the second half of the linked list
# 3. Merge the two halves of the linked list

