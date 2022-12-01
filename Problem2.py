# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

#Time complexity : O(N)
#Space complexity: O(1)

#Accepted on Leetcode 

#Approach:
#Divide the list into two halves using fast and slow pointers, reverse the second half and get head of the reversed list
#Separate the two halves by setting (last elem of first half).next = null
#Now keep joining the two halves until second half exhausts (note that second half will always be shorter than the first)

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if head == None or head.next == None:
            return head

        slow = head
        fast = head

        while fast != None and fast.next != None:
            slow = slow.next
            fast = fast.next.next

        headOne = head
        headTwo = slow.next
        slow.next = None

        headTwo = self.reverse(headTwo)

        #headTwo will always be the smaller LL
        while headTwo != None:
            temp = headOne.next
            headOne.next = headTwo

            headTwo = headTwo.next
            headOne.next.next = temp
            headOne = temp

        

    def reverse(self, head):
        if head == None or head.next == None:
            return head
        prev = None
        cur = head
        fast = head.next

        while fast != None:
            cur.next = prev
            prev = cur
            cur = fast
            fast = fast.next
        
        cur.next = prev

        return cur
    
