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
        boolean[] dtc(int value,int bits)//decimal to two complement
    {
        boolean[] t=new boolean[bits];
        if (value>=0)
        {
            t[0]=false;
            for(int i=1; i<bits; i++)
            {
                if (value>=Math.pow(2,((bits-1)-i)))
                {
                    t[i]=true;
                    value-=Math.pow(2,((bits-1)-i));
                }
                else t[i]=false;
            }
            return t;
        }
        else {
            t[0]=false;
            value=(value*-1)-1;
            
            for(int i=1; i<bits; i++)
            {
                if (value>=Math.pow(2,((bits-1)-i)))
                {
                    t[i]=false;
                    value-=Math.pow(2,((bits-1)-i));
                }
                else t[i]=true;
            }
            return t;
        }
    }
    boolean[] atc(boolean[] t, boolean[] y)// add twos complement
    {
        boolean carry=false;
        boolean[] k=new boolean[t.length];
        
        for(int i=k.length-1; i>=0;i--)
        {
            /*
            if(t[i]+y[i]+carry==0){k[i]=0; carry=0;}
            else if(t[i]+y[i]+carry==1){k[i]=1; carry=0;}
            else if(t[i]+y[i]+carry==2){k[i]=0; carry=1;}
            else if(t[i]+y[i]+carry==3){k[i]=1; carry=1;}
            */
            if(t[i]==false && y[i]==false && carry==false){k[i]=false; carry=false;}//0
            else if(t[i] && y[i] && carry){k[i]=true; carry=true;}//3
            else{
                if(t[i]&&y[i] || carry&&y[i] || carry&&t[i]){k[i]=false; carry=true;}//2
                else /*if(!t[i]&&!y[i] || !carry&&!y[i] || !carry&&!t[i])*/{k[i]=true; carry=false;}//1
            }
        }
        return k;
    }
}
