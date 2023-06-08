import java.util.List;
import java.util.ArrayList;

public class insertionsort {
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
     * constructer of insertionsort.
     * @param input
     */

    public insertionsort(myMap input)
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
     * 
     * it sorts and it merge them.
     */
    public void insertionsort()
    {
        sorting();
        System.out.println(aux);
        create_map();
        System.out.println(sortedMap);
    }
    /**
     * insertion sort algorithm is in here.
     */
    private void sorting()
    {
        Character temp;
        for(int i=1;i<aux.size();i++)
        {
            for(int j=i-1;j>=0;j--)
            {
                if(originalMap.get(aux.get(j)).get_count() > originalMap.get(aux.get(j+1)).get_count())
                {
                    temp = aux.get(j);
                    aux.set(j,aux.get(j+1));
                    aux.set(j+1, temp);
                }
                else
                    break;
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
