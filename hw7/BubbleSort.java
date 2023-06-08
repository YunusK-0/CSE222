import java.util.List;
import java.util.ArrayList;
public class BubbleSort
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
     * constructer of bubble sort.
     * @param input which is going to be operated.
     */

    public BubbleSort(myMap input)
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
     * in this method it sorts and it merge them.
     */

    public void bublesort()
    {
        sorting();
        System.out.println(aux);
        create_map();
        System.out.println(sortedMap);
    }
    /**
     * sort algorithm is here.
     */
    private void sorting()
    {
        Character temp;
        boolean hasChanged=false;
        for(int i=0;i<aux.size();i++)
        {
            hasChanged = false;
            for(int j=0;j<aux.size()-1;j++)
            {
                if(originalMap.get(aux.get(j)).get_count() > originalMap.get(aux.get(j+1)).get_count())
                {
                    hasChanged=true;
                    temp = aux.get(j);
                    aux.set(j,aux.get(j+1));
                    aux.set(j+1, temp);
                }
            }
            if(!hasChanged)
                break;
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

}