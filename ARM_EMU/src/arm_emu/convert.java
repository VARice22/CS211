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
public class convert {
    int[] dtc(int value,int bits)
    {
        int[] t=new int[bits];
        if (value>=0)
        {
            t[0]=0;
            for(int i=1; i<bits; i++)
            {
                if (value>=Math.pow(2,((bits-1)-i)))
                {
                    t[i]=1;
                    value-=Math.pow(2,((bits-1)-i));
                }
                else t[i]=0;
            }
            return t;
        }
        else {
            t[0]=1;
            value=(value*-1)-1;
            
            for(int i=1; i<bits; i++)
            {
                if (value>=Math.pow(2,((bits-1)-i)))
                {
                    t[i]=0;
                    value-=Math.pow(2,((bits-1)-i));
                }
                else t[i]=1;
            }
            return t;
        }
    }
    int[] atc(int[] t, int[] y)
    {
        int carry=0;
        int[] k=new int[t.length];
        
        for(int i=k.length-1; i>=0;i--)
        {
            if(t[i]+y[i]+carry==0){k[i]=0; carry=0;}
            else if(t[i]+y[i]+carry==1){k[i]=1; carry=0;}
            else if(t[i]+y[i]+carry==2){k[i]=0; carry=1;}
            else if(t[i]+y[i]+carry==3){k[i]=1; carry=1;}
        }
        return k;   
    }
}
