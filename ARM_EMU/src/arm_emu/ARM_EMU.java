package arm_emu;

public class ARM_EMU {

    public static void main(String[] args) {
        ARM leg= new ARM(10,16,12,4);
        int sp=0;
        leg.mov(0,3,0);
        sp=leg.str(0,sp,64,false,false);
        leg.mov(1,7+16,0);
        sp=leg.str(1,sp,0,false,false);
        sp=leg.ldr(2,sp,64,false,false);
        sp=leg.ldr(3,sp,0,false,false);
        leg.add(4,2,3);
leg.print();
    }
    
}
