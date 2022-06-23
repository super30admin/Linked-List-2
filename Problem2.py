'''
Time Complexity: O(n)
Space Complexity: O(1)
Run on Leetcode: YES
'''
from typing import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def reverse(self, head) -> ListNode:
        prev = None
        curr = head
        while curr != None:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        return prev
    
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        # handling single element linked list
        if head.next == None:
            return None
        slow = head
        fast = head
        
        # finding the mid of the linked list
        while fast.next != None and fast.next.next != None:
            slow = slow.next
            fast = fast.next.next
            
        #reversing the second half
        fast = self.reverse(slow.next)
        slow.next = None

        #re ordering
        slow = head
        while(fast != None):
            tempS = slow.next
            tempF = fast.next
            slow.next = fast
            fast.next = tempS
            slow = tempS
            fast = tempF
        return None