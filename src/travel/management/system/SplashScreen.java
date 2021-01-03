package travel.management.system;
import javax.swing.*;
import java.awt.*;
public class SplashScreen {
    public static void main(String[] args){
        SplashFrame ob=new SplashFrame();
        ob.setVisible(true);
        int x=1;
        for(int i=1;i<=700;i+=6,x+=7){
            ob.setLocation(950-(x+i)/2,500-(i/2));//distance from left and top respectively
            ob.setSize(i+x,i);//height and breadth as parameters respectively
            try{
                Thread.sleep(15);
            }catch(Exception e){}
        }     
        ob.setVisible(true);//by default-false;thus unable to see the screen(invisible)
    }
}
class SplashFrame extends JFrame implements Runnable{
    Thread t1;
    SplashFrame(){
        //imageicon class to use image.It is inside swing package
        //ClassLoader is used when we want to import image form our system
        //getSystemResource() is a static method
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/splash.jpg"));
        Image i2=i1.getImage().getScaledInstance(1600,700,Image.SCALE_DEFAULT);
        //image class cannot be directly used in JLabel so we again have to create a class of ImageIcon
        ImageIcon i3=new ImageIcon(i2);
        //Image i1 cannot be added directly so we had to create a label
        JLabel l1=new JLabel(i3);
        add(l1);
        setBounds(200,200,1600,700);//combination od SetLocation and SetSize(first two param:loc;others:size) 
        setUndecorated(true);
        t1=new Thread(this);//helps to close the thread after 7 seconds
        t1.start();
    }
    public void run(){ 
        try{
                Thread.sleep(7000);//to automatically close the window after 7 seconds
                this.setVisible(false);
        }catch(Exception e){}
    }
}