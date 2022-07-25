"""
Runtime Complexity:
O(n) - we find the mid of the linked list. Then we iterate the right part and reverse it. Then we merge both the linked. We iterate over 'n' nodes. Therefore the overall
runtime complexity is O(n)
Space Complexity:
O(1) -  since we do not allocate any additional data structures.
Yes, the code worked on leetcode.
"""
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if not head:
            return
        slow = head
        fast = head
        
        while(fast!=None and fast.next!=None):
            slow = slow.next
            fast = fast.next.next
       
    
        prev,curr = None, slow
        
        while(curr!=None):
            curr.next, prev, curr = prev, curr, curr.next
        
        first = head
        second = prev
        
        while(second.next):
            first.next,first = second, first.next
            second.next, second = first, second.next