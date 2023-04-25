
public class passwordTwo
{
    private int password2;
    //private int [] denominations ={4,17,29};
    public passwordTwo(int num)
    {
        password2=num;
    }
    /**
     * it checks if it is possible to summation with given array to destination. 
     * @param total data transformation via recursively.
     * @param denominations given array
     * @return true if it is able to.
     */
    public boolean isExactDivision(int total,int[] denominations)
    {
        boolean what;
        for(int i=0;i<denominations.length;i++)
        {
            if(total==password2)
                return true;
            if(total<password2)
            {
                what =isExactDivision(total+denominations[i], denominations);
                if(!what)
                    total-=denominations[i];
                else
                    return true;
            }
            else
                return false;
        
        }
        if(total==password2)
                return true;
        return false;
    }
    /**
     * it checks password greater than 10 and less than 10000
     * @return true if it is valid.
     */
    public boolean valid_num()
    {
        if(password2>=10 && password2<10000)
            return true;
        return false;
    }
}