#Time complexity is: O(n)
#Space complexity is: O(1) 
#Code ran successfully on leet code
#Faced no issues while coding this problem

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def reorderList(self, head):
        """
        :type head: ListNode
        :rtype: None Do not return anything, modify head in-place instead.
        """
        #If the list is empty or if the size of the list is 1, we will return the head directly
        if(head==None or head.next==None):
            return head
        #POinting the slow and fast pointer to the head
        slow=head
        fast=head
        #We will be moving slow by position and fast by two positions
        while(fast.next!=None and fast.next.next!=None):
            slow=slow.next
            fast=fast.next.next
        #We will be sending the list from slow.next to reverse function to reverse the list
        #The head of the reversed linked list will be stored in the fast pointer
        fast=self.reverse(slow.next)
        slow.next=None
        #Bringing back the slow pointer to the head again
        slow=head
        #merge the list
        #We will be merging both the lists
        while(fast!=None):
            temp=slow.next
            slow.next=fast
            fast=fast.next
            slow.next.next=temp
            slow=temp

    #function to reverse the linked list
    def reverse(self,head):
        #We will be initializing 3 pointers to reverse the linked list
        self.prev=None
        self.curr=head
        self.fast=head.next
        #We will be iterating theorugh the linked list
        while(self.fast!=None):
            self.curr.next=self.prev
            self.prev=self.curr
            self.curr=self.fast
            self.fast=self.fast.next
        self.curr.next=self.prev
        #Finally we will be returning the head of the reversed linked list
        return self.curr