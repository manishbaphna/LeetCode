import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CountShips {
    static class Point {
        int x;
        int y;

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point point)) return false;
            return getX() == point.getX() && getY() == point.getY();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getX(), getY());
        }
    };
    List<Point> ships = new ArrayList<>();

    CountShips(){
        ships.add(new Point(4,8));
        ships.add(new Point(7,7));
    }

    boolean hasShips(Point bottomLeft, Point topRight) {
        // implement
        for ( var ship : ships) {
            if ( ship.getX() >= bottomLeft.getX() &&
                 ship.getX() <= topRight.getX() &&
                 ship.getY() >= bottomLeft.getY() &&
                 ship.getY() <= topRight.getY()) {
                return true;
            }
        }

        return false;
    }

    int countShips(Point bottomLeft, Point topRight) {
        int countShips = 0;

        //System.out.println("Trying " + bottomLeft.toString() + " vs " + topRight.toString());

        if (bottomLeft.equals(topRight)) {
            countShips = hasShips(bottomLeft, topRight) ? 1 : 0;
            return countShips;
        }


        if (hasShips(bottomLeft, topRight)) {

            Point midPoint = new Point((bottomLeft.getX() + topRight.getX()) / 2, (bottomLeft.getY() + topRight.getY()) / 2);

            // Bottom left
            countShips += countShips( bottomLeft, midPoint);
            // top right
            countShips += countShips(new Point(midPoint.getX() + 1, midPoint.getY() + 1), topRight);

            // bottom right
            countShips += countShips(new Point(midPoint.getX() + 1, bottomLeft.getY()), new Point(topRight.getX(), midPoint.getY()));

            // top left
            countShips += countShips(new Point(bottomLeft.getX(), midPoint.getY() + 1), new Point(midPoint.getX(), topRight.getY()));

        }

        return countShips;
    }

    public static void main(String[] args) {
        CountShips dut = new CountShips();
        CountShips.Point BL = new CountShips.Point(4,8);
        CountShips.Point TR = new CountShips.Point(5,9);


        int count = dut.countShips(BL, TR);
        System.out.println(count);

    }
}
