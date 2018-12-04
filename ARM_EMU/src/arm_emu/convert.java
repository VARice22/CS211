package arm_emu;

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
    
    boolean[] stc(boolean[] t, boolean[] y)// subtract twos complement
    {
        //flip second num
        for(int i=0; i<y.length; i++)
        {
            if(y[i])y[i]=false;
            else if(!y[i])y[i]=true;
        }
        //create 1
        boolean[] addOne=new boolean[y.length];
        for(int i=0; i<addOne.length; i++)
        {
            if(i+1==addOne.length)addOne[i]=true;
            else addOne[i]=false;
        }
        //add 1
        boolean carry=false;
        boolean[] k=new boolean[y.length];
        
        for(int i=k.length-1; i>=0;i--)
        {
            if(addOne[i]==false && y[i]==false && carry==false){k[i]=false; carry=false;}
            else if(addOne[i] && y[i] && carry){k[i]=true; carry=true;}
            else{
                if(addOne[i]&&y[i] || carry&&y[i] || carry&&addOne[i]){k[i]=false; carry=true;}
                else {k[i]=true; carry=false;}
            }
        }
        
        //subtract
        carry=false;
        boolean[] outPut=new boolean[t.length];
        
        for(int i=outPut.length-1; i>=0;i--)
        {
            if(t[i]==false && k[i]==false && carry==false){outPut[i]=false; carry=false;}//0
            else if(t[i] && k[i] && carry){outPut[i]=true; carry=true;}//3
            else{
                if(t[i]&&k[i] || carry&&k[i] || carry&&t[i]){outPut[i]=false; carry=true;}//2
                else {outPut[i]=true; carry=false;}//1
            }
        }
        return outPut;
    }
}
