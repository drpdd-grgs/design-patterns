package behavioral.visitor;

import behavioral.visitor.stupidlist.ShiftVisitor;
import behavioral.visitor.stupidlist.StupidList;

public class App {

    public static void main(String[] args) {
        StupidList<Integer> stupidList = new StupidList<>();
        stupidList.add(0);
        stupidList.add(1);
        stupidList.add(2);
        stupidList.add(3);
        stupidList.add(4);
        stupidList.add(5);
        ShiftVisitor shiftVisitor = new ShiftVisitor();
        stupidList.accept(shiftVisitor);
        System.out.println();
    }

}
