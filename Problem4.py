# Time complexity : O(m+n) --> total lenght of both lists
# Space complexity : O(1)
# Leetcode : Solved and submitted

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        curr = headA
        lenA = lenB = 0
        
        # we find the length of listA
        while curr is not None:
            lenA += 1
            curr = curr.next
        # finding the length of listB
        curr = headB
        while curr is not None:
            lenB += 1
            curr = curr.next
        
        # we move the pointer of headA which is the listA till we don't have an equal list size, if size of listA is bigger than listB
        while lenA > lenB:
            headA = headA.next
            lenA -= 1
        
        # we move the pointer of headB which is the listB till we don't have an equal list size, if size of listB is bigger than listA
        while lenA < lenB:
            headB = headB.next
            lenB -= 1
        
        # since we have equal length list, we can compare each node, if the node is same, then intersection is printed out, else we reach null
        # when no intersection is found
        while headA != headB:
            headA = headA.next
            headB = headB.next
            
        return headA
