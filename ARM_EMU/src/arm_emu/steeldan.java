/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arm_emu;

/**
 *
 * @author avance
 */
public class steeldan {
    
    public static void read(){
        reader input= new reader();
        input.setup();
        String[] in=input.readerTest();
        //for(int i=0; i<in.length; i++) System.out.println(in[i]);//print function
        
        for(int cline=0; cline<in.length; cline++)//run throw program
        {
            int start=-5,end=-5;//lines MUST be less that 8000 char in length
            for(int ch=0;ch<in[cline].length(); ch++)//run through line
            {
                String comd;
                if((in[cline].charAt(ch)!=(' ') && in[cline].charAt(ch)!=(',')) && (ch-1<=-1 || in[cline].charAt(ch-1)==(' ') || in[cline].charAt(ch-1)==(',')))
                {
                    start=ch;
                }
                
                if((in[cline].charAt(ch)==(' ') || in[cline].charAt(ch)==(',') || ch+1==in[cline].length()) && (/*ch+1>=in[cline].length() ||*/ in[cline].charAt(ch-1)!=(' ') && in[cline].charAt(ch-1)!=(',')))
                {
                    if(ch+1==in[cline].length()) end=ch+1;
                    else end=ch;
                }
                //System.out.println(in[cline]+"  "+ch+" "+start+" "+end);//print line, current char, start and end values
                if(start!=-5 && end!=-5)
                {
                    comd=in[cline].substring(start, end);
                    start=-5;
                    end=-5;
                    //System.out.println(comd);//prind comand that has been found
                }
            }
        }
        
    }
    

}
