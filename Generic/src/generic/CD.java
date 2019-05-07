package generic;

public class CD extends Product{
  String Code;
  public CD(String code,float price){
    Code = code;
    Price = price;
  }
  @Override
  String getKey(){
    return Code;
  }
}
