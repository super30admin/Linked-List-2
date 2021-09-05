# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverse(self, head):
            prev, nx = None, None
            curr = head
            
            while curr is not None:
                nx = curr.next
                curr.next = prev
                prev = curr
                curr = nx
            
            return prev

    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        """
        TC: O(n)
        SC: O(1)
        """
        # 1. Base case
        if head == None:
            return
        
        # 2. find the mid of the list
        slow, fast = head, head
        
        while fast != None and fast.next != None:
            slow = slow.next
            fast = fast.next.next
        
        # 3. split the list from the mid
        # and reverse the 2nd half of the list
        fast = self.reverse(slow.next)
        slow.next = None
        
        # 4. combine both list in the order asked in the problem
        slow = head
        
        while fast != None:
            nextS = slow.next
            nextF = fast.next
            slow.next = fast
            fast.next = nextS
            slow = nextS
            fast = nextF