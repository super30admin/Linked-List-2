#Remove current node with out head, The below approach is not a good way but we dont have access to head
def removeNode(node):
  node.val=node.next.val
  node.next=node.next.next
  #we will copy next node value to current node and just next node
  
