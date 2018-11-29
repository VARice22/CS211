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
public class bimath 
{
    public static byte[] multiplier(byte[] a, byte[] b)
    {
        //initalize product
        byte[] p= new byte[32];
        for (byte h3=0;h3<32;h3++)p[h3]=0;
        
        for(byte i=31;i>=0 ;i--)
        {
            //leftshift
            if(i!=31){
            byte shifttemp=a[0];
            for(byte j=0;j<a.length;j++)
            {
                if(j+1==a.length) a[j]=shifttemp;
                else a[j]=a[j+1];
            }
            }
            /*
            for(byte u=0;u<a.length;u++)
            {
                System.out.print(a[u]);
            }
            System.out.println();
            */
            if(b[i]==1)
            {    
                //add
                /*
                for(byte u=0;u<a.length;u++)
                {
                    System.out.print(a[u]);
                }
                System.out.println();
                */
                byte carry=0;
                for(byte x=31; x>=0;x--)
                {
                    if(p[x]+a[x]+carry==0){p[x]=0; carry=0;}
                    else if(p[x]+a[x]+carry==1){p[x]=1; carry=0;}
                    else if(p[x]+a[x]+carry==2){p[x]=0; carry=1;}
                    else if(p[x]+a[x]+carry==3){p[x]=1; carry=1;}
                }
            }
        }
        return p;
    }
}
