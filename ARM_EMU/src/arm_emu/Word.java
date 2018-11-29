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
public class Word {
    private int[] bs;
    public int bits;
    
    public Word(int bits){
        bs = new int[bits];
        this.bits = bits;
    }
    public int[] get(){
        int[] r = new int[this.bs.length];
        for(int i = 0; i < this.bs.length; i++){
            r[i] = this.bs[i];
        }
        return r;
    }
    public void set(int[] r){
        for(int i = 0; i < r.length; i++){
            this.bs[i] = r[i];
        }
} 
}
