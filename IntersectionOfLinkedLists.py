# Time Complexity :
# O(M+N), M = Lenght of LinkedList1, N= Lenght of LinkedList2

# Space Complexity :  
# O(1)  



# Approach:
# First iterate through both arrays to find the number of nodes in the LinkedList
# Then reset the pointers to their respective heads.
# Now, based on which LinkedList is larger, advance the pointer of that linked list untill the point
#  when both counts become equal, i.e no. of nodes of both linkedlists are equal at this point.
# Then, paralley iterate through the LL's and return the node, if both pointers are same, i.e point to same node.





# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        if not headA or not headB:
            return None

        # find lengths of each list
        countA = 0
        countB = 0

        listA = headA
        listB = headB

        while(listA):
            listA = listA.next
            countA = countA + 1
        
        while(listB):
            listB = listB.next
            countB = countB + 1
    
        #reset the pointers back to start of LL's
        listA = headA
        listB = headB

        # move the pointer of larger LL untill counts of nodes for both LL become equal
        while(countA > countB):
            listA = listA.next
            countA = countA-1
        
        while(countB > countA):
            listB = listB.next
            countB = countB-1

        #print("count of A and B resp: ", countA, " and ", countB)

        # Now iterate over LL's parallely and check if you find same node referred by "listA" and "listB" pointers
        while(listA and listB):
            if listA == listB:
                return listA
            else:
                listA = listA.next
                listB = listB.next
                
        return None