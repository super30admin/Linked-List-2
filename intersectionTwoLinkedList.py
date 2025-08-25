# Time Complexity : It is O(n) since we are iterating with all nodes.
# Space Complexity : It is O(1) since no extra space.
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        countNodesA =0
        countNodesB =0
        findInsterctA = headA
        findInsterctB = headB

        while findInsterctA != None:
            countNodesA+=1
            findInsterctA = findInsterctA.next
        
        while findInsterctB != None:
            countNodesB+=1
            findInsterctB = findInsterctB.next

        findInsterctA=headA
        findInsterctB=headB
    
        if countNodesA > countNodesB:
            for i in range(countNodesA-countNodesB):
                findInsterctA = findInsterctA.next
        
        if countNodesA < countNodesB:
            for i in range(countNodesB-countNodesA):
                findInsterctB = findInsterctB.next
        
        while findInsterctA!=findInsterctB:
            findInsterctA = findInsterctA.next
            findInsterctB = findInsterctB.next
        
        if findInsterctA==findInsterctB:
            return findInsterctA

        return None

