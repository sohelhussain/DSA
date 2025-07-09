// time O(n)
public class Queue {
    private int[] data;
    private int rear;

    public Queue(int capacity) {
        data = new int[capacity];
        this.rear = -1;
    }

    public void offer(int val) {
        if(rear + 1 == data.length) {
            System.out.println("queue is full");
        } 

        data[++rear] = val;
    }

    public Integer poll() {
        if (rear == -1) {
            return null;
        }

        int ans = data[0];

        for(int i = 0; i < rear; i++){
            data[i] = data[i + 1];
        }
        rear--;

        return ans;
    }

    public Integer pick() {
        if (rear == -1) {
            return null;
        }

        return data[0];
    }
}






//cricular queue that O(1)

public class QArray {
    private int[] data;
    private int rear, front, size, capacity;

    public QArray(int capacity) {
        data = new int[capacity];
        front = rear = -1;
        size = 0;
        this.capacity = capacity;
    }

    public boolean isFull() {
        return size == capacity;
    }
    public boolean isEmpty() {
        return size == 0;
    }


    public void offer(int val) {
        if(isFull()) {
            System.out.println("queue is full");
            return;
        } 

        if (rear == -1) {
            front = 0;
        }
        rear = (rear + 1) % capacity;
        data[rear] = val;
        size++;
    }

    public Integer poll() {
        if (isEmpty()) {
            return null;
        }

        int ans = data[front];

        front = (front + 1) % capacity;
        size--;
        return ans;
    }

    public Integer peek() {
        if (isEmpty()) {
            return null;
        }

        return data[front];
    }
}

