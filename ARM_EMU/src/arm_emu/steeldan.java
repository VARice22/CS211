/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arm_emu;

import java.util.*;

public class steeldan {
    stringToComd std;
    int[] specs;
    public steeldan(int[] s)
    {
        specs=s;
        std= new stringToComd(s);
    }
    
    public static String[][] read(){
        reader input= new reader();
        input.setup();
        String[] in=input.readerTest();
        //for(int i=0; i<in.length; i++) System.out.println(in[i]);//print function
        String[][] commands= new String[in.length][10];
        int line=0, comdnum=0;
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
                    commands[line][comdnum]=comd;
                    comdnum++;
                    //System.out.println(comd);//prind comand that has been found
                }
            }
            line++;
            comdnum=0;
        }
        return commands;
    }
    public void print(String[][] input)
    {
        for(int i=0; i<input.length; i++)
        {
            for(int j=0; j<input[i].length; j++)
            {
                System.out.print(input[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        std.passPrint();
    }
    public void findcomd(String[][] input)
    {
        //stringToComd std= new stringToComd();
        //list of reserved words
        String[] resword={"add","sub","mul","and","eor","orr","ldr","str","mov"};
        
        for(int i=0; i<input.length; i++)
        {
            int g=0;
            for(int k=0; k<resword.length; k++)//change input to an array of comds
            {
                //int g=0;
                if(input[i][0].equalsIgnoreCase(resword[k]))
                {
                    g=k;
                }
            }
            //System.out.println(i+" "+g);
            std.comd(g+1,input,i);
        }
    }
    public LinkedList<String> getreg(){return std.passtoFX();}
    public int passRegnum(){return std.passRegnum();}
}    