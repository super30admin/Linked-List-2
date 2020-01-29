#Problem1: Reorder List

# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

'''
Taking 2 pointers: fast and slow both set at head
Moving fast pointer twice the speed of slow to find the middle element
Reversing the list from slow.next
Once reversed merging the two list together
'''



# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reorderList(self, head):
        """
        :type head: ListNode
        :rtype: None Do not return anything, modify head in-place instead.
        """
        
        if head == None or head.next==None:
            return head
        
        fast = head
        slow = head

        # finding the middle node
        
        while(fast.next!= None and fast.next.next!= None):
            slow = slow.next
            fast = fast.next.next
            
        # reversing the link list from the middle element
        
        head1 = head
        head2 = slow.next
        slow.next = None
        
        prev = None
        curr = head2
        new = head2.next
        
        while(new!= None):
            curr.next = prev
            prev = curr
            curr = new
            new = new.next
            
        curr.next = prev
        
        #merging 2 linked list
        
        slow = head
        fast1 = curr
        temp = None
        
        while(slow!= None and fast1!= None):
            temp = slow.next
            slow.next = fast1
            fast1 = fast1.next
            slow.next.next = temp
            slow = temp

####################################################################################

# Problem2: Intersection of the two lists

# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

'''
Finding the length of both the lists
checking which linked list length is greater and making both the length equal by moving the head pointer of the longer list till the time lengths are equal
moving the head pointers of both the list together till the meet
return the head postion once they meet
'''

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        lenA = 0
        lenB = 0
    # finding len of list 1
        curr = headA
        while(curr!= None):
            curr = curr.next
            lenA+=1
    # finding len of list 2
        
        curr = headB
        while(curr!= None):
            curr = curr.next
            lenB+=1
    # moving the head poiter till the len of both the list are the same
        
        while(lenA> lenB):
            headA= headA.next
            lenA-=1
        
        while(lenB> lenA):
            headB = headB.next
            lenB-=1

    # Moing head pointer for both the list till both the pointers meet
        
        while(headA!=headB):
            headA= headA.next
            headB = headB.next
        
        return headA
        