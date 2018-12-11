//this is now useless you no longer need it


package arm_emu;

public class bimath
{
    public static boolean[] multiplier(boolean[] a, boolean[] b)
    {
        //initalize product
        boolean[] p= new boolean[32];
        for (byte h3=0; h3<p.length; h3++)p[h3]=false;
        
        for(byte i=31;i>=0 ;i--)
        {
            //leftshift
            if(i!=31){
            boolean shifttemp=a[0];
            for(byte j=0;j<a.length;j++)
            {
                if(j+1==a.length) a[j]=shifttemp;
                else a[j]=a[j+1];
            }
            }
            
            if(b[i]==true)
            {
                boolean carry=false;
                boolean[] k=new boolean[a.length];
        
                for(int u=k.length-1; u>=0;u--)
                {
                    if(a[u]==false && b[u]==false && carry==false){k[u]=false; carry=false;}
                    else if(a[u] && b[u] && carry){k[u]=true; carry=true;}
                    else{
                        if(a[u]&&b[u] || carry&&b[u] || carry&&a[u]){k[u]=false; carry=true;}
                        else {k[i]=true; carry=false;}
                    }
                }
                return k;
            }
        }
        return p;
    }
}