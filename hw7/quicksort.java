import java.util.*;
public class quicksort
{
    
    /**
     * the map which is going to be operated.
     */
    private myMap originalMap;
    /**
     * after sort operation.
     */
    private myMap sortedMap;
    /**
     * temporary key List.
     */
    private List<Character> aux;
    /**
     * constructer of quick sort
     * @param input the map which is going to be sorted.
     */

    public quicksort(myMap input)
    {
        originalMap =input;
        aux = new ArrayList<Character>();
        fill_aux(input);
        sortedMap = new myMap();
    }
    /**
     * It fills aux field with myMap class.
     * @param input which includes string.
     */
    public void fill_aux(myMap input)
    {
        String temp_str = input.get_str();
        int i=0;
        
        while(i<temp_str.length())
        {
            if(!aux.contains(temp_str.charAt(i)) && temp_str.charAt(i) != ' ')
                aux.add(temp_str.charAt(i));
            i++;
        }
    }
    /**
     * after sorting aux then sortedmap created in here.
     */
    private void create_map()
    {
        for(int i=0;i<aux.size();i++)
        {
            sortedMap.add(aux.get(i), originalMap.get(aux.get(i)));
        }
    }
    public void quicksortThem()
    {
        quicksort_helper(0, originalMap.get_mapsize());
        create_map();
        System.out.println(aux);
        System.out.println(sortedMap);
    }
    private void quicksort_helper(int begin,int end)
    {
        if(begin<end)
        {
            int pivot = divide(begin,end);
            quicksort_helper(begin,pivot);
            quicksort_helper(pivot+1, end);
        }
    }
    private int divide(int begin,int end)
    {
        info piv = originalMap.get(aux.get(end-1));
        int i=begin-1;
        Character temp;
        for(int k = begin;k<end;k++)
        {
            if(originalMap.get(aux.get(k)).get_count()<piv.get_count() )
            {
                ++i;
                temp = aux.get(i);
                aux.set(i,aux.get(k));
                aux.set(k, temp);
            }
        }
        temp = aux.get(i+1);
        aux.set(i+1,aux.get(end-1));
        aux.set(end-1, temp);
        return i+1;

    }
}