import java.util.Scanner;

class Node{
    int data;
    Node left;
    Node right;

    public Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class LList{
     public Node createNode(Node head, int data){
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            newNode.left = head;
        }
        else{
            Node current = head;
            while(current.right != null){
                current = current.right;
            }
            current.right = newNode;
            newNode.left = current;
            
        }

        return head;
     }

     public Node traverseNode(Node head){
        if(head == null){
            System.out.println("Traversal not possible..");
        }
        else{
            int i=1;
            Node current = head;
            while(current != null){
                System.out.println("The data at node "+i+" is "+current.data);
                current = current.right;
                i++;
            }
        }
        return head;
    }

    public Node deleteNodeAtFront(Node head){
        if(head == null){
            System.out.print("The list is empty no node to delete.");
        }
        else{
            Node newHead = head.right;
            if(newHead != null){
                newHead.left = null;
            }
            head.right = null;
            head = newHead;

        }
        return head;
    }
}


/**
 * DoubleLL
 */
public class DoubleLL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        LList list = new LList();
        int choice;

        System.out.print("Enter the length of the linked list:");
        int length = sc.nextInt();

        //Entering the elements

        for(int i=0;i<length;i++){
            System.out.print("Enter the data of node "+(i+1)+" :");
            int data = sc.nextInt();
            head = list.createNode(head, data);
        }
        

        do{ 
            

            System.out.print("Enter your choice. \n1.Insertion\n2.Traversal\n3.Deletion\n4.Exit\n");
            choice = sc.nextInt();

            if(choice == 1){
                System.out.print("Enter the data of the node:");
                int data = sc.nextInt();

                head = list.createNode(head,data);
                System.out.println("The list after inserting the node at the back is...");
                head = list.traverseNode(head);
            }
            else if(choice == 2){
                System.out.println("The linked list is..");
                head = list.traverseNode(head);
            }
            else if(choice == 3){
                System.out.println("The list after deleting a node is..");
                head = list.deleteNodeAtFront(head);
                head = list.traverseNode(head);
            }

            
        }while(choice != 4);

    }
    
}