# Submitted by : Aryan Singh_RN12MAY2023
# Time Complexity : O(M+N) for all
# Space Complexity : Average : O(M+N), O(1), O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# 1. hashset solution:

class Solution:
    '''
    - iterate any of two list and store the nodes in hashSet
    - while iterating the second list, check if the node already present in set
    '''
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        hashset = set()
        node = headA
        while node:
            hashset.add(node)
            node = node.next
        node = headB
        while node:
            if node in hashset:
                return node
            node = node.next
        return None


# 2. matching node solution using two pointers:

class Solution:
    '''
    - use two pointers, with an idea that common nodes can start with shorter node
    - so first pointer starts with shorter node, while second pointer starts
    - after the extra length difference compared to shorter list. Then match nodes of both pointers.
    '''
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        node = headA
        lengthA = 0
        lengthB = 0
        while node:
            lengthA += 1
            node = node.next
        node = headB
        while node:
            lengthB += 1
            node = node.next
        if lengthA >= lengthB:
            diff = lengthA - lengthB
            node = headA
            nodeB = headB
            while node:
                if diff > 0:
                    diff -= 1
                    node = node.next
                else:
                    if node == nodeB:
                        return node
                    node = node.next
                    nodeB = nodeB.next
        else:
            diff = lengthB - lengthA
            nodeA = headA
            nodeB = headB
            while nodeB:
                if diff > 0:
                    diff -= 1
                    nodeB = nodeB.next
                else:
                    if nodeA == nodeB:
                        return nodeA
                    nodeA = nodeA.next
                    nodeB = nodeB.next
        return None
    

# 3. a + c + b = b + c + a

class Solution:
    '''
    - Extension of previous solution
    - considering c is the common list, a and b being uncommon from each list
    - a + c + b = b + c + a | so both will collide at common node
    '''
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        pA = headA
        pB = headB
        while(pA != pB):
            if pA == None:
                pA = headB
            else:
                pA = pA.next
            if pB == None:
                pB = headA
            else:
                pB = pB.next
        
        return pA
        