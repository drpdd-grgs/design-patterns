package creational.prototype.shapes;

public abstract class Shape {
    public int _x;
    public int _y;
    public String _color;

    public Shape() {

    }

    public Shape(Shape target) {
        if (target != null) {
            _x = target._x;
            _y = target._y;
            _color = target._color;
        }
    }

    public abstract Shape clone();

    @Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof Shape)) {
            return false;
        }
        Shape shape2 = (Shape) object2;
        return shape2._x == _x && shape2._y == _y && shape2._color.equals(_color);
    }
}
