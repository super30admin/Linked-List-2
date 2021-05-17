"""
Intuition: 
Recognize the pattern. If we divide the array and half and then reverse the second half we get the n, n-1, n-2 items
Merge these 2 linked lists

#####################################################################
Time Complexity : O(N) where N = length of the linked list 
Space Complexity : O(1)
#####################################################################

"""
class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if head == None or head.next == None:
            return head
        
        slow = head
        fast = head
        
        while fast.next != None and fast.next.next != None:
            slow = slow.next
            fast = fast.next.next
        
        fast = self.getReverse(slow.next)
        slow.next = None
        slow = head
        
        while fast != None:
            curr = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = curr
            slow = curr
        return head
    
    def getReverse(self, head):
        
        prev = None
        curr = head
        fast = head.next
        while fast != None:
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next
        curr.next = prev
        return curr