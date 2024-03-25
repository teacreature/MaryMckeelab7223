public class CircularList{
  private Node head;
  private Node tail;

  private class Node {
    int data;
    Node next;
    Node previous;
    

    Node(int data) {
      this.data = data;
      this.next = null;
      this.previous = null;
      }
  }
    // adding method creates a new node that holds data, then it points to the head of the node, and then replaces the head with the new node
  private void addFirst(int data){
    Node newNode = new Node(data);
    if (head == null){
      head = newNode;
      head.next = newNode;
      head.previous = newNode;
        // empty list so value points to itself and is pointed at by itself
    }
    else{
        // updates newNode to point to the head position, and to point to the previos node that head WAS pointing to
      newNode.next = head;
      newNode.previous = head.previous;
        // updates heads pointer values so that the next pointer of the pointer that was before head and pointing to head to instead point to newNode and then assigning the previous pointer for the "head" value to the newNode
      head.previous.next = newNode;
      head.previous = newNode;
      head = newNode;     
    }
  }

    // add last creates new node with data value, then checks if there are are any values in the list, if not then the value becomes the head. if there are values in the list it searches the list until there are no next values and places the new node
  private void addLast(int data){
    
    Node newNode = new Node(data);
      if (head == null){
        head = newNode;
        head.next = head;
        head.previous = head;
      }
      else {
        // updates newNode to point to the head position, and to point to the previos node that head WAS pointing to
        newNode.next = head;
        newNode.previous = head.previous;
        // updates heads pointer values so that the next pointer of the pointer that was before head and pointing to head to instead point to newNode and then assigning the previous pointer for the "head" value to the newNode
        head.previous.next = newNode;
        head.previous = newNode;
      }
    
    }

  private void removeByValue(int data){
    Node current = head;
    Node last = null;

    while (current != null){
      if (current.data == data){
        if (last == null){
          head = current.next;
        }
        else {
          last.next = current.next;
        }
          return;
      }
        last = current;
        current = current.next;
    }
  }

    private static void displayList(CircularList list){
      Node current = list.head;
      System.out.println("Linked list: ");
      current = current.next;
      while (current != list.head){
        System.out.println("Node: " + current.data + " points to: " + current.next.data);
        current = current.next;
      }
      System.out.println("Node: " + current.data + " points to " + current.next.data);
      System.out.println();
    }

    private static boolean search(CircularList list, int key){
      boolean found = false;
      Node current = list.head;
      if (list.head == null){
        System.out.println("List is empty, no value found");
      }

      if (list.head.data == key){
        found = true;
      }
      else {
        current = current.next;
        while ((current.data != key) && (current != list.head)){
          current = current.next;
          found = false;
        }
        
        if (current == list.head){
          found = false;
        }
        else { 
          found = true;
        }
    }
      return found;
  }


    // Method for demonstration purposes
      public static void main(String[] args) {
          CircularList list = new CircularList();
          list.addFirst(1);
          list.addLast(2);
          list.addFirst(3);
          displayList(list);

          list.removeByValue(1);
          System.out.println(search(list, 2)); // value is in list
          System.out.println(search(list,7)); // value is not in list
          
          displayList(list);

      }

}