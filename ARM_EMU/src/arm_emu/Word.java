package arm_emu;

//shi
public class Word {
    private boolean[] bs;
    public int bits;
    
    public Word(int bits){
        bs = new boolean[bits];
        this.bits = bits;
    }
    public boolean[] get(){
        boolean[] r = new boolean[this.bs.length];
        for(int i = 0; i < this.bs.length; i++){
            r[i] = this.bs[i];
        }
        return r;
    }
    public void set(boolean[] r){
        for(int i = 0; i < r.length; i++){
            this.bs[i] = r[i];
        }
    }  
}
