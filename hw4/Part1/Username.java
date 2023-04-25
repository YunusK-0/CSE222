public class Username
{
    /**
     * this is the username
     */
    private String username;
    /**
     * size of username
     */
    private int size;
    /**
     * chekcs username is valid or not.
     * @param user
     * @return
     */
    public boolean checkIfValidUsername(String user)
    {
        char c='1';
        if(user.length()>0)
            c = user.charAt(0);
        if(size <1)
            return false;
        if(user.length()==0)
            return true;
        String sub = user.substring(1);
        if((c >='a' && c <='z'))
            return checkIfValidUsername(sub);
        else if (c >='A' && c <='Z')
            return checkIfValidUsername(sub);
        else
            return false;
    }
    /**
     * constructer takes a parameter that is the username.
     * initiliaze size with length of input.
     * @param input
     */
    public Username(String input)
    {
        username = input;
        size = input.length();
        checkIfValidUsername(input);
    }
    public boolean size_gettr()
    {
        if(size>=1)
            return true;
        return false;
    }
}