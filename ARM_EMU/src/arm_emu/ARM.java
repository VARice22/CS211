package arm_emu;

public class ARM {
    private RegisterBank rb;
    private RAM mb;
    private convert vert=new convert();
    int rbits, rsize;
    
    public ARM(int size_reg, int bits_reg, int size_ram, int bytes_ram){
        rb = new RegisterBank(size_reg,bits_reg);
        mb = new RAM(size_ram,bytes_ram);
        rbits=bits_reg;
        rsize=size_reg;
    }
    
    public void mov(int Rd, int Rn, int bitshift){
        boolean[] white=vert.dtc(Rn,rbits);
        Word summer= new Word(rbits);
        summer.set(white);
        rb.set(Rd,summer);
    }
    
    public int str(int Rd, int Rn, int o, boolean pre, boolean mod_pre){
        if(pre){
        Word temp=rb.get(Rd);
        mb.set(temp,Rn+o);
        return Rn+o;}
        
        else if(mod_pre){
        Word temp=rb.get(Rd);
        mb.set(temp,Rn);
        return Rn+o;}
        
        else {
        Word temp=rb.get(Rd);
        mb.set(temp,Rn+o);
        return Rn;}
    }
    
    public int ldr(int Rd, int Rn, int o, boolean pre, boolean mod_pre){
        if(pre){
        Word temp=mb.get(rbits/8,Rn+o);
        rb.set(Rd,temp);
        return Rn+o;}
        
        else if(mod_pre){
        Word temp=mb.get(rbits/8,Rn);
        rb.set(Rd,temp);
        return Rn+o;}
        
        else {
        Word temp=mb.get(rbits/8,Rn+o);
        rb.set(Rd,temp);
        return Rn;}
    }
    
    public void add(int Rd, int Rn, int Rc){
        Word black= rb.get(Rn);
        Word guitar=rb.get(Rc);
        boolean[] red=black.get();
        boolean[] hair=guitar.get();
        boolean[] green=vert.atc(red,hair);
        Word bicycle=new Word(rbits);
        bicycle.set(green);
        rb.set(Rd, bicycle);
    }
    
    public void print(){
        for(int i=0; i<rsize;i++)
        {
            Word yuji=rb.get(i);
            boolean[] everylead= yuji.get();
            System.out.print("R"+i+"   ");
            for(int j=0; j<everylead.length;j++)
            {
                if(everylead[j])System.out.print(1);
                else System.out.print(0);
            }
            System.out.println();
        }
        System.out.println();
        Word yuji=mb.get(12*4,0);
            boolean[] everylead= yuji.get();
            for(int j=0; j<everylead.length;j++)
            {
                if(j%32!=0){
                        if(everylead[j])System.out.print(1);
                        else System.out.print(0);
                }
                else if(j%32==0){
                System.out.println();
                if(everylead[j])System.out.print(1);
                else System.out.print(0);
                }
            }
    }
    
}
