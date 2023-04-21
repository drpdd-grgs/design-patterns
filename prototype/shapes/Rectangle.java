package prototype.shapes;

public class Rectangle extends Shape {
    public int _height;
    public int _width;

    public Rectangle() {

    }

    private Rectangle(Rectangle target) {
        super(target);
        if (target != null) {
            _height = target._height;
            _width = target._width;
        }
    }

    @Override
    public Shape clone() {
        return new Rectangle(this);
    }

    @Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof Rectangle) || !super.equals(object2)) {
            return false;
        }
        Rectangle shape2 = (Rectangle) object2;
        return shape2._height == _height && shape2._width == _width;
    }
}
