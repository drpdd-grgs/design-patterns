package behavioral.visitor.stupidlist;

public class ShiftVisitor implements Visitor {
    @Override
    public void visitEmpty(StupidList stupidList) {
        throw new IllegalStateException("List is empty");
    }

    @Override
    public void visitSingle(StupidList stupidList) {
        // do nothing
    }

    @Override
    public void visitMulti(StupidList stupidList) {
        Node tail = stupidList.tail;
        Node head = stupidList.head;
        stupidList.remove();
        stupidList.head = tail;
        stupidList.head.setNext(head);
        stupidList.tail.setNext(stupidList.head);
    }
}
