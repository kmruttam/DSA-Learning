import java.util.Arrays;

public class Stack {
    private int[] stack = new int[10];
    private int index = 0;

    public int push(int item) {
        if(index == stack.length){
            throw new StackOverflowError();
        }
        stack[index++] = item;
        return index;
    }

    public int pop() {
        if(index == 0){
            throw new IllegalStateException();
        }
        return stack[--index];
    }

    public int peek() {
        if(index == 0){
            throw new IllegalStateException();
        }
        return stack[index - 1];
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public void print() {
        System.out.println(Arrays.toString(stack));
    }

    @Override
    public String toString(){
        var content = Arrays.copyOfRange(stack, 0, index);
        return Arrays.toString(content);
    }
}
