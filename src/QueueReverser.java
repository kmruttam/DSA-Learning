import java.util.Queue;
import java.util.Stack;

public class QueueReverser {
    public Queue<Integer> reverse(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }
        while (!stack.empty()) {
            queue.add(stack.pop());
        }
        return queue;
    }
}
