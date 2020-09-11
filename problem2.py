class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def reorderList(self, head):
        """
        Do not return anything, modify head in-place instead.
        """
        if not head or not head.next:
            return head
        
        slow = head
        fast = head
        dummy = ListNode(0)
        dummy.next = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            dummy = dummy.next
        
        dummy.next = None
        def helper(head, slow):
            if slow == None:
                return head  
            head = helper(head ,slow.next)
            slow.next = None
            # print(slow, head)
            slow.next = head.next
            head.next = slow
            # print(slow, head)
            if dummy.next:
                return head.next
            else:
                return head.next.next
        
        t = head
        helper(t, slow)
        return head
            