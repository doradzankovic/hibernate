package perzistencijahibernate;

import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) 
    {
        KorisnickiPrikaz kp = new KorisnickiPrikaz();
        kp.setExtendedState(JFrame.MAXIMIZED_BOTH);
        kp.setVisible(true);
    }
    
}
