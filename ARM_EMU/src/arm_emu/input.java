package arm_emu;

import java.util.*;

public class input
{
    public void setup(){
    Scanner scan= new Scanner("ARM_code.txt");
    int numoflines=0;
    boolean lenb= scan.hasNextLine();
    while(lenb)
    {
        numoflines++;
        lenb= scan.hasNextLine();
    }
    String[] cline=new String[numoflines];
    }
    
}
