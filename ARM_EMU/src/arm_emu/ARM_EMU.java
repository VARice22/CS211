package arm_emu;

public class ARM_EMU {

    public static void main(String[] args)
    { 
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
}