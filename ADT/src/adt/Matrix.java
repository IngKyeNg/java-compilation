package adt;

public class Matrix {
  private final double[][] cells;  
  public Matrix(int nRows,int nCols,double... items){
    assert(nRows>0):"# of rows must be >0";
    assert(nCols>0):"# of columns must be >0";
    assert((nRows*nCols)==items.length):"Invalid # of arguments";
    cells = new double[nRows][nCols];
    for(int i=0;i<items.length;i++) cells[i/nCols][i%nCols] = items[i];
  }
  private Matrix(double[][] items){
    cells = items;
  }
  public int getNRows(){
    return cells.length;
  }
  public int getNCols(){
    return cells[0].length;
  }
  public Matrix Multiply(Matrix rhs) throws Exception{
    Matrix lhs=this;
    if(lhs.getNCols()!=rhs.getNRows()) throw new Exception("Cannot multiply-lah!");
    double[][] m = new double[lhs.getNRows()][rhs.getNCols()];

    for(int r=0;r<lhs.getNRows();r++){
      for(int c=0;c<rhs.getNCols();c++){
        for(int i=0;i<lhs.getNCols();i++) 
          m[r][c] += lhs.cells[r][i]*rhs.cells[i][c];
      }
    }
    return new Matrix(m);
  }
  public Matrix Add(Matrix rhs) throws Exception{
    Matrix lhs=this;
    if(lhs.getNRows()!=rhs.getNRows()) throw new Exception("Cannot Add due to different # of Rows!");
    if(lhs.getNCols()!=rhs.getNCols()) throw new Exception("Cannot Add due to different # of Columns!");
    double[][] m = new double[lhs.getNRows()][lhs.getNCols()];

    for(int r=0;r<lhs.getNRows();r++){
      for(int c=0;c<lhs.getNCols();c++){
        m[r][c] = lhs.cells[r][c] + rhs.cells[r][c];
      }
    }
    return new Matrix(m);
  }
  public Matrix Transpose() throws Exception{
    double[][] m = new double[getNCols()][getNRows()];

    for(int r=0;r<getNCols();r++){
      for(int c=0;c<getNRows();c++){
        m[r][c] = cells[c][r];
      }
    }
    return new Matrix(m);
  }
  public void Show(){
    for(int r=0;r<getNRows();r++){
      for(int c=0;c<getNCols();c++) System.out.print("\t"+cells[r][c]);
      System.out.println();
    }
    System.out.println();
  }  
}
