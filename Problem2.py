# Time Complexity : 
# Space Complexity : 
# Did this code successfully run on Leetcode : 
# Any problem you faced while coding this : 


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

#reversing the second half of the list so that we can maintain pointer to iterate and mix the array
class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        slow = head
        fast = head
        while fast.next != None and fast.next.next != None:
            slow = slow.next
            fast = fast.next.next
        head2 = slow.next
        slow.next = None
        head2= self.reverseList(head2)
        slow = head
        fast = head2
        while slow != None and fast != None:
            x = slow.next
            y = fast.next
            slow.next = fast
            fast.next = x
            slow = x
            fast = y
        
    
    def reverseList(self, head: ListNode) -> ListNode:
        if head == None:
            return head
        if head.next == None:
            return head
        v1 = head
        v2 = head.next
        v3 = head.next.next
        while v3 != None:
            v2.next = v1
            if v1 == head:
                v1.next = None
            v1 = v2
            v2 = v3
            v3 = v3.next
        if v1 == head:
            v1.next = None
        v2.next = v1
        x = v2
        return v2
        
        