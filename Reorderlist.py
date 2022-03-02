# TC: O(n) where n is the number of nodes in linked list
# SC: O(1)

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
        slow, fast = head, head
        def reverse(head):
            prev=None
            curr = head
            while(curr!=None):
                new = curr.next
                curr.next = prev
                prev = curr
                curr = new
            return prev
        
        # finding mid point
        while(fast.next!=None and fast.next.next!=None):
            fast = fast.next.next
            slow = slow.next
            
        #reverse second half of list
        head2 = reverse(slow.next)
        slow.next = None
        
        #merging
        while(head2!=None):
            temp1 = head.next
            head.next = head2
            
            temp2 = head2.next
            head2.next = temp1
        
            head, head2 = temp1, temp2
