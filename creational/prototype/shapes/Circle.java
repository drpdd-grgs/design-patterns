package creational.prototype.shapes;

public class Circle extends Shape {
    public int _radius;

    public Circle() {

    }

    private Circle(Circle target) {
        super(target);
        if (target != null) {
            _radius = target._radius;
        }
    }

    @Override
    public Shape clone() {
        return new Circle(this);
    }

    @Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof Circle) || !super.equals(object2)) {
            return false;
        }
        Circle shape2 = (Circle) object2;
        return shape2._radius == _radius;
    }
}
