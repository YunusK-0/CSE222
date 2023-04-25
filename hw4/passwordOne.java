import java.util.Stack;

public class passwordOne
{
    private String password;
    /**
     * 
     * it contains every char that is in the password.
     */
    private int[] ascii_table = new int[128];
    /**
     * size of stack. because it checks number of {[()]}
     */
    private int stack_size;
    public passwordOne(String input)
    {
        password=input;
        stack_size=0;
    }
    /**
     * if any letter that is in username and appears in password returns true other. e.g:Username= gizem, password1= “{[(abacaba)]}” (output: False)
b. Username= gokhan, password1= “{[(abacaba)]}” (output: True)
     * @param username username
     * @return return true if it is exist
     */
    public boolean containsUserNameSpirit(String username)
    {
        char c;
        Stack<Character> temp_stack = new Stack<>();
        for(int i =0;i<username.length();i++)
        {
            temp_stack.push(username.charAt(i));
        }
        
        for(int i=0;i<username.length();i++)
        {
            c = temp_stack.pop();
            for(int y=0;y<password.length();y++)
            {
                if(c == password.charAt(y))
                    return true;
            }
        }
        return false;
    }
    /**
     * stack was used it only push {[()]} . letters are not important that much
     * @return if it is balanced return true
     */
    public boolean isBalancedPassword()
    {
        char c;
        Stack<Character> temp_stack = new Stack<>();
        for(int i=0;i<password.length();i++)
        {
            if(password.charAt(i) == '(' ||password.charAt(i) == '{' || password.charAt(i) == '[' )
            {
                stack_size++;
                temp_stack.push(password.charAt(i));
            }
            else if (password.charAt(i) == ')' ||password.charAt(i) == '}' || password.charAt(i) == ']')
            {
                stack_size++;
                if(temp_stack.isEmpty()==true)
                    return false;
                c= temp_stack.pop();
                if(c=='(' && password.charAt(i) != ')')
                    return false;
                else if(c=='[' && password.charAt(i) != ']')
                    return false;
                else if(c=='{' && password.charAt(i) != '}')
                    return false;
            }
        }
        return true;
        
    }
    /**
     * it checks is it possible to being polindrome or not
     * @param pswd recursively it gets smaller.
     * @return true if it is possible.
     */
    public boolean isPalindromePossible(String pswd)
    {
        if(pswd.length()==0 && search_ascii()<=1)
            return true;
        if(pswd.length() ==0 )
            return false;
        char c;
        String temp_sub= pswd.substring(1);
        c = pswd.charAt(0);
        if(pswd.charAt(0) == '{' ||pswd.charAt(0) == '}' || pswd.charAt(0) == '(' || pswd.charAt(0) == ')' || pswd.charAt(0) == '[' ||pswd.charAt(0) == ']' )
            return isPalindromePossible(temp_sub);
        else
        {
            ascii_table[c]+=1;
            return isPalindromePossible(temp_sub);
        }
    }
    /**
     * search ascii table to count how many odd numbers there are
     * @return
     */
    public int search_ascii()
    {
        int counter =0;
        for(int i =0;i<ascii_table.length;i++)
        {
            if(ascii_table[i] %2==1)
                counter++;
        }
        return counter;
    }
    /**
     * get method of size of password.
     * @return return true if it greater than 8 charecter.
     */
    public boolean size_gettr()
    {
        if(password.length()<8)
            return false;
        return true;
    }
    /**
     * this method contains number of brackets which are {[( 
     * @return true for more than one otherwise false.
     */
    public boolean stack_size_gettr()
    {
        if(stack_size <1)
            return false;
        return true;
    }
}