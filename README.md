# Linked-List-2

## Problem1 (https://leetcode.com/problems/binary-search-tree-iterator/)

In this approach during intialization we perform depth-first search to traverse the leftmost path of the tree and we push all the nodes along this path onto a stack. In the next element method we are just simply popping the top node from the stack and this node is the next smallest element in the BST. After popping we perform a DFS pn the right subtree of this node to ensure all nodes are correctly positioned into stack. In the hasnext method we simply check if the stack is not empty which indicates that there are elements left in BST.

## Problem2 (https://leetcode.com/problems/reorder-list/)

In this approach we will use slow and fast pointers. We will use slow and fast pointers to get the middle of the linked list. Slow pointer moves one step at a time and fast pointer moves two steps at a time. Once we find the middle we will reverse second half f the list starting from the node after middle node is found and then we will merge the first half and reversed second half in an alternating fashion.

## Problem3 (https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1)

In this approach we are deleting the node without any reference to the head pointer. First we will copy the data from the next node to the node to be deleted. Then to remove the next node we will simply adjust the next pointer of the current node to skip the next node which will delete it from the list.

## Problem4  (https://leetcode.com/problems/intersection-of-two-linked-lists/)

To find the intersection of two singly linked lists first we have calculated the lengths of both linked list and then we will just adjust the starting pointer of longer list so that both lists should have same number of nodes remaining. Once we adjust the pointer we will then simply traverse both lists simultaneously until a common node is found.