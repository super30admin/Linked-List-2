class Solution(object):
    def reorderList(self, head):
        """
        :type head: ListNode
        :rtype: None Do not return anything, modify head in-place instead.
        """
        def reverse(node):
            if (node is None):
                return node
            temp = ListNode(None)
            p1 = node
            p2 = node.next
            node.next = None
            while(p2 is not None):
                temp = p2.next
                p2.next = p1
                p1= p2
                p2 = temp
            return p1
        
        if head is None:
            return
        slow = head
        fast = head
        while(fast and fast.next):
            slow = slow.next
            fast = fast.next.next
        head2 = reverse(slow.next)
        slow.next = None
        while(head2!=None):
            p1 = head.next
            p2 = head2.next
            head.next = head2
            head2.next = p1
            head =p1
            head2=p2
            
