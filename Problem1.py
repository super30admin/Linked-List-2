class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        node1 = headA
        node2 = headB
        
        m = 0
        n = 0
        
        while node1 != None:
            m += 1
            node1 = node1.next
            
        while node2 != None:
            n += 1
            node2 = node2.next
            
        if m<n:
            node1,node2 = node2,node1
            
        node1 = headA
        node2 = headB
            
        for i in range(abs(m-n)):
            node2 = node2.next
        
        while node1 != node2:
            node1 = node1.next
            node2 = node2.next
            
        return node1
    
