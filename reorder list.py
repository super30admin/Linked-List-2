# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

#TC: O(n)
#SC: O(1)
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        #null check
        if not head or not head.next or not head.next.next:
            return
        # middle
        slow = head
        fast = head

        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        
        def reverse(head):
            
            prev = None
            curr = head
            fast = head.next
            
            while fast:
                curr.next = prev
                prev = curr
                curr = fast
                fast = fast.next
                
            curr.next = prev
            return curr
        #reverse
        fast = reverse(slow.next)
        slow.next = None
        
        # merge
        slow = head
        while fast:
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp
            
        