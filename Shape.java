public abstract class Shape {
    
    public abstract Point2D getCenter();

    // Notkun: r = s.getBoundingBox()
    // Fyrir:  ekkert
    // Eftir:  r er minnsti ferhyrningur sem passar utan um s
    public abstract Rectangle getBoundingBox();

    // Notkun: c = s.intersects(o)
    // Fyrir:  ekkert
    // Eftir:  c er true of s og o skarast
    public abstract boolean intersects(Shape o);

    // Notkun: s.scale(f)
    // Fyrir:  f > 0
    // Eftir:  s er f-sinnum stÃ¦rra og miÃ°jan er Ã³breytt
    public abstract void scale(double f);
}