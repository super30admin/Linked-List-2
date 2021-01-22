# TC: O(m+n)
# SC: O(1)
# Find lengths of 2 lists. Start pointers from start(smaller list) and from start length diff(longer list). Now they are equidistant, traverse till they meet.  

class Solution:
    def getIntersectionNode(self, headA, headB):
        lenA, lenB = 0,0
        curr = headA
        # length of list A
        while curr != None:
            curr = curr.next
            lenA += 1   
        curr = headB
        # length of list B
        while curr != None:
            curr = curr.next
            lenB += 1
        # move height diff places from start for the longer list
        while lenB > lenA:
            headB = headB.next
            lenB -= 1
        while lenA > lenB:
            headA = headA.next
            lenA -= 1
        # traverse till intersection point
        while headA != headB:
            headA = headA.next
            headB = headB.next        
        return headA