package arm_emu;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ARM_EMU {

    public static void main(String[] args)
    /*{ 
        steeldan steel=new steeldan();
        String[][] input=steeldan.read();
        //steel.print(input);
        steel.findcomd(input);
        steel.print(input);
    }
    /*{
        ARM leg= new ARM(10,16,12,4);
        int sp=0;
        leg.mov(0,3);
        sp=leg.str(0,sp,64);
        leg.mov(1,7+16);
        sp=leg.str(1,sp,0);
        sp=leg.ldr(2,sp,64);
        sp=leg.ldr(3,sp,0);
        leg.mul(4,3,2);
        leg.print();
    }*/        
    /*{
        ARM leg= new ARM(10,16,12,4);
        int sp=0;
        leg.mov(0,3,0);
        sp=leg.str(0,sp,64,false,false);
        leg.mov(1,7+16,0);
        sp=leg.str(1,sp,0,false,false);
        sp=leg.ldr(2,sp,64,false,false);
        sp=leg.ldr(3,sp,0,false,false);
        leg.sub(4,3,2);
        leg.print();
    }*/



    {
    JFrame frame = new JFrame("ARM EMulator");
    frame.setSize(900, 1050);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JLabel R1 = new JLabel("R1" + "\n");
    JLabel R2 = new JLabel("R2" + "\n");
    JLabel R3 = new JLabel("R3" + "\n");
    JLabel R4 = new JLabel("R4" + "\n");
    JLabel R5 = new JLabel("R5" + "\n");
    JLabel R6 = new JLabel("R6" + "\n");
    JLabel R7 = new JLabel("R7" + "\n");
    JLabel R8 = new JLabel("R8" + "\n");
    JLabel R9 = new JLabel("R9" + "\n");
    JLabel R10 = new JLabel("R10" + "\n");
    JLabel R11 = new JLabel("R11" + "\n");
    JLabel R12 = new JLabel("R12" + "\n");
    JLabel R13 = new JLabel("R13" + "\n");
    frame.setResizable(false);
        frame.add(R1);
    frame.setVisible(true);
        frame.add(R2);
    frame.setVisible(true);
        frame.add(R3);
    frame.setVisible(true);
        frame.add(R4);
    frame.setVisible(true);
      frame.add(R5);
    frame.setVisible(true);
      frame.add(R6);
    frame.setVisible(true);
      frame.add(R7);
    frame.setVisible(true);
      frame.add(R8);
    frame.setVisible(true);
      frame.add(R9);
    frame.setVisible(true);
      frame.add(R10);
    frame.setVisible(true);
      frame.add(R11);
    frame.setVisible(true);
      frame.add(R12);
    frame.setVisible(true);
      frame.add(R13);
    frame.setVisible(true);        
    }
}