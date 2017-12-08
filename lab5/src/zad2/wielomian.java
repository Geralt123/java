package zad2;

public class wielomian {
    double x1, x2, x3, x4, x5, c;
    public final void setParameters(double x5, double x4, double x3, double x2, double x1, double c){
        this.x1=x1;
        this.x2=x2;
        this.x3=x3;
        this.x4=x4;
        this.x5=x5;
        this.c=c;
    }
    public double getY (double x){
        return c+x*x1+x*x*x2+x*x*x*x3+x*x*x*x*x4+x*x*x*x*x*x5;
    }
}
