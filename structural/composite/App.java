package structural.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        short n = scanner.nextShort();
        Pair<Integer, Integer>[] pairs = new Pair[n - 1];
        boolean[] opinions = new boolean[n];

        for (int i = 0; i < n - 1; i++) {
            pairs[i] = new Pair<>(scanner.nextInt(), scanner.nextInt());
        }

        for (int i = 0; i < n; i++) {
            int opinion = scanner.nextInt();
            opinions[i] = opinion == 1;
        }

        Tree tree = new Tree(n, pairs, opinions);
        int numberToResolve = tree.findNumberToResolveConflicts();
        System.out.println(numberToResolve < 0 ? "NO" : "YES\n" + numberToResolve);
    }

    static class Tree {
        private final List<Branch> root;
        private final List<Branch> allBranches;
        private final int branchCount;

        public Tree(int n, Pair<Integer, Integer>[] pairs, boolean[] opinions) {
            this.allBranches = new ArrayList<>();
            this.branchCount = n;
            for (int i = 0; i < n; i++) {
                this.allBranches.add(new Branch(i + 1, opinions[i]));
            }
            for (Pair<Integer, Integer> pair : pairs) {
                Branch rootBranch = findByNumber(pair.getFirst());
                Branch childBranch = findByNumber(pair.getSecond());
                rootBranch.addChild(childBranch);
                childBranch.addParent(rootBranch);
            }
            this.root = new ArrayList<>();
            this.root.add(findByNumber(1));
        }

        public Tree(List<Branch> root, List<Branch> allBranches, int branchCount) {
            this.root = root;
            this.allBranches = allBranches;
            this.branchCount = branchCount;
        }

        private Tree cloneTree() {
            List<Branch> copyRoot = new ArrayList<>(this.root);
            List<Branch> copyAllBranches = new ArrayList<>(this.allBranches);
            return new Tree(copyRoot, copyAllBranches, this.branchCount);
        }

        public int findNumberToResolveConflicts() {
            for (int i = branchCount; i > 0; i--) {
                Tree copy = this.cloneTree();
                copy.deleteBranchByNumber(i);
                if (!copy.isConflicted()) {
                    return i;
                }
            }
            return -1;
        }

        public void deleteBranchByNumber(int number) {
            Branch branch = findByNumber(number);
            deleteBranch(branch);
        }

        private Branch findByNumber(int number) {
            for (Branch branch : this.allBranches) {
                if (branch.number == number) {
                    return branch;
                }
            }
            return null;
        }

        public boolean isConflicted() {
            for (Branch branch : this.allBranches) {
                if (branch.getParentBranch() != null && branch.getOpinion() != branch.getParentBranch().getOpinion()) {
                    return true;
                }
            }
            return false;
        }

        private void deleteBranch(Branch branch) {
            if (branch.getChildList().size() > 0) {
                for (Branch childBranch : branch.getChildList()) {
                    childBranch.removeParent();
                    this.root.add(childBranch);
                }
            }
            if (branch.getParentBranch() != null) {
                branch.getParentBranch().removeChild(branch);
            } else {
                this.root.remove(branch);
            }
            this.allBranches.remove(branch);
        }
    }

    static class Branch {
        private final int number;
        private final boolean opinion;
        private final List<Branch> childList;

        private Branch parentBranch;

        public Branch(int number, boolean opinion) {
            this.number = number;
            this.opinion = opinion;
            this.childList = new ArrayList<>();
        }

        public List<Branch> getChildList() {
            return this.childList;
        }

        public Branch getParentBranch() {
            return this.parentBranch;
        }

        public boolean getOpinion() {
            return this.opinion;
        }

        public void addChild(Branch child) {
            this.childList.add(child);
        }

        public void addParent(Branch parent) {
            this.parentBranch = parent;
        }

        public void removeChild(Branch branchToRemove) {
            this.childList.remove(branchToRemove);
        }

        public void removeParent() {
            this.parentBranch = null;
        }
    }

    static class Pair<T, V> {
        private final T first;
        private final V second;

        public Pair(T first, V second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public V getSecond() {
            return second;
        }
    }
}
