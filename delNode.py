"""
TC: O(1)
SP: O(1)
"""

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
    # Function to delete a node in the middle of a singly linked list.
    def deleteNode(self, node):
        #code here
        if node and node.next:
            nxt = node.next
            node.data = nxt.data
            node.next = nxt.next


#{ 
 # Driver Code Starts
class Node:

    def __init__(self, x):
        self.data = x
        self.next = None


def findNode(head, search_for):
    current = head
    while current is not None:
        if current.data == search_for:
            return current
        current = current.next
    return None


def insert():
    global head
    arr = list(map(int, input().split()))
    n = len(arr)
    if n == 0:
        return

    head = Node(arr[0])
    temp = head
    for i in range(1, n):
        temp.next = Node(arr[i])
        temp = temp.next


def printList(node):
    while node is not None:
        print(node.data, end=' ')
        node = node.next
    print()


if __name__ == "__main__":
    t = int(input())
    for _ in range(t):
        head = None  # Reset the head for each test case
        insert()
        k = int(input())
        del_node = findNode(head, k)
        sol = Solution()
        if del_node is not None and del_node.next is not None:
            sol.deleteNode(del_node)
            printList(head)
        elif del_node is None:
            print("Node with value {} not found.".format(k))
        else:
            print("Input does not follow the custom input conditions.")

# } Driver Code Ends