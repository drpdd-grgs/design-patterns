package behavioral.mediator.mediator;

public class User {

    private final String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if ((o instanceof User u)) {
            return u.getName().equals(this.getName());
        } else {
            return false;
        }
    }

}
