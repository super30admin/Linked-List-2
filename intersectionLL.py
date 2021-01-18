# To find the intersection of LL, we can find the lengths of both Linked lists and bridge the gap for the longer LL
# Once the extra gap is bridged, we can start moving both LL pointers and when they are equal, return the either of the pointer
# Time : O(M + N)
# Space : O(1)



# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:

        
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

        return ptr1