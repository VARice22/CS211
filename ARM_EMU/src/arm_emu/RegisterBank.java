package arm_emu;

import java.util.ArrayList;

public class RegisterBank {
    private ArrayList<Word> rs;
    
    public RegisterBank(int size, int bits){
        rs = new ArrayList<Word>();
        rs.add(new Word(bits));
        for(int i = 0; i < size; i++){
            rs.add(new Word(bits));
        }
    }
    public Word get(int index){
        boolean[] i = rs.get(index+1).get();
        Word r = new Word(i.length);
        r.set(i);
        return r;
    }
    public void set(int index, Word r){
        rs.get(index+1).set(r.get());
    }
}