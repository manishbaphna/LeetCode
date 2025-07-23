import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import static java.util.List.of;

// https://leetcode.com/problems/rectangle-area/
public class OverlapRectangle {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {


        int rect1Area = (ax2 - ax1) * (ay2 - ay1);
        int rect2Area = (bx2 - bx1) * (by2 - by1);

        // Use this way1
        if ( bx1 >= ax2 || ax1 >= bx2 || by1 >= ay2 || ay1 >= by2)
            return rect1Area + rect2Area;

        int OLX = Math.max(ax1, bx1);
        int OLY = Math.max(by1, ay1);

        int ORX = Math.min(bx2, ax2);
        int ORY = Math.min(ay2, by2);

        // or way2
        if ( OLX >= ORX || OLY > ORY)
            return rect1Area + rect2Area;

        int commonArea = (ORX - OLX) * (ORY - OLY) ;
        return rect1Area + rect2Area - commonArea;
    }


    public static void main(String[] args) {
        List<Integer> l = new LinkedList<>();
        for (int i=0;i<10;++i)
            l.add(i);

        ListIterator<Integer> iter = l.listIterator();

        while (iter.hasNext()) {
            if ( iter.next() % 2 ==0)
                iter.remove();
        }
        l.forEach(System.out::println);

        // remove 3rd ewntry
        iter = l.listIterator(3);
        iter.next(); iter.remove();
        l.forEach(System.out::println);
    }

}
