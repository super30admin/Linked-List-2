# Time Complexity : O(n), n is no of nodes in the given list
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA 

# Your code here along with comments explaining your approach:
# this problem is divided in 3 parts:
# i) finding the mid element of a LL
# ii) reversing the second half of the given LL
# iii) merging the two halves, alternatively
# to find mid, we yuse two pointers, when fast reaches the end, slow must be at mid
# to reverse the second list we use prev and connect curren.next to prev
# then slow contains the head of the first list and fast contains the head of the second list
# we connect slow.next to fast and fast.next to slow (using temp pointers)



# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution(object):
    def reorderList(self, head):
        """
        :type head: Optional[ListNode]
        :rtype: None Do not return anything, modify head in-place instead.
        """
        # empty list
        if head is None or head.next is None:
            return head

        # finding mid of the list
        slow = head
        fast = head
        while (fast.next is not None and fast.next.next is not None):
            slow = slow.next
            fast = fast.next.next
        
        mid = slow

        # reversing the second list
        current = mid.next
        prev = None
        
        while(current is not None):
            temp = current.next
            current.next = prev
            prev = current
            current = temp

        # storing the head of the second list in fast
        fast = prev
        # storing the head of the first list in slow
        slow = head

        # unlinking the two lists
        mid.next = None

        # merging the lists in the required order
        while (fast is not None):
            temp1 = slow.next
            temp2 = fast.next

            slow.next = fast
            fast.next = temp1

            slow = temp1
            fast = temp2
        
        return head