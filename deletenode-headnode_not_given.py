
#Geeksforgeeks accepted
#no doubt
#timecomplexity:

#explaiation:  say the node that will be deleted will be curr_node. You swap the value of curr_node of next to curr_node.
#then make the link from curr_node to curr_node.next's next




def deleteNode(curr_node):
    #code here
    curr_node.data=curr_node.next.data
    curr_node.next=curr_node.next.next