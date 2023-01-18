# Time Complexity :
# O(N)

# Space Complexity :
# O(1)

# Did this code successfully run on Leetcode :
#Yes

#We find the length of each of the linked lists. Whichever is longer, is moved ahead by the distance of difference between the 2 linked list
#At this point, both the linked lists are equidistanct from the intersection point
#So we move both of them ahead parallely until they are equal and we return true if we find an intersection or false otherwise

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        #headA = self.reverse(headA)
        #headB = self.reverse(headB)
        temp_headA = headA 
        temp_headB = headB
        if headA == None or headB == None :
            return None
        
        count_1 = 0
        while temp_headA != None:
            temp_headA = temp_headA.next
            count_1 += 1

        count_2 = 0
        while (temp_headB != None):
            temp_headB = temp_headB.next
            count_2 += 1

        temp_headA = headA 
        temp_headB = headB
        if count_2 > count_1 :
            while (count_2 > count_1):
                temp_headB = temp_headB.next
                count_2 -= 1
        else :
            while (count_1 > count_2):
                temp_headA = temp_headA.next
                count_1 -= 1

        while (temp_headA != None and temp_headB != None):
            if temp_headA == temp_headB:
                return temp_headA
            else :
                temp_headA = temp_headA.next
                temp_headB = temp_headB.next

        return None

            


