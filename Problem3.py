#Did ir run on GeeksForGeeks? Yes
#Time Complexity:O(1)
#Space complexity:O(1) we do not use any extra space
#Approach: we have to basically set curr node to  next of the node. In this manner previous will actually be pointing to the next of the node and skip this one

def deleteNode(curr_node):
    #code here
    if curr_node is None or curr_node.next is None: #edge case
        curr_node = None
        return
    curr_node.data = curr_node.next.data
    curr_node.next = curr_node.next.next