'''
Solution
1.  Find the mid of the LL using slow and fast pointers.
2.  Reverse the second part of the LL.
3.  Place one node from first half of LL and the other node from reversed second half of LL simultaneosly.

Time Complexity: O(n) and Space Complexity: O(1)

--- Passed all testcases on Leetcode successfully
'''

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class ReorderList(object):

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
        #   edge case check
        if (head == None or head.next == None or head.next.next == None):
            return head

        # initialize slow and fast pointers to find mid of the Linked List
        slowNode = head
        fastNode = head.next

        #   find the mid node iteratively
        while (fastNode != None and fastNode.next != None):
            slowNode = slowNode.next
            fastNode = fastNode.next.next

        #   reverse second half and initialize slow pointer to head again
        fastNode = self.__reverse(slowNode.next)
        slowNode.next = None
        slowNode = head

        #   Place one node from first half of LL and the other node from reversed second half of LL simultaneosly
        while (fastNode != None):
            tempNode = slowNode.next
            slowNode.next = fastNode
            slowNode = tempNode
            tempNode = fastNode.next
            fastNode.next = slowNode
            fastNode = tempNode

        return