# https://www.geeksforgeeks.org/problems/delete-without-head-pointer/1

# You are given a node del_node of a Singly Linked List where you have to delete this given node from the linked list but you are not 
# given the head of the list.

# After deleting the given node:

# The number of nodes in the linked list should decrease by one.
# All the values before & after the del_node node should be in the same order.
# Note: It is guaranteed that there exists a node with a value equal to the del_node value and it will not be the last node of the linked list.

# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Since we dont have the access to the previous node to the node to be deleted, we cannot deleted the node by changing the reference of the
# previous node. So we shift left values of nodes and delete the last node

'''
    Your task is to delete the given node from
	the linked list, without using head pointer.
	
	Function Arguments: node (given node to be deleted) 
	Return Type: None, just delete the given node from the linked list.

	{
		# Node Class
		class Node:
		    def __init__(self, data):   # data -> value stored in node
		        self.data = data
		        self.next = None
	}
'''

class ListNode:
    def __init__(self, data):   # data -> value stored in node
        self.data = data
        self.next = None


class Solution:
    def deleteNode(self, del_node):
        # code here
        # try to shift the values towards left and delete the last node
        curr = del_node
        prev = curr
        
        while(curr.next):
            curr.data = curr.next.data
            prev = curr
            curr = curr.next
            
        # prev would be at one node before last node
        prev.next = None
            
def printLinkedList(root):
    curr = root
    while(curr):
        print(curr.data, end=" -> ")
        curr = curr.next
    print()

node1 = ListNode(1)
node2 = ListNode(2)
node3 = ListNode(3)
node4 = ListNode(4)
node5 = ListNode(5)
head = node1
node1.next = node2
node2.next = node3
node3.next = node4
node4.next = node5

sol = Solution()
print("Before node delete")
printLinkedList(head)
sol.deleteNode(node1)
print("After node delete")
printLinkedList(head)

node6 = ListNode(6)
node7 = ListNode(7)
node6.next = node7
head = node6
print("Before node delete")
printLinkedList(head)
sol.deleteNode(node6)
print("After node delete")
printLinkedList(head)
