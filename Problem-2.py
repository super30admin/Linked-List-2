# 143. Reorder List
'''
Leetcode all test cases passed: Yes
Solution:
    
    def reorderList(self, head: Optional[ListNode]) -> None:
        n is the no of nodes in head
        Space Complexity: O(1) 
        Time Complexity: O(n)
'''
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        length = 0
        curr = head
        while curr != None:
            curr = curr.next
            length += 1
        if length == 1:
            return head
        if length == 2:
            return head
        slow = head
        fast = head
        while fast.next != None and fast.next.next != None  :
            slow = slow.next
            fast = fast.next.next
        
        if length %2 == 0:
            slow = slow.next
        prev = None
        curr = slow.next
        
        fast = curr.next
        slow.next =None
        while fast != None:
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next
        
        fast = curr.next
        curr.next = prev
        slow = head
        while curr != None:
            temp = slow.next
            slow.next = curr
            curr = curr.next
            slow.next.next = temp
            slow = temp
        
            
        
        return head
