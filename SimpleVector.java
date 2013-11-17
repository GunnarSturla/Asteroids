public class SimpleVector {
  private Object[] a;
  private int size;
  // a[0],...,a[size-1] eru gildin í vektornum
  // size >= 0, a.length >= size

  // Notkun: x = new SimpleVector()
  // Fyrir:  ekkert
  // Eftir:  x er tómur vektor
  public SimpleVector() {
    this.size = 0;
    this.a = new Object[10];
  }

  // Notkun: x = v.size()
  // Fyrir:  ekkert
  // Eftir:  x er fjöldi staka í vektornum v
  public int size() {
    return this.size;
  }

    
  // Notkun: v.add(x)
  // Fyrir:  ekkert
  // Eftir:  x er bætt aftast við í v

  public void add(Object o) {
    if (size >= a.length) {
      int newLength = (int) Math.ceil(1.25*a.length);
      Object[] tmp = new Object[newLength];
      for (int i = 0; i < a.length; i++) {
        tmp[i] = a[i];
      }
      a = tmp;
    }
    a[size] = o;
    size++;
  }

  // Notkun: x = v.get(i)
  // Fyrir:  0 <= i < v.size()
  // Eftir:  x er stakið sem er í sæti i
  public Object get(int i) {
    if (i < 0 || i >= size) {
      throw new ArrayIndexOutOfBoundsException(i);
    }
    return a[i];
  }

  public static void main(String[] args) {
    int N = Integer.parseInt(args[0]);

    // Measure the time ...
  }

}