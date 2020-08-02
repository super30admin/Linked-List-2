#Time complexity: O(n)
#Space complexity: O(1)
# Works on leetcode: yes
#Approach: First we find the difference of the lengths of both linked lists and move the head of the longer list to equivalent
#of shorter list. Then we move pointers of both lists untill we find the same node. 
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        if not headA or not headB:
            return None
        l1, l2, a1, a2 = headA, headB, 0,0
        while l1:
            l1 = l1.next
            a1+=1
        while l2:
            l2=l2.next
            a2+=1
        diff  =a1-a2
        if diff>0:
            while diff>0:
                headA = headA.next
                diff-=1
        else:
            while diff<0:
                headB = headB.next
                diff+=1
        while headA:
            if headA==headB:
                return headA
            else:
                headA = headA.next
                headB = headB.next
        return None