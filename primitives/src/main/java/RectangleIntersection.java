

public class RectangleIntersection {

    /*
     * 5.11 Write a program which tests if two rectangles have a nonempty intersection.
     * If the intersection is nonempty, return the rectangle formed by their intersection.
     *
     * Hint:Think of the X and Y dimensions independently.
    */

    public static Rectangle intersectRectangle(Rectangle r1, Rectangle r2) {
        Rectangle rectIntersection = null;

        // handle x axis
        if(hasIntersection(r1.x, r1.width, r2.x, r2.width)
                && hasIntersection(r1.y, r1.width, r2.y, r2.width)) {
            rectIntersection = new Rectangle(0, 0, 0, 0);
            rectIntersection.x = Math.max(r1.x, r2.x);
            rectIntersection.width = Math.min(r1.x + r1.width, r2.x + r2.width) - rectIntersection.x;

            // handle y axis
            rectIntersection.y = Math.max(r1.y, r2.y);
            rectIntersection.height = Math.min(r1.y + r1.height, r2.y + r2.height) - rectIntersection.y;
        }

        return rectIntersection;
    }

    // this goes by the assumption that r1 is supposed to the leftMost/bottomMost rectangle
    private static boolean hasIntersection(int a, int aLength, int b, int bLength) {
        return a <= b + bLength && b <= a + aLength;
    }

}
