public class DoublyLinkedList {
private Node head;


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
    newNode.next = head;
    head = newNode;
    newNode.previous = null;

  }

  
  // add last creates new node with data value, then checks if there are are any values in the list, if not then the value becomes the head. if there are values in the list it searches the list until there are no next values and places the new node
  private void addLast(int data){
    Node newNode = new Node(data);
    if (head == null){
      head = newNode;
      newNode.previous = null;
    }
    else {
      Node current = head;
      while (current.next != null){
        current = current.next;
      }
      newNode.previous = current;
      current.next = newNode;
    }
  }

  // searches list for key value, if found removes value and updates pointers
  private void removeByValue(int key){
    Node current = head;
    Node last = null;

    while (current != null){
      if (current.data == key){
        if (last == null){
          head = current.next;
        }
        else {
          last.next = current.next;
        }
        return;
      }
      current = current.next;
    }
  }


  // checks if any values are in list
  private static boolean isEmpty(DoublyLinkedList list){
    boolean isEmpty = false;
    if (list.head == null){
      isEmpty = true;
    }
    return isEmpty;
  }

  // dsiplays values held in list
  private static void displayList(DoublyLinkedList list){
    Node current = list.head;
    System.out.println("Linked list: ");
    while (current != null){
      System.out.println(current.data);
      current = current.next;
    }
  }

  
  // uses length variable as a counter as it iterates through the list
  private static int getLength(DoublyLinkedList list){
    if (list.head == null){
      System.out.println("List is empty");
    }

    int length = 1;
    Node current = list.head;
    while (current.next != null){
      length++;
      current = current.next;
    }
    return length;
  }


  // Method for demonstration purposes
  public static void main(String[] args) {
    DoublyLinkedList list = new DoublyLinkedList();
      System.out.println("Is list empty: " + isEmpty(list));
      list.addFirst(1);
      displayList(list);
      list.addLast(2);
      displayList(list);
      list.addFirst(0);
      displayList(list);
      System.out.println("Is list empty: " + isEmpty(list));
      System.out.println("length of list: " + getLength(list));

      list.removeByValue(1);
        // Add more demonstration code as needed
      displayList(list);
      System.out.println("length of list: " + getLength(list));

    }

}