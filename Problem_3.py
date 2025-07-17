'''
Delete without head pointer
https://www.geeksforgeeks.org/problems/delete-without-head-pointer/1

You are given a node del_node of a Singly Linked List where you have to delete a value of the given node from the linked list but you are not given the head of the list.

By deleting the node value, we do not mean removing it from memory. We mean:
The value of the given node should not exist in the linked list.
The number of nodes in the linked list should decrease by one.
All the values before & after the del_node node should be in the same order.

Note:
Multiple nodes can have the same values as the del_node, but you must only remove the node whose pointer del_node is given to you.
It is guaranteed that there exists a node with a value equal to the del_node value and it will NOT be the last node of the linked list.

Examples:
Input: Linked List = 1 -> 2, del_node = 1
Output: 2
Explanation: After deleting 1 from the linked list, we have remaining nodes as 2.

Input: Linked List = 10 -> 20 -> 4 -> 30, del_node = 20
Output: 10->4->30
Explanation: After deleting 20 from the linked list, we have remaining nodes as 10, 4, 30.

Constraints:
2 <= number of nodes <= 10^6
1 <= node->data <= 10^6

Solution:
1. Copy the value from the node AFTER the delete-node to the delete-node
i.e, if the list is: delelte-node (val = 1) -> next node (val = 2)
then follwing the copy, we have:
delelte-node (val = 2) -> next node (val = 2)

Now, point the delete-node to the node after the next node thereby converting the list from delelte-node -> next -> after next to delete-node -> after next. Essentially, we are not deleting the delete-node but deleting the node after the delete-node.
https://youtu.be/6laukTeU1WY?t=4799

Time: O(1), Space: O(1)
'''
from linked_list import *

def get_node(head, target_val):
    if not head:
        return None
    node = head
    while node:
        if node.val == target_val:
            return node
        node = node.next
    return None

def delete_node_without_head_pointer(del_node):
    if del_node:
        del_node.val = del_node.next.val
        del_node.next = del_node.next.next


def run_delete_node_without_head_pointer():
    tests = [([1,2,3,4,5,6,7], 3, [1,2,4,5,6,7]),
              ([10,20,4,30],20,[10,4,30]),
              ([1,2],1,[2]),
              ([1,2,3], 2, [1,3]),
    ]
    for test in tests:
        head, target_val, ans = test[0], test[1], test[2]
        sll = build_linked_list(head)
        del_node = get_node(sll, target_val)
        print(f"\nSLL = {sll.to_array()}")
        delete_node_without_head_pointer(del_node)
        print(f"After deleting {target_val}, SLL = {sll.to_array()}")
        print(f"Pass: {ans == sll.to_array()}")

run_delete_node_without_head_pointer()