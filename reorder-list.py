# Time Complexity: O(n)
# Space Complexity: O(1)
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
        if head is None:
            return
        
        # Finding the middle element in the linkedlist using two pointers
        slow = fast = head
        
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        
         # Save the new head in head2 which is the element next to slow
        head2 = slow.next
        #Making the last element point to null
        slow.next = None
        
        # Reversing the second half of the list 
        prevNode = None
        currNode = head2
        
        while currNode:
            nextNode = currNode.next
            currNode.next = prevNode
            prevNode = currNode
            currNode = nextNode
            
         # This is done to make the last node the head since the linked list is reversed
        head2 = prevNode
        
        
        # Merging both the linked lists by reusing the slow and fast pointers
        while head2:
            temp = head.next
            head.next = head2
            head2 = head2.next
            head.next.next = temp
            head = temp
        
        return head
        
        
        
        
        