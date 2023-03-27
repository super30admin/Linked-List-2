# Time Complexity - O(n)
# Space Complexity - O(1)


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

        if not head or not head.next:
            return
        slow = head 
        fast = head 

        while fast.next and fast.next.next :
            fast = fast.next.next
            slow = slow.next 
        
        reverse = self.reverse(slow.next)
        slow.next = None
        slow = head 
        fast = reverse 

        while fast :

            temp = slow.next

            slow.next = fast 
            
            fast = fast.next
            slow.next.next = temp 
            slow = temp

    def reverse(self,head):
        prev = None
        curr = head 
        fast = head.next 
        while fast :       
            curr.next = prev 
            prev = curr 
            curr = fast 
            fast = fast.next
        curr.next = prev
        return curr
