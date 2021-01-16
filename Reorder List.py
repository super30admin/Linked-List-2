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
        #Time Complexity: O(n)
        #Space Complexity: O(1)
        
        if not head:
            return None
        
        slow_pointer = head
        fast_pointer = head
        
        while fast_pointer.next and fast_pointer.next.next:     #finding mid-point
            slow_pointer = slow_pointer.next
            fast_pointer = fast_pointer.next.next
        
        fast_pointer = self.reverse(slow_pointer.next)          #reversing second half
        slow_pointer.next = None                                #severing two lists
        slow_pointer = head
        
        while fast_pointer:                                     #merging two lists
            temp = slow_pointer.next
            slow_pointer.next = fast_pointer
            fast_pointer = fast_pointer.next
            slow_pointer.next.next = temp
            slow_pointer = temp
    
    def reverse(self, root):
        prev = None
        curr = root
        while curr:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        
        return prev