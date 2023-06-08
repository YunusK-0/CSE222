import java.util.ArrayList;
public class info
{
    /**
     * how many times it occurs.
     */
    private int count;
    /**
     * the word of a letter which it has.
     */
    private ArrayList<String> words;
    /**
     * initiliazation is done by here.
     */
    public info()
    {
        count =0;
        words = new ArrayList<String>();
    }
    /**
     * get method of count 
     * @return integer.
     */
    public int get_count()
    {
        return count;
    }
    /**
     * it is add the words which is includes spesific letter.
     * @param str input
     * @param position cursor.
     */
    public void seems_before(String str, int position)
    {
        String temp = new String();
        int begin = find_begin(str, position);
        int end = find_end(str, position);

        for(int i =begin;i<end;i++)
        {
            temp+=str.charAt(i);
            //System.out.println(str+"-- begin=  "+begin+"-- end="+end+"|| i="+i+ "temp is="+temp + "||poss! "+position);
        }
        count++;
        words.add(temp);

    }
    /**
     * finds previous space of given position
     * @param str string as a input
     * @param position current location of cursor
     * @return integer.
     */
    private int find_begin(String str,int position)
    {
        int i;
        for(i=position;i>=0;i--)
        {
            if(str.charAt(i) ==' ')
                return i+1;
        }
        return 0;
    }
    /**
     * finds next space after given position.
     * @param str input
     * @param position current cursor 
     * @return position of next space in the string
     */
    private int find_end(String str,int position)
    {
        int i;
        for(i =position;i<str.length();i++)
        {
            if(str.charAt(i) == ' ')
                return i;
        }
        return str.length();
    }
    /**
     * basic to string. count and whole words.
     */
    public String toString()
    {

        return "Counted =" +count+ "  "+words.toString() +'\n';
    }

}