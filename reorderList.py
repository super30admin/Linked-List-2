#143. Reorder List
#Time Complexity : O(n) 
#Space Complexity : O(n)
#Did this code successfully run on Leetcode : Yes
class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.slow
        """
        if not head:
            return head 
        slow = head
        fast = head
        
        while fast.next and fast.next.next :
            slow = slow.next
            fast = fast.next.next
            
        #node = ListNode()
        fast = self.reverse(slow.next)
        slow.next = None
        slow = head
        # merge two list
        while fast :
            curr = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = curr
            slow = curr
        return head 
    def reverse(self,node):
        if not node or not node.next:
            return node
        prev = None 
        fast = node.next 
        while fast:
            node.next = prev 
            prev = node 
            node = fast 
            fast = fast.next 
        node.next = prev 
        return node
            
        