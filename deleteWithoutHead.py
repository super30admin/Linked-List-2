# Time Complexity: O(1)
# Space Complexity: O(1)
# Did it run on Leetcode: Yes


 #User function Template for python3
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
 class Solution:
     def deleteNode(self,curr_node):
         #code here
         if not curr_node:
             return
         temp = curr_node.next
         curr_node.data = curr_node.next.data
