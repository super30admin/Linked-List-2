public class DeleteNode {
    public void deleteNode(ListNode node){
        //interchanging node values with neighbouring node
        int tmp = node.val;
        node.val = node.next.val;
        node.next.val = tmp;

        ListNode tmpNode = node.next;
        node.next = node.next.next;
        tmpNode.next = null;
    }
}