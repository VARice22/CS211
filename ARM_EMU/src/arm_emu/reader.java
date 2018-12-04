package arm_emu;

import java.util.*;
import java.io.File;

public class reader
{
    File code= new File("ARM_code.txt");
    String[] cline;
    
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
    }
    
    public String[] readerTest()
    {
        return cline;
    }
}