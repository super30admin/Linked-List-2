# Time Complexity = O(n)
# Space Complexity = O(1)


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
        
        # If only 1 or 2 elements in the LL
        if head == None or head.next == None:
            return 
        
        slow = head
        fast = head
        
        # (1) Find the middle element
        while(fast.next != None and fast.next.next != None):
            slow = slow.next
            fast = fast.next.next
        
        
        
        # (2) Reverse 2nd half of LL
        fast = self.reverse(slow.next)          # Because slow is at the middle of the list
        
        
        # (3) Breaking the list into 2
        slow.next = None
    
        
        
        # (4) Merging the 2 lists together - fast and slow one, line 26, 29
        slow = head
        temp = None
        while (fast != None):
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp

        return head
            
            
        
        
    def reverse(self, head):
        if head == None or head.next == None:
            return head
        
        prev = None
        curr = head
        fast = head.next
        
        
        while(fast != None):
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next
            
        curr.next = prev            # Reversing the last nodes
       
        return curr
        