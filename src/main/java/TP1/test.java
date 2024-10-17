package TP1;

public class test {
    public static void main(String[] args) {
        Book a = new Book("Harry Potter","JK.Rowling",10,1990 );
        Book b = new Book("Harry Potter","JK.Rowling",10,1990 );
        Book c = new Book("Harry Potter2","JK.Rowling",10,2000 );
        if (a.equal(b)){
            System.out.println("a and b are in equal");
            System.out.println(a.toString());
            System.out.println(b.toString());
            System.out.println(" but A is in reduction of 20%, it cost "+a.applyDiscount(20)+" instead of "+a.getPrice());
        }
        if (!b.equal(c)){
            System.out.println("b and b are not equal");
            System.out.println(b.toString());
            System.out.println(c.toString());
        }
        Book d = a.compareYear(c);
        System.out.println("The most recent book between a and c is "+d.toString());
    }
}
