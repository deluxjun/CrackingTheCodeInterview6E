package chapter3;

import java.util.ArrayList;
import java.util.List;

public class SetOfStacks<T> {
  int MAX_SIZE = 5;
  Stack<Stack<T>> stacks = new Stack<Stack<T>>();

  public void push(T data) {
    Stack<T> currentStack = stacks.peek();

    if (currentStack == null || (currentStack != null && currentStack.getSize() >= MAX_SIZE)) {
      currentStack = new Stack<T>();
      stacks.push(currentStack);
    }

    currentStack.push(data);
  }

  public T pop() {
    Stack<T> currentStack = null;

    while (true) {
      currentStack = stacks.peek();
      if (currentStack == null) {
        return null;
      }
      if (currentStack.isEmpty()) {
        stacks.pop();
      } else {
        break;
      }
    }
    return currentStack.pop();
  }

  public int getCountOfSet() {
    return stacks.getSize();
  }

  // public T popAt(int index) {
  // for (int i = 0; i < index; i++) {

  // }
  // }

  public static void main(String[] args) {
    SetOfStacks<Integer> stack = new SetOfStacks<Integer>();
    stack.push(3);
    stack.push(4);
    stack.push(5);
    stack.push(6);
    stack.push(7);
    stack.push(8);

    System.out.println(stack.getCountOfSet());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.getCountOfSet());

  }
}
