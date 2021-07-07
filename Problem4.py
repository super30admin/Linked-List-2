# Time Complexity : O(n) 
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
class Node:
    def __init__(self,x):
        self.val = x 
        self.next = None 
        
class Solution:
    def getIntersectionNode(self, headA, headB):
        if not headA or not headB:
            return None 
        lenA, lenB = 0, 0 
        nodeA, nodeB = headA, headB 
        while nodeA:
            lenA += 1 
            nodeA = nodeA.next 
        
        while nodeB:
            lenB += 1
            nodeB = nodeB.next 

        nodeA, nodeB = headA, headB 

        while lenA > lenB:
            nodeA = nodeA.next 
            lenA -= 1 
        
        while lenB > lenA:
            nodeB = nodeB.next 
            lenB -= 1 
        
        while nodeA != nodeB:
            nodeA = nodeA.next 
            nodeB = nodeB.next 
        
        return nodeA

if __name__ == "__main__":
    s = Solution()
    n1 = Node(4)
    n1.next = Node(1)
    n1.next.next = Node(8)
    n2 = Node(5)
    n2.next = Node(0)
    n2.next.next = Node(1)
    n2.next.next.next = n1.next.next
    n1.next.next.next = Node(4)
    n1.next.next.next.next = Node(5)
    
    res = s.getIntersectionNode(n1,n2)
    print(res.val)