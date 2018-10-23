

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Panel extends JFrame{

    private JPanel panel;
    Drawer dibujante;

    void initializeComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 800);
        panel = new JPanel();
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panel);
        panel.setLayout(null);
        setBounds(0,0,800,800);
        setVisible(true);
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        dibujante=new Drawer(g);
        dibujante.inicia(400,400);
        patronA(2);
    }
    
    /*void hilbert(int n){
        if(n==0)return;
        dibujante.turnLeft(90);
        treblih(n-1);
        dibujante.traza(50);
        dibujante.turnLeft(-90);
        hilbert(n-1);
        dibujante.traza(50);
        hilbert(n-1);
        dibujante.turnLeft(-90);
        dibujante.traza(50);
        treblih(n-1);
        dibujante.turnLeft(90);
    }
    
    void treblih(int n){
        if(n==0)return;
        dibujante.turnLeft(-90);
        hilbert(n-1);
        dibujante.traza(50);
        dibujante.turnLeft(90);
        treblih(n-1);
        dibujante.traza(50);
        treblih(n-1);
        dibujante.turnLeft(90);
        dibujante.traza(50);
        hilbert(n-1);
        dibujante.turnLeft(-90);
    }*/

//    void gosper(int n){
//        if(n == 0) return;
//        patronA();
//        dibujante.turnRight(60);
//        patronB();
//        dibujante.turnRight(60);
//        dibujante.turnRight(60);
//        patronB();
//        dibujante.turnLeft(60);
//        patronA();
//        dibujante.turnLeft(60);
//        dibujante.turnLeft(60);
//        patronA();
//        patronA();
//        dibujante.turnLeft(60);
//        patronB();
//    }
    
    void patronA(int n){ 
        if(n == 0) return;
        dibujante.traza(10, Color.RED);
        patronA(n-1);
        dibujante.turnRight(60); //60
        dibujante.traza(10);
        patronB(n-1);
        dibujante.turnRight(60);
        dibujante.turnRight(60);
        dibujante.traza(10);
        patronB(n-1);
        dibujante.turnLeft(60);//120
        dibujante.traza(10);
        patronA(n-1);
        dibujante.turnLeft(60); //0
        dibujante.turnLeft(60);
        dibujante.traza(10);
        patronA(n-1);
        dibujante.traza(10);
        patronA(n-1);
        dibujante.turnLeft(60); //-60
        dibujante.traza(10);
        patronB(n-1);
        dibujante.turnRight(60);
    }
    
    void patronB(int n){
        if(n == 0) return;
        dibujante.turnLeft(60);
        dibujante.traza(10, Color.GREEN);
        patronA(n-1);
        dibujante.turnRight(60); //0
        dibujante.traza(10);
        patronB(n-1);
        dibujante.traza(10);   
        patronB(n-1);
        dibujante.turnRight(60);
        dibujante.turnRight(60);//-180
        dibujante.traza(10);
        patronB(n-1);
        dibujante.turnRight(60);//-120
        dibujante.traza(10);
        patronA(n-1);
        dibujante.turnLeft(60);
        dibujante.turnLeft(60);//0
        dibujante.traza(10);
        patronA(n-1);
        dibujante.turnLeft(60); //60
        dibujante.traza(10);
        patronB(n-1);
    }
    public static void main(String[] args) {
        Panel p = new Panel();
        p.initializeComponents();
        
    }
 
}
