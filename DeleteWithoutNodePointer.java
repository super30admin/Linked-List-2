public class DeleteWithoutNodePointer {
    public void delete() {
        // only 1 node or no nodes.
        if(del_node==null || del_node.next==null){
            return null;
        }
        // just move the value to the to be deleted node.
        // we are essentiall not deleting the node.
        // we are erasing the value and then shifting the pointer to the next value.
        del_node.val = del_node.next.val;
        del_node.next = del_node.next.next;
    }

    
}
