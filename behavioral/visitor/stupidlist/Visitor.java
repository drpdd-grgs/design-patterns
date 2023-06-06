package behavioral.visitor.stupidlist;

public interface Visitor {

    void visitEmpty(StupidList stupidList);

    void visitSingle(StupidList stupidList);

    void visitMulti(StupidList stupidList);

}
