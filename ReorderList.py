# // Time Complexity : O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach

## In this problem we have to compute 3 things, 1)divide the linkedlist and get the model 2) reverse the second linked list
## 3) merge the 2 lists. 

## we use a fast and slow pointer to the find the middle element.store the slow.next as second element and make slow.next = None
## we reverse the list and now for merging it we store the next of first and second and connect first to second and second to tmep1
## and then assign first and second to temp1 and temp2.

class solution:
    def reorder(self, head):

        slow = head
        fast = head
        ##find middle
        while fast!= None and fast.next!= None:
            fast = fast.next.next
            slow = slow.next
        
        prev = None
        curr = slow.next
        slow.next = None
        ##reverse the second list
        while curr:
            temp = curr.next
            curr.next = prev
            prev= curr
            curr = temp
        
        first = head
        second = prev
        ## merge
        while second:

            temp1 = first.next
            temp2 = second.next

            first.next = second
            second.next = temp1
            first = temp1
            second = temp2