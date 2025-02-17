
public class MyList {

    List head;
    int size;

    public MyList() {
        head = null;
        size = 0;
    }

    public void add(int data) {
        add(size, data);
    }

    public void add(int index, int data){
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("at index is out of bound" + index);
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        // index > 0

        List node = new List(data);
        List temp = head;
        index--;

        while (index-- > 0) {
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
        size++;
    }

    public int size(){
        return size;
    }

    public void addFirst(int data){
        List node = new List(data);
        node.next = head;
        head = node;
        size++;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        List temp = head;
        while (temp != null) {
            sb.append(temp.val);
            if (temp.next != null) {
                sb.append(", ");        
            }
            temp = temp.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public Integer removeFirst(){
        if (head == null) {
            return null;
        }

        int val = head.val;
        head = head.next;
        size--;
        return val;
    }

    public Integer removeLast() {
        return remove(size-1);
    }

    public Integer remove(int index){
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("at index is out of bound" + index);
        }
        if (index == 0) {
            return removeFirst();
        } 

        List temp = head;

        index--;

        while (index-- > 0) {
            temp = temp.next;
        }


        int val = temp.val;
        temp.next = temp.next.next;
        size--;
        return val;
    }
}
