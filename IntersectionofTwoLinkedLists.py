#Time Complexity : max(m,n) = O(m+n) since we iterate through the both the linked list. 
#Space Complexity : O(1) since we are not using any extra space
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this :No

#Approach: We calculate the length of both the linked list and find the difference (D) between the length. Then we take a pointer 
# D steps ahead in the linked list whose length is greater. Take another pointer for the other linkedlist at the head. Now we
# traverse through both the linked list simultaneously until both the pointer are equal (that is there is an intersection).
# If no intersection, both the pointer would meet at null in the end. 

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        lengthA = 0
        curr = headA
        while curr is not None:
            curr = curr.next
            lengthA += 1
        lengthB = 0 
        curr = headB
        while curr is not None:
            curr = curr.next
            lengthB += 1
        while lengthA > lengthB:
            headA = headA.next
            lengthA -= 1
        while lengthB > lengthA:
            headB = headB.next
            lengthB -= 1
        while headA != headB:
            headA = headA.next
            headB = headB.next

        return headA