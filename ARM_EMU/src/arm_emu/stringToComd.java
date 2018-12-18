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
public class stringToComd{
    ARM leg= new ARM(10,16,12,4);
    
    public void comd(int comd, String[][] input,int i)
    {
        int[] temp=new int[3];
        
        for(int j=1;j<input[i].length;j++)
        {
            if(input[i][j]!=null){
                if(input[i][j].charAt(0)=='r'||input[i][j].charAt(0)=='#')
                {
                    for(int u=0; u<100; u++)
                    {
                        if(input[i][j].substring(1,input[i][j].length()).equals(Integer.toString(u))){temp[j-1]=u;}
                    }
                }
                else if(input[i][j].charAt(0)=='s')temp[j-1]=-1;
            }
        }
        
        switch(comd)
        {
            case 1:leg.add(temp[0],temp[1],temp[2]);
            break;
            case 2:leg.sub(temp[0],temp[1],temp[2]);
            break;
            case 3:leg.mul(temp[0],temp[1],temp[2]);
            break;
            case 4:leg.and(temp[0],temp[1],temp[2]);
            break;
            case 5:leg.eor(temp[0],temp[1],temp[2]);
            break;
            case 6:leg.orr(temp[0],temp[1],temp[2]);
            break;
            case 7:leg.ldr(temp[0],temp[1],temp[2]);
            break;
            case 8:leg.str(temp[0],temp[1],temp[2]);
            break;
            case 9:leg.mov(temp[0],temp[1]);
            break;
        }
    }
    public void passPrint(){leg.print();}
}
