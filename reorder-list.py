'''
TC: O(n)
SC: O(1)
'''

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
            return head
        
        
        slow, fast = head, head
        
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
        
        
        def getReverse(node):
            if not node or not node.next:
                return node
            
            curr, prev = node.next, node
            prev.next = None
            
            while curr:
                temp = curr.next
                curr.next = prev
                prev = curr
                curr = temp
            
            return prev
            
        
        back = getReverse(slow.next)
        slow.next = None
        
        newprt = head
        sndprt = back
        
        while newprt.next and sndprt:
            temp = newprt.next
            temp2 = sndprt.next
            newprt.next = sndprt
            sndprt.next = temp
            newprt = temp 
            sndprt = temp2
        
        return head

        