import java.util.LinkedHashMap;
/**
 * this is custom mymape class which includes linkedhasmap mapsize and string as a input
 */
public class myMap
{
    /**
    * contains character for to info class
    */
    private LinkedHashMap<Character,info>map;
    /**
     * length of map
     */
    private int mapSize;
    /**
     * input from user.
     */
    private String str;
    /**
     * merge sort object.
     */
    private mergeSort sorting;
    /***
     * initilization is done by constructer.
     * @param input the string which is going to be operated.
     */
    public myMap(String input)
    {
        mapSize=0;
        map = new LinkedHashMap<Character,info>();
        str = new String();
        part_one(input);
        System.out.println("Preprocessed string is "+str);
        part_two();
        String temp = map.toString();
        System.out.println(temp);
        System.out.println("--------");
        part_three();
    }
    /**
     * no parameter constructer.
     */
    public myMap()
    {
        map = new LinkedHashMap<>();
        mapSize=0;
    }
    /**
     * string manipulation is done here.
     * @param input input from user.
     */
    private void part_one(String input)
    {
        int i;

        for(i =0;i<input.length();i++)
        {
            if(input.charAt(i)>='A' && input.charAt(i)<='Z')
                str+= (char)(input.charAt(i)+32);
            else if(input.charAt(i) == ' ' || (input.charAt(i) >='a' && input.charAt(i) <='z'))
                str+= input.charAt(i);
        }
    }
    /**
     * manipulated string is placed to the map.
     */
    private void part_two()
    {
        sorting = new mergeSort(this);
        int i;
        //if(str.length() != 0)
        //{
        //    map.put(str.charAt(0), new info());
        //    mapSize++;
        //}
        for(i=0;i<str.length();i++)
        {
            if(str.charAt(i) != ' ')
            {
                if(map.containsKey(str.charAt(i)) == false)
                {
                    mapSize++;
                    map.put(str.charAt(i), new info());
                    sorting.add(str.charAt(i));
                    map.get(str.charAt(i)).seems_before(str, i);
                }
                else
                    map.get(str.charAt(i)).seems_before(str,i);
            }
        }
    }
    /**
     * simply gives the result of hashmap within parameter.
     * @param a the index of map (to simplfy or analogy). key.
     * @return value of the key.
     */
    public info get(Character a)
    {
        return map.get(a);
    }
    /**
     * add to the hashmap.
     * @param a key
     * @param input value
     */
    public void add(Character a,info input)
    {
        map.put(a, input);
    }
    /**
     * merge sort is done by it.
     */
    public void part_three()
    {
        sorting.sort(0,mapSize-1);
        sorting.finishing();
        sorting.print();
    }
    /**
     * to string method.
     */
    public String toString()
    {
        String temp = map.toString();
        return temp;
    }
    /**
     * get method of mapSize field.
     * @return int
     */
    public int get_mapsize()
    {
        return mapSize;
    }
}