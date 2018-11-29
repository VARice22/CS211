package arm_emu;

import java.lang.Math;
public class machine
{
    int[] decimalToSignedBinary(int value,int bits)
    {
        int[] t=new int[bits];
        if (value>=0){t[0]=0;}
        else if (value<0){t[0]=1; value*=-1;}
        for(int i=1; i<bits; i++)
        {
            if (value>=Math.pow(2,((bits-1)-i)))
            {
                //System.out.println(value+" "+Math.pow(2,((bits-1)-i))+" "+bits+" "+i);
                
                t[i]=1;
                value-=Math.pow(2,((bits-1)-i));
                
            }
            else t[i]=0;
        }
        return t;
    }
    int[] decimalToOnesComplement(int value,int bits)
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
            value*=-1;
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
    int[] decimalToTwosComplement(int value,int bits)
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
    int TowsComplementToDecimal(int[] t)
    {
        int total=0;
        if (t[0]==0)
        {
            for(int i=0; i<t.length; i++)
            {
                total+=(t[i]*Math.pow(2,(t.length-i)-1));
            }
        }
        
        else
        {
            for(int i=1; i<t.length; i++)
            {
                total+=((t[i]-1)*Math.pow(2,(t.length-i)-1));
            }
            if (total>0){
                total*=-1;}
            total-=1;
        }
        return total;
    }
    int[] addSignedBinary(int[] k, int[] y)
    {
        int value=0;
        if(k[0]==0)
        {
            for(int i=0; i<k.length; i++)
            {
                value+=(k[i]*Math.pow(2,(k.length-i)-1));
            }
        }
        
        if(k[0]==1)
        {
            for(int i=1; i<k.length; i++)
            {
                value-=((k[i])*Math.pow(2,(k.length-i)-1));
            }
            
        }
        
        if(y[0]==0)
        {
            for(int i=0; i<y.length; i++)
            {
                value+=(y[i]*Math.pow(2,(y.length-i)-1));
            }
        }
        
        if(y[0]==1)
        {
            for(int i=1; i<y.length; i++)
            {
                value-=((y[i])*Math.pow(2,(y.length-i)-1));
            }
            
        }
        
        int[] t=new int[k.length];
        if (value>=0){t[0]=0;}
        else if (value<0){t[0]=1; value*=-1;}
        for(int i=1; i<k.length; i++)
        {
            if (value>=Math.pow(2,((k.length-1)-i)))
            {
                t[i]=1;
                value-=Math.pow(2,((k.length-1)-i));
            }
            else t[i]=0;
        }
        return t;
    }
    int[] addTowsComplement(int[] t, int[] y)
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
    int[] mulSignedBinary(int[] k, int[] y)
    {
        int c=0, u=0;
        if(k[0]==0)
        {
            for(int i=0; i<k.length; i++)
            {
                c+=(k[i]*Math.pow(2,(k.length-i)-1));
            }
        }
        
        if(k[0]==1)
        {
            for(int i=1; i<k.length; i++)
            {
                c-=((k[i])*Math.pow(2,(k.length-i)-1));
            }
            
        }
        
        if(y[0]==0)
        {
            for(int i=0; i<y.length; i++)
            {
                u+=(y[i]*Math.pow(2,(y.length-i)-1));
            }
        }
        
        if(y[0]==1)
        {
            for(int i=1; i<y.length; i++)
            {
                u-=((y[i])*Math.pow(2,(y.length-i)-1));
            }
            
        }
        
        int value=c*u;
        int[] t=new int[k.length];
        if (value>=0){t[0]=0;}
        else if (value<0){t[0]=1; value*=-1;}
        for(int i=1; i<k.length; i++)
        {
            if (value>=Math.pow(2,((k.length-1)-i)))
            {
                t[i]=1;
                value-=Math.pow(2,((k.length-1)-i));
            }
            else t[i]=0;
        }
        return t;
    }
    int[] mulTowsComplement(int[] t, int[] y)
    {
        int carry=0;
        int[] k=new int[t.length];
        int[] d=new int[t.length];
        for(int i=t.length-1; i>=0;i--)
        {
            for(int j=y.length-1; j>=0;j--)
            {
                System.out.println("m");
                if(t[i]*y[j]==0){k[j-(k.length-i)]=0;}
                else if(t[i]*y[j]==1){k[j-(k.length-i)]=1;}
            }
            for(int z=k.length-1; z>=0;z--)
            {   
                if(k[z]+d[z]+carry==0){d[z]=0; carry=0;}
                else if(k[z]+d[z]+carry==1){d[z]=1; carry=0;}
                else if(k[z]+d[z]+carry==2){d[z]=0; carry=1;}
                else if(k[z]+d[z]+carry==3){d[z]=1; carry=1;}
            
            }
        }
        
        return d;
    }
}