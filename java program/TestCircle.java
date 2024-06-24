class Circle implements GeometricObject{
    protected double radius;
    public Circle(){
        this.radius=1.0;
    }
    public Circle(double radius){
        this.radius=radius;
    }
    public double getPerimeter(){
        return 2*Math.PI*radius;
    }
    public double getArea(){
        return Math.PI*radius*radius;
    }

}
interface GeometricObject {

  public double getPerimeter();
  public double getArea();
}
interface Resizable{
    public void resize(int percent);
}
class ResizableCircle extends Circle implements Resizable{
   public ResizableCircle(double radius){
    super(radius);
   }
   public void resize(int percent){
       System.out.println("Resizable circle percent is"+percent);
   }
}

public class TestCircle {
    public static void main(String[] args) {
        ResizableCircle r = new ResizableCircle(10);
        r.resize(10);
    }
}
