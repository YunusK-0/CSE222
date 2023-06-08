import java.util.List;
import java.util.ArrayList;

public class selectionsort {
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
     * constructer of selection sort algorithm
     * @param input this is the value which is going to be sorted.
     */

    public selectionsort(myMap input)
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
     * public method and it does sorting operations and creates sorted map.
     */
    public void selectionsort()
    {
        sorting();
        System.out.println(aux);
        create_map();
        System.out.println(sortedMap);
    }
    /**
     * sorting part is done here.
     */
    private void sorting()
    {
        Character temp;
        int num=-1;
        int min_value;
        for(int i=0;i<aux.size();i++)
        {
            num =i;
            min_value = originalMap.get(aux.get(i)).get_count();
            for(int j=i;j<aux.size();j++)
            {
                if(min_value >originalMap.get(aux.get(j)).get_count() )
                {
                    min_value=originalMap.get(aux.get(j)).get_count();
                    num = j;
                }
                
            }
            if(originalMap.get(aux.get(i)).get_count() > originalMap.get(aux.get(num)).get_count())
            {
                temp = aux.get(i);
                aux.set(i,aux.get(num));
                aux.set(num, temp);
            }
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
