package generic;

public class Car extends Product{
  String Code;
  public Car(String code,float price){
    Code = code;
    Price = price;
  }
  @Override
  String getKey(){
    return Code;
  }
}
