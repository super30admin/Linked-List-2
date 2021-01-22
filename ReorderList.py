# TC: O(n)
# SC: O(1)
# 1. find the middle element
# 2. reverse second half
# 3. merge the lists
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def reorderList(self, head: ListNode) -> None:
        if head == None or head.next == None: return
        slow = fast = head
        # find middle
        while fast.next != None and fast.next.next != None:
            slow = slow.next
            fast = fast.next.next
        
        # reverse second half
        fast = self.reverse(slow.next)
        slow.next = None
        slow = head
        
        # merge
        while fast != None:
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp
        
    # reverse func
    def reverse(self, head):
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
        
            
        
        
        