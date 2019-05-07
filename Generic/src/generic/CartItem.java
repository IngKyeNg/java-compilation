package generic;

public class CartItem<T extends Product> {
  T product;
  int quantity;
  public CartItem(T product){
    this(product,1);
  }
  public CartItem(T product,int quantity){
    this.product = product;
    this.quantity = quantity;
  }
  public float getSubTotal(){
    return product.Price*quantity;
  }
  public void Increase(){
    quantity++;
  }
  public void Increase(int n){
    quantity+=n;
  }
  public void Decrease(){
    quantity--;
  }
  public void Decrease(int n){
    quantity-=n;
  }
}
