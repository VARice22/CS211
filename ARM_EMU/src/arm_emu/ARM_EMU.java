package arm_emu;

public class ARM_EMU {

    public static void main(String[] args)
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
        reader input= new reader();
        input.setup();
        String[] in=input.readerTest();
        //for(int i=0; i<in.length; i++) System.out.println(in[i]);
        
        for(int cline=0; cline<in.length; cline++)//run throw program
        {
            
            for(int ch=0;ch<in[cline].length(); ch++)//run through line
            {
                String comd;
                int start=-5,end=-5;//lines MUST be less that 8000 char in length
                if((in[cline].charAt(ch)!=(' ') || in[cline].charAt(ch)!=(',')) && (ch-1<=-1 || in[cline].charAt(ch-1)==(' ') || in[cline].charAt(ch-1)==(',')))
                {
                    start=ch;
                }
                
                if((in[cline].charAt(ch)==(' ') || in[cline].charAt(ch)==(',')) && (/*ch+1>=in[cline].length() ||*/ in[cline].charAt(ch-1)!=(' ') || in[cline].charAt(ch-1)!=(',')))
                {
                    end=ch;
                }
                if(start!=-5 && end!=-5){comd=in[cline].substring(start, end); System.out.println(comd+" ");}//not reading strings corectly, Fix^^^^^
                System.out.println(in[cline]+"  "+ch);
            }
            
            
            //String comd=in[cline].substring(in[cline].indexOf(!' '), cline);
        }
        
    }
    
}
