#Time Complexity:O(m+n)
#Space Complexity:O(n)

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if not head or not head.next:                   #when the linked list has zero or one node return
            return
        slow=fast=head                                  #assign two pointers slow and fast at the head
        while(fast.next and fast.next.next):            #while the next two node of fast pointer is not null
            slow=slow.next                              #move slow pointer by one
            fast=fast.next.next                         #move fast pointer by two
        fast=self.rev(slow.next)                        #reverse the second half of the LinkedList into new Linked list
        slow.next=None                                  #ending the fist half of linked list with null
        slow=head                                       #move slow pointer to the head of first half of linked list
        while(fast):                                    #when the fast pointer doesnt reach the end of reversed second half
            temp=slow.next                              #assign next node of slow pointer to temp
            slow.next=fast                              #link the current slow node to the current fast node
            fast=fast.next                              #move fast pointer by one
            slow.next.next=temp                         #assign the temp node to the slow.next.next node
            slow=temp                                   #move slow pointer to the temp node
        return head                                     #return the Linked list
    
    def rev(self,head:ListNode)->ListNode:              #reversing the seconf half of array
        prev=None                                       #assign prev to none
        curr=head                                       #assign current pointer to head of linked list
        fast=curr.next                                  #assign fast pointer to second node
        while(fast):                                    #while fast pointer is not null
            curr.next=prev                              #make the current node point to previous
            prev=curr                                   #make current node previous
            curr=fast                                   #make fast node as current node
            fast=fast.next                              #move fast pointer by one
        curr.next=prev                                  #assigning last node to link to its previous
        return curr                                     #returning reversed linked list