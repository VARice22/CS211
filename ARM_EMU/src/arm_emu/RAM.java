package arm_emu;

//ni
public class RAM {
    
   private boolean[] rs;
    
    public RAM(int size, int bytes){
        rs = new boolean[size*8*bytes];
    }
    
    public Word get(int bytes, int a){
        int bits = 8*bytes;
        boolean[] r = new boolean[bits];
        for(int i = 0; i < bits; i++){
            r[i] = rs[a+i];
        }
        Word w = new Word(bits);
        w.set(r);
        return w;       
    }
    
    public void set(Word w, int a){
        boolean[] r = w.get();
        for(int i = 0; i < r.length; i++){
            rs[a+i] = r[i];
        }
    }
}
