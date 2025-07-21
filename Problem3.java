class Solution {
    void deleteNode(Node node) {
        if(node==null){
            return;
        }
        
        if(node.next==null){
            node=null;
            return;
        }
        
        node.data = node.next.data;
        node.next = node.next.next;
    }
}
