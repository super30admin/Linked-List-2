# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

#All TC on leetcode passed

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:

        #Here we find the length of list A and B. Whichever is longer list we place a pointer at distance = cntA-cntB and second pointer at beginning of smaller list. Now we traverse both lists and check if they are equal at any point. If yes we return that element and exit.
        #Time complexity - O(m+n) where m and n are lengths of L.L A & B
        #Space complexity - O(1)
        countA = 0
        countB = 0
        curA = headA
        curB = headB

        while curA:
            curA = curA.next
            countA+=1
        
        while curB:
            curB = curB.next
            countB+=1
        
        diff = abs(countA-countB)
        curA = headA
        curB = headB

        if countA>countB:
            while diff>0:
                curA = curA.next
                diff -= 1
        else:
            while diff>0:
                curB = curB.next
                diff -= 1

        while curA and curB:
            if curA==curB:
                return curA
            curA = curA.next
            curB = curB.next

        return None




#-------------------------------OR--------------------------------------------------
#Here we add the nodes of L.L A into a set. Then we traverse L.L. B and check if any node of B is present in set. If yes we return it and exit 
        #Time complexity - O(m+n) where m and n are lengths of L.L A & B
        #Space complexity - O(m) - only L.L. A nodes added to set
        nodes = set()

        while headA:
            nodes.add(headA)
            headA = headA.next
        
        while headB:
            if headB in nodes:
                return headB
            headB = headB.next

        return None
        