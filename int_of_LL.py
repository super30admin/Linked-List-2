#time complexity: o(n) , actually 2n bec traverse 2 lists to find lenthgs and then traverse again to find intersection
#space complexity:o(1), only lens of lists are 
#passed all cases on LeetCode:
#difficulty faced:-
# comments: in the code
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: 'ListNode', headB: 'ListNode') -> 'Optional[ListNode]':

        if headA == None or headB == None: return None

        lena,lenb = 0,0
        curr = headA
        #find the len of 1st list
        while curr:
            lena += 1
            curr = curr.next

        curr = headB
        #find len of 2nd list
        while curr:
            lenb += 1
            curr = curr.next

        #if move the head pointer of A ahead if lena is gt lenb so we traverse and reach same point
        while lena > lenb:
            headA = headA.next
            lena -=1

        #like above if lenb is gt then move headb so that when we traverse later we reach same point
        while lenb > lena:
            headB = headB.next
            lenb -= 1

        #above 2 while loops should have made lens equal so we can do this
        #this also takes cares of condition when both lists dont intersect, we simply travel to last node and return null
        while headA != headB:
            headA = headA.next
            headB = headB.next

        return headA




