/* time complexity O(1)
space complexity O(1)
*/

class GfG
{

    void deleteNode(Node node)

    {

         node.data=node.next.data;

         node.next=node.next.next;

    }

}
