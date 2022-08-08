# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        Algo:
        1. Find the middle node 
        2. Reverse the second half 
        3. Merge two sorted lists (First is sorted, 2nd is resverse sorted)
        Merge them one after the other 
        T = O(N)
        S = O(1)
        """
        # finding middle node
        slow, fast = head, head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        middle = slow 
        
        # Reverse the second half
        prev , curr = None, middle 
        while curr:
            temp = curr.next 
            curr.next = prev 
            prev = curr 
            curr = temp 
    
        # Merge two sorted lists
        first , second = head , prev
        while second.next:
            temp = first.next
            first.next = second
            first = temp
            
            temp = second.next
            second.next = first
            second = temp
        
      
            
        
        
        
        
        
