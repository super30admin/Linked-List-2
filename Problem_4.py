# // Time Complexity : O(m+n)
# // Space Complexity : O(1)

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        
        counter1 = 0
        counter2 = 0
        node1 = headA
        node2 = headB
        while(node1.next is not None):
            counter1+=1
            node1 = node1.next

        while(node2.next is not None):
            counter2+=1
            node2 = node2.next     

        flag = 1

        if(counter1>=counter2):
            flag = 0
        diff = abs(counter1 - counter2)

        node1 = headA
        node2 = headB
        
        for i in range(diff):
            if(flag==0):
                node1 = node1.next
            else:
                node2 = node2.next
        
                
        while(node1 and node2):
            
            if(node1 == node2):
                return node1
            node1 = node1.next
            node2 = node2.next

        return None