/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arm_emu;

/**
 *
 * @author Sharo
 */
public class RAM {
    
    private int[] rs;
    
    public RAM(int size, int bytes){
        rs = new int[size*8*bytes];
    }
    
    public Word get(int bytes, int a){
        int bits = 8*bytes;
        int[] r = new int[bits];
        for(int i = 0; i < bits; i++){
            r[i] = rs[a+i];
        }
        Word w = new Word(bits);
        w.set(r);
        return w;       
    }
    
    public void set(Word w, int a){
        int[] r = w.get();
        for(int i = 0; i < r.length; i++){
            rs[a+i] = r[i];
        }
    }
}
