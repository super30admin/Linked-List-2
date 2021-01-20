# Created by Aashish Adhikari at 6:59 PM 1/19/2021

'''
Time Complexity:
O(1)

Space Complexity:
O(1)
'''

def deleteNode(curr_node):
    #code here

    curr_node.data = curr_node.next.data
    curr_node.next = curr_node.next.next
