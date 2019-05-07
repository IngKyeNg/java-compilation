package bank;

public class Financial {
  private Financial(){}
  
  
  static public double FV(double pv, float rate, int terms) {
    for (int i = 0; i < terms; i++) {
      pv *= (1.0 + rate);
    }
    return pv;
  }

  static public double Pmt(double priciple, float rate, int terms) {
    return priciple
      * ((rate * Math.pow(1 + rate, terms)) / (Math.pow(1 + rate, terms) - 1));
  }
}
