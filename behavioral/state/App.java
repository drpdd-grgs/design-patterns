package behavioral.state;

import behavioral.state.stupidlist.StupidList;

public class App {

    public static void main(String[] args) {
        StupidList<Integer> stupidList = new StupidList<>();
        stupidList.add(1);
        stupidList.add(2);
        stupidList.add(3);
        stupidList.remove();
        stupidList.remove();
        stupidList.remove();
        stupidList.remove();
        System.out.println();
    }

}
