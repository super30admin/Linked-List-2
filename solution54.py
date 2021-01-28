#Time Complexity:O(n)
#Space Complexity:O(1)

def deleteNode(curr_node):
    while(curr_node.next):										#while next node is not null
        if curr_node.next.next is None:							#if next 2nd node is null
            curr_node.data=curr_node.next.data					#assign data of next node to current node 
            curr_node.next=None									#assign next node to null
            return												#return
        curr_node.data=curr_node.next.data						#assign next node value to current node
        curr_node=curr_node.next								#move node by one