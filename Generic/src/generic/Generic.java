package generic;

public class Generic {
  public static void main(String[] args) {
    Cart<Book> cart = new Cart<>();
    Book[] books={
      new Book("1111","Java is Fun",123),
      new Book("2222","How to earn million in a week",999),
      new Book("3333","Java for C3 Programmer",231),
    };

    cart.Add(books[1]);
    cart.Add(books[0],10);
    cart.Add(books[2],5);
    cart.Remove(books[1]);
    cart.Remove(books[2]);
    cart.Remove(books[0],5);
    System.out.printf("Total cost for books is $%.2f%n",cart.getTotal());
    
    Book b = cart.getProductByKey("3333");
    
    Cart<CD> cart2 = new Cart<>();
    
    Cart<Car> cart3 = new Cart<>();
    Car[] Car={
      new Car("1000",25_000),
      new Car("2000",50_000),
      new Car("3000",70_000),
    };
    
    cart3.Add(Car[1]);
    cart3.Add(Car[0],10);
    cart3.Add(Car[2],5);
    cart3.Remove(Car[1]);
    cart3.Remove(Car[2]);
    cart3.Remove(Car[0],5);
    
    System.out.printf("Total cost for cars is $%.2f%n",cart3.getTotal());
    
    Cart<Product> cart4 = new Cart<>();
    cart4.Add(new CD("1110",45.5F));
    cart4.Add(new Book("9999","Beautiful Java",145.3F));
    cart4.Add(Car[2],5);
    
    System.out.printf("Total cost for cars is $%.2f%n",cart4.getTotal());
    
    Book b2 = (Book)cart4.getProductByKey("9999");
    Product p = cart4.getProductByKey("9999");
  }
}
