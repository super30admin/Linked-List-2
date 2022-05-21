'''
time complexity: O(n)
space complexity: O(1)
'''
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
        #1. Find middle element
        slow = head
        fast = head
        while(fast!=None and fast.next!=None):
            slow=slow.next
            fast=fast.next.next

        #2. reverse the list
        prev=None
        current=slow
        ptr3 = slow.next
        while ptr3!=None:
            current.next = prev
            prev=current
            current=ptr3
            ptr3=ptr3.next
        current.next=prev

        #3. merge
        while current.next!=None:
            temp=head.next
            head.next=current
            current=current.next
            head.next.next=temp
            head=temp