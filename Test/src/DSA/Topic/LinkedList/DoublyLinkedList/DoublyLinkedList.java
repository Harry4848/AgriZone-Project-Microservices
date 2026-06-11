package DSA.Topic.LinkedList.DoublyLinkedList;

public class DoublyLinkedList {
    private Node head;
    private Node tail;

    public DoublyLinkedList(){
        head = null;
        tail = null;
    }

    // Insert At Beginning
    public void inserAtBeginning(int data){
        Node newNode = new Node(data);
        if (head==null){
            head = newNode;
            tail = newNode;
        }else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }
    // Insert At End
    public void insertAtEnd(int data){
        Node newNode = new Node(data);
        if(tail==null){
            head = newNode;
            tail = newNode;
        }else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }
    // Delete From Beginning
    public void deleteAtFront(){
        if (head==null){
            System.out.println("List is Empty");
            return;
        }
        if (head.next==null){
            head=tail=null;
        }else {
            head = head.next;
            head.prev = null;
        }
    }
    // Delete From End
    public void deleteAtEnd(){
        if (tail==null){
            System.out.println("List is Empty");
            return;
        }
        if (tail.prev==null){
            head=tail=null;
        }
    }
    // Display Backward
    public void displayBackward(){
        Node current = tail;
        while (current!=null){
            System.out.print(current.data+" , ");
            current = current.prev;
        }
        System.out.println();
    }
    // Display forward
    public void displayForward(){
        Node current = head;
        while (current!=null){
            System.out.print(current.data+" , ");
            current = current.next;
        }
        System.out.println();
    }
}
