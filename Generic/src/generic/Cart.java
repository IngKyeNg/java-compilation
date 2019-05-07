package generic;

import java.util.*;

public class Cart<T extends Product> {
  ArrayList<CartItem<T>> items = new ArrayList<>();
  public void Add(T product){
    for(CartItem item:items){
      if(item.product.getKey()==product.getKey()){
        item.Increase();
        return;
      }
    }
    items.add(new CartItem(product));
  }
  public void Add(T product,int quantity){
    for(CartItem item:items){
      if(item.product.getKey()==product.getKey()){
        item.Increase(quantity);
        return;
      }
    }
    items.add(new CartItem(product,quantity));
  }
  public void Remove(T product){
    for(CartItem item:items){
      if(item.product.getKey()==product.getKey()){
        item.Decrease();
        if(item.quantity==0) items.remove(item);
        return;
      }
    }
    throw new RuntimeException("Product with Key:"+product.getKey()+" not found");
  }
  public void Remove(T product,int quantity){
    for(CartItem item:items){
      if(item.product.getKey()==product.getKey()){
        if(item.quantity<quantity) throw new RuntimeException("Not enough to remove");
        item.Decrease(quantity);
        if(item.quantity==0) items.remove(item);
        return;
      }
    }
    throw new RuntimeException("Product with Key:"+product.getKey()+" not found");
  }
  public void Clear(){
    items.clear();
  }
  public float getTotal(){
    float total=0;
    for(CartItem item:items) total += item.getSubTotal();
    return total;
  }
  
  
  public T getProductByKey(String key){
      for(CartItem<T> cartItem:items){
        if(cartItem.product.getKey().equals(key)) return cartItem.product;
      }
      return null;
  }
}

