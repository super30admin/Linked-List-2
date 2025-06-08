# Time Complexity : O(n) we are going over the entire list only once where n is the number of elements in the longer list
# Space Complexity : O(n) where n is the number of nodes in headA because we are storing the entire list in a dictionary

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        list_dict = dict() # dictionary to store the elements of headA
        tempA = headA
        while tempA != None:
            if tempA not in list_dict:
                list_dict[tempA] = tempA.val
            tempA = tempA.next
        tempB = headB
        while tempB != None:
            if tempB in list_dict: # we check if that node is already visited by the first list by checking the dictionary
                return tempB # if the dictionary contains the node then that is the intersection
            tempB = tempB.next

        return None