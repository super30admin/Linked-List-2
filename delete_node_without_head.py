"""
Name: Srinidhi Bhat 
Did it run on LC: Yes

Time Complexity: O(n) - traversal will take O(n)
Space Complexity: O(1) - reference to next pointer

Logic: 
We have reference to the node to be deleted, to delete we need prev pointer and current
To create this scenario, we can store next element in current element
and then link current to the next of the next node
delete 2 
1->2->3->4

1->3->3->4

final 1->3->4
"""

def deleteWithoutHead(node):
    if node is None:
        return
    
    else:
        #if last node is to be deleted, nothing needs to be done
        if node.next is None:
            node = None
            return 
        
        temp = node.next
        node.data = temp.data
        node.next = temp.next
