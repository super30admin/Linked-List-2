'''TC:O(N)
    SC: o(1)
'''
class Solution:

    def reorderList(self, head) -> None:
        if not head:
            return 
        
        slow = fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next 
            
        prev, curr = None, slow
        while curr:
            curr.next, prev, curr = prev, curr, curr.next       

        first, second = head, prev
        while second.next:
            first.next, first = second, first.next
            second.next, second = first, second.next