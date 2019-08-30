/**
 * Segment class to hold segments
 * @author Volfegan [Daniel L Lacerda]
 * 
 */
public class Segment {
  Point a;
  Point b;

  Segment() {
    a = new Point();
    b = new Point();
  }
  Segment(int x0, int y0, int x1, int y1) {
    this.a = new Point(x0, y0);
    this.b = new Point(x1, y1);
  }
  Segment(Point a, Point b) {
    this.a = a;
    this.b = b;
  }

  public String toString() {
    String s = a.toString() + " " + b.toString();
    return s;
  }

  /*
   * calculates the intersection point
   * 
   * @param Segment s1
   * @return Point intersect
   */
  public Point intersect(Segment s1) {
    Point intersect = new Point();
    if (this == null || s1 == null) {
      return null;
    }
    //calculate the intersection point (x, y)
    intersect.x = ((s1.a.x * s1.b.y - s1.a.y * s1.b.x)
      * (this.a.x - this.b.x) - (s1.a.x - s1.b.x)
      * (this.a.x * this.b.y - this.a.y * this.b.x))
      / ((s1.a.x - s1.b.x) * (this.a.y - this.b.y) - (s1.a.y - s1.b.y)
      * (this.a.x - this.b.x));
    intersect.y = ((s1.a.x * s1.b.y - s1.a.y * s1.b.x)
      * (this.a.y - this.b.y) - (s1.a.y - s1.b.y)
      * (this.a.x * this.b.y - this.a.y * this.b.x))
      / ((s1.a.x - s1.b.x) * (this.a.y - this.b.y) - (s1.a.y - s1.b.y)
      * (this.a.x - this.b.x));

    if (outOfRange(intersect, s1) || outOfRange(intersect, this)
      || Double.isNaN(intersect.x) || Double.isNaN(intersect.x)) {
      intersect = null;
    }

    if (intersect != null) {
      //rounding to 2 decimal places
      intersect.x = Math.round(intersect.x * 100.0) / 100.0;
      intersect.y = Math.round(intersect.y * 100.0) / 100.0;
    }
    return intersect;
  }
  /**
   * checks if intersection point is within segment range.
   * @param Point i
   * @param Segment s
   * @return boolean
   */
  boolean outOfRange(Point i, Segment s) {
    if ((i.x < s.a.x && i.x < s.b.x) || (i.x > s.a.x && i.x > s.b.x)
      || (i.y < s.a.y && i.y < s.b.y) || (i.y > s.a.y && i.y > s.b.y)) {
      return true;
    } else
      return false;
  }
  
  public boolean equals(Object segment) {
    Segment s = (Segment) segment;
    if (this.a.equals(s.a) && this.b.equals(s.b))
      return true;
    else
      return false;
  }
}
