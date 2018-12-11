package arm_emu;

import java.util.*;
import java.io.File;

public class reader
{
    File code= new File("ARM_code.txt");
    String[] cline;
    //String[] cline= new String[2];
    
    public void setup()
    {
    
        try
        {
        Scanner scan= new Scanner(code);
        int numoflines=0;
        boolean lenb= scan.hasNextLine();
        while(lenb)
            {
                numoflines++;
                scan.nextLine();
                lenb= scan.hasNextLine();
            }
        cline=new String[numoflines];
        scan.close();
        scan= new Scanner(code);
        for(int i=0; i<cline.length; i++)
            {
                cline[i]=scan.nextLine();
            }
        }
        catch (Exception e){}
    
        //cline[0]="sub     sp, sp, #8";
        //cline[1]="str     r0, [sp, #4]";
    }
    
    public String[] readerTest()
    {
        return cline;
    }
}