# Time Complexity : O(N) WHERE N is number of Nodes
#SpaceComplexity : O(1)

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):  
    
    def reorderList(self, head):
        """
        :type head: ListNode
        :rtype: None Do not return anything, modify head in-place instead.
        """
        def reverse(head):
            prev = None
            curr = head
            fast =head.next
            while(fast!=None):
                curr.next =prev
                prev =curr
                curr =fast
                fast =fast.next
            curr.next =prev
            return curr
        
        if head==None or head.next==None:
            return head

        slow = head
        fast =head
        
        while(fast.next!=None and fast.next.next!=None):
            slow = slow.next
            fast = fast.next.next
        
        
        fast = reverse(slow.next)
        slow.next = None
        slow = head
        
        curr = None
        while(fast!=None):
            curr = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next =curr
            slow =curr