package generic;

public class Book extends Product{
  String ISBN;
  String Title;
  public Book(String isbn,String title,float price){
    ISBN = isbn;
    Title = title;
    Price = price;
  }
  @Override
  String getKey(){
    return ISBN;
  }
}
