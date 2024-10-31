import java.math.BigDecimal;

public class MyLinkedList<E> {
    public class Node<E extends Driver> {

        E driver;
        Node<E> next;
        Node<E> prev;

        //Constructors
        Node(){

        }
        Node(E d) {
            driver = d;
        }

        //Accessors
        public Node<E> getNext(){
            return next;
        }
        public Node<E> getPrev(){
            return prev;
        }
        public E getDriver(){
            return driver;
        }

        //Mutators
        public void setNext(Node<E> node){
            next = node;
        }
        public void setPrev(Node<E> node){
            prev = node;
        }
        public void setDriver(E d){
            driver = d;
        }

        public String myToString(){
            return driver.toString();
        }

    }

    Node<Driver> head = null;
    Node<Driver> tail = null;
    int size;

    //Constructors
    MyLinkedList(){

    }
    MyLinkedList(Node<Driver> node){
            head = node;
            tail = node;
            size++;
    }

    //Accessors
    public Node<Driver> getHead(){
        return head;
    }
    public Node<Driver> getTail(){
        return tail;
    }

    //Mutators
    public void addLast(Node<Driver> node){
        if(tail==null){
            head=tail=node;
        }
        else{
            getTail().setNext(node);
            tail.getNext().setPrev(tail);
            tail = tail.getNext();
        }
    }
    //Sets the head of the list
    public void setHead(Node<Driver> node){
        head = node;
    }
    //Adds a node into the first position
    public void addFirst(Driver driver){
        Node<Driver> newNode = new Node<>(driver);
        newNode.setNext(head);
        setHead(newNode);
        if(tail==null){
            tail = head;
        }
        head.setPrev(tail);
    }
    //Adds a node into the list
    public void add(Driver driver, int index){
        if(index == 0){
            addFirst(driver);
        }
        else if(index >= size){
            addLast(new Node<>(driver));
        }
        else{
            Node<Driver> traverse = head;
            for(int i = 0; i < index; i++){
                traverse= traverse.getNext();
            }
            Node<Driver> temp = traverse.getNext();
            traverse.setNext(new Node<>(driver));
            traverse.getNext().setPrev(traverse);
            traverse.getNext().setNext(temp);
        }
        size++;
    }

    //Prints the whole list
    public String toString(){
        String result = "";
        Node<Driver> current = head;
        result += current.myToString();
        for(int i = 0; i < size; i++){
            if(current.getNext() != null) {
                result += current.getNext().myToString();
                current = current.getNext();
            }
        }

        return result;
    }

    //Sorts the linked list
    public void sort(int type){
        Node<Driver> current = head;
        Node<Driver> index = null;

        Driver temp;
        if(head==null){
            return;
        }
        else{
            while(current != getTail().getNext()){
                index = current.getNext();

                while(index != getTail().getNext()){
                    if(current.getDriver().compareTo(index.getDriver(),type)){
                        temp = current.getDriver();
                        current.setDriver(index.getDriver());
                        index.setDriver(temp);
                    }
                    index = index.getNext();
                }
                current = current.getNext();
            }
        }

    }
    //Searches for the given name
    public String searchName(String name){
        Node<Driver> current = head;
        while(current != tail){
            if(current.getDriver().getName().compareTo(name) == 0){
                return current.myToString();
            }
            current = current.getNext();
        }
        return name + " not found\n\n";
    }
    //Searches for the given area
    public String searchArea(double area){
        Node<Driver> current = head;
        String convert = String.format("%.2f", area);
        area = Double.valueOf(convert);

        while(current != tail){
            if(current.getDriver().getArea() == area) {
                return current.myToString();
            }
            current = current.getNext();
        }
        return area + " not found\n\n";
    }
}
