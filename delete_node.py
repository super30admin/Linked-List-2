# Time Complexity : O(n) : n- no.of elements
# Space Complexity: O(1)
# Approach : In the absense of head pointer, use next pointer to delete the node.


def deleteNode(curr):

    if not curr or not curr.next:
        return None
    
    curr.val = curr.next.val
    curr.next = curr.next.next 
    
    return