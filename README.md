# Linked-List-2

## Problem1 (https://leetcode.com/problems/binary-search-tree-iterator/)



## Problem2 (https://leetcode.com/problems/reorder-list/)

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def __reverse(self, head):
        '''
        :param head: head of the Linked list
        :return: reversed Linked List
        '''
        prevNode = None
        currNode = head
        nextNode = head.next

        while (nextNode != None):
            currNode.next = prevNode
            prevNode = currNode
            currNode = nextNode
            nextNode = nextNode.next

        currNode.next = prevNode
        return currNode

    def reorderList(self, head):
        """
        :type head: ListNode
        :rtype: None Do not return anything, modify head in-place instead.
        """
        if (head == None or head.next == None or head.next.next == None):
            return head

        slowNode = head
        fastNode = head.next

        while (fastNode != None and fastNode.next != None):
            slowNode = slowNode.next
            fastNode = fastNode.next.next

        fastNode = self.__reverse(slowNode.next)
        slowNode.next = None
        slowNode = head


        while (fastNode != None):
            tempNode = slowNode.next
            slowNode.next = fastNode
            slowNode = tempNode
            tempNode = fastNode.next
            fastNode.next = slowNode
            fastNode = tempNode

        return 


        
        

## Problem3 (https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1)



## Problem4  (https://leetcode.com/problems/intersection-of-two-linked-lists/)

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        l1,l2 = headA,headB
        count1,count2 =0,0
        while(l1 != None):
            l1 = l1.next
            count1 += 1
        while (l2 != None):
            l2 = l2.next
            count2 += 1
        l1,l2 = headA,headB
        while(count2>count1):
            l2 = l2.next
            count2 -= 1
        while(count1>count2):
            l1 = l1.next
            count1 -=1
        while l1 and l2:
            if l1 == l2:
                return l1
            l1 = l1.next
            l2 = l2.next
        return None



        
