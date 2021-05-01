# -*- coding: utf-8 -*-
"""
Created on Fri Apr 30 23:09:08 2021

@author: jgdch
"""
#Time complexity:O(N)
#Space complexity:O(1)

class Solution:
    #Function to delete a node without any reference to head pointer.
    def deleteNode(self,curr_node):
        #code here
       prev=Node(None)
       if(curr_node==None):
           return
       elif( curr_node.next==None):
           curr_node.data=None
       else:
           while(curr_node.next!=None):
               curr_node.data=curr_node.next.data
               prev=curr_node
               curr_node=curr_node.next
           prev.next=None