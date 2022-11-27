# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

'''
Time complexity -->
O(n) for traversing the whole list

Space Complexity -->
O(1) no extra space
'''
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        middle = None
        slow = head
        if head.next == None:
            return head
        fast = head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        middle = slow
        if middle == head:
            return head
        curr = slow.next
        prev = None
        nextNode = curr.next
        while nextNode:
            curr.next = prev
            prev = curr
            curr = nextNode
            nextNode = nextNode.next
        
        curr.next = prev
        prev = curr
        middle.next = prev
        #return head
        
        
        
        curr1 = head
        curr2 = middle.next
        #nextNodefront = curr1.next
        #nextNodeback = curr2.next
        while curr1!=middle:
            nextNodefront = curr1.next
            nextNodeback = curr2.next
            curr1.next = curr2
            curr1 = nextNodefront
            curr2.next = curr1
            curr2 = nextNodeback
        curr1.next = nextNodeback
            
            
            
            
            
        return head
        
        
        
            
        