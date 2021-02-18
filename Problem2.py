"""
143. Reorder List
Time Complexity - O(n)
Space Complexity - O(1)
1) Using Slow and fast pointer concept identified center of list
2) Reverse the Linkedlist afetr middle point
3) firxt LinkeList.next = Second linkedList and Second LinkedList.next = First LinkedList"""
class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        slow = fast = head
        while fast != None and fast.next != None:
            slow = slow.next
            fast = fast.next.next
            
        fast = self.reverse(slow.next)
        slow.next = None
        
        slow = head
        while (slow!= None and fast != None):
            slow_next = slow.next
            fast_next = fast.next
            
            slow.next = fast
            fast.next = slow_next
            
            slow = slow_next
            fast = fast_next
    #To reverse LinkedList from center of Linked List
    def reverse(self,head):
        current = head
        prev = None
        
        while(current != None):
            next_val = current.next
            current.next = prev
            prev = current
            current = next_val
        head = prev
        return head
        