# To find the intersection of LL, we can find the lengths of both Linked lists and bridge the gap for the longer LL
# Once the extra gap is bridged, we can start moving both LL pointers and when they are equal, return the either of the pointer
# Time : O(M + N)
# Space : O(1)

# Brute Force approaches
    # 1. For each node in LLA check if node exists in LLb - O(M * N) Time and O(1) space
    # 2. To scale down exponential time to linear time - use extar space
        # a. With hashset - do a one pass on one LL and add all nodes
        # b. then 2nd pass on LLb and check if nodes are in set - if yes return that node

        # O(M + N) Time and O(M) space

    # 3. To optimize space we use 2 pointer approach as below


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        
        if headA is None or headB is None:
            # either one is none there is no intersection
            return None

        ptr1 = headA
        ptr2 = headB
        len_A = 0
        len_B = 0

        # calculate lengths of 2 LL's

        while headA != None:
            headA = headA.next
            len_A += 1

        
        while headB != None:
            headB = headB.next
            len_B += 1


        # case 1 if LL A > LL B, bridge the gap

        while len_A > len_B:
            ptr1 = ptr1.next
            len_A -= 1

        # case 2 elif LL B > LL A, bridge the gap

        while len_B > len_A:
            ptr2 = ptr2.next
            len_B -= 1


        # now both LL's are same length

        while ptr1 != ptr2:
            ptr1 = ptr1.next
            ptr2 = ptr2.next

        # return either of ptr1 or ptr2 
        # we need not return None as we are tarversing LL from same length so if we never had an intersection ptr and ptr 2 will eventually point to None
        return ptr1