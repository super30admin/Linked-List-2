# Time: O(m+n) iterating on two different linked lists
# Space: O(m) we only add first linked list in the set

# Q => find the intersecting node of two linked lists if there is none return None

# Add the first linked list in a hashset (add nodes and not values as the values can be repeating)
# After that loop on the second linked list and check if that node is already present in the hashset if yes return that node
# If not return None
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        s = set()

        l1 = headA
        while l1 != None:
            s.add(l1)
            l1 = l1.next

        l2 = headB
        while l2 != None:
            if l2 in s:
                return l2
            l2 = l2.next
        
        return None
    
# Time:O(m + n)
# Space:O(1)

# First calculate the lengths of both of the linked lists
# As if there is an intersection the last part of the linked list will be same so we want to loop on both the linked list from a common node
# Hence we will manipulate the heads until the lengths of both of these linked lists are same
# After that we will keep on looping until headA = headB whenever they are equal that is the intersection point
# Even if there is no intersection in the two lists these nodes will be equal when they are None so None will be returned
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        lenA = 0
        lenB = 0
        # calculate the len of both of the linked lists
        n1 = headA
        while n1 != None:
            lenA += 1
            n1 = n1.next
        n2 = headB
        while n2 != None:
            lenB += 1
            n2 = n2.next

        if lenA > lenB:
            while lenA > lenB:
                lenA -= 1
                headA = headA.next
        if lenA < lenB:
            while lenA < lenB:
                lenB -= 1
                headB = headB.next

        while headA != headB:
            headA = headA.next
            headB = headB.next
        return headA