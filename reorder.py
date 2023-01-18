# Time Complexity :
# O(N)

# Space Complexity :
# O(1)

# Did this code successfully run on Leetcode :
#Yes

#Problem split into 3 processes - first, we find the middle element. Then from the middle element onwards we reverse the linked list
#Then we merge the first half of non-reversed and second half of reversed linked list alternatively

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if head == None :
            return

        slow = head
        fast = head

        #Finding the middle element
        while (fast.next != None and fast.next.next != None):
            fast = fast.next.next
            slow = slow.next

        #Reversing the second half of the linked list
        end_ptr = self.reverse(slow.next)
        #ensuring end of the first half is pointing to null
        slow.next = None
        slow = head
        self.merge(slow,end_ptr)

    #Linked list reverse function
    def reverse(self,head):
        if head == None:
            return 

        prev = None
        curr = head
        fast = head.next

        while (fast != None ):
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next

        curr.next = prev
        return curr

    #Merge function - takes 2 linked lists and merges them alternatively 
    def merge(self,head,reversed_middle):
        while reversed_middle != None :
            temp = head.next
            head.next = reversed_middle
            reversed_middle = reversed_middle.next
            head.next.next = temp
            head = temp
