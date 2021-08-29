public class MyStack {
    
    private int[] arr;
    private int size;
    private int maxSize;
    private int tos;

    public MyStack(int len){
        initialize(len);
    }

    //default: 5
    public MyStack()
    {
        initialize(5);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for(int i = this.tos; i >= 0; i--)
        {
            sb.append(this.arr[i] + " ");
        }
        return sb.toString();
    }

    protected void initialize(int len)
    {
        this.arr = new int[len];
        this.size = 0;
        this.tos = -1;
        this.maxSize = len;
    }

    public int maxsize()
    {
        return this.maxSize;
    }

    private void stackIsEmptyException() throws Exception
    {
        if(this.size == 0)
        {
            throw new Exception("isEmptyException: -1");
        }
    }

    private void stackIsOverFlowException() throws Exception{
        if(this.size == this.maxSize)
        {
            throw new Exception("isOverFlowException: -1");
        }
    }

    public boolean isEmpty()
    {
        return this.size == 0;
    }

    public int size()
    {
        return this.size;
    }

    private int pop_()
    {
        int rm = this.arr[this.tos];
        this.tos--;
        this.size--;
        return rm;
    }

    public int pop() throws Exception
    {
        stackIsEmptyException();
        return pop_();
    }

    private void push_(int data)
    {
        this.arr[++this.tos] = data;
        this.size++;
    }

    public void push(int data) throws Exception
    {
        stackIsOverFlowException();
        push_(data);
    }

    public int top() throws Exception
    {
        stackIsEmptyException();
        return this.arr[this.tos];
    }
}
