import java.util.*;

public class mergeSort
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
     * it initilizae sortedMap and aux
     * original map equals to input.
     * @param input original map.
     */
    public mergeSort(myMap input)
    {
        originalMap = input;
        aux = new ArrayList<Character>();
        sortedMap = new myMap();
    }
    /**
     * adding characters to the aux member.
     * @param input from original map
     */
    public void add(Character input)
    {
        aux.add(input);
    }
    public void print()
    {
        System.out.println(sortedMap);
        System.out.println(aux);
    }
    /**
     * merge operations is here.
     * @param begin left   
     * @param mid middle element
     * @param end right.
     */
    public void merge(int begin, int mid,int end)
    {
        int left_capacity = mid-begin+1;
        int right_capacity = end-mid;
        ArrayList<Character> left_array = new ArrayList<>(left_capacity);
        ArrayList<Character> right_array = new ArrayList<>(right_capacity);
        int i=0;
        for(i =0; i<left_capacity;i++)
            left_array.add(aux.get(i+begin));
        for(i =0; i<right_capacity;i++)
            right_array.add(aux.get(i+mid+1));
        int j=0; 
        i=0;
        int k=begin;
        while(i<left_capacity && j<right_capacity)
        {
            if(originalMap.get(left_array.get(i)).get_count() <= originalMap.get(right_array.get(j)).get_count())
            {
                aux.set(k, left_array.get(i));
                i++;
            }
            else
            {
                aux.set(k, right_array.get(j));
                j++;
            }
            k++;
        }
        while(i<left_capacity)
        {
            aux.set(k, left_array.get(i));
            i++;
            k++;
        }
        while(j<right_capacity)
        {
            aux.set(k, right_array.get(j));
            j++;
            k++;
        }
    }
    /**
     * recursively calls itself then merge them.
     * @param begin left
     * @param end right
     */
    public void sort(int begin, int end)
    {
        if(begin <end)
        {
            int middle = (begin+end)/2;
            sort(begin,middle);
            sort(middle+1,end);
            merge(begin,middle,end);
        }
    }
    /**
     * get method of aux.
     * @return
     */
    public List<Character> get_aux()
    {
        return aux;
    }
    /**
     * after whole process then it fills sortedmap.
     */
    public void finishing()
    {
        int mapSize= originalMap.get_mapsize();
        int i;
        for(i =0;i<mapSize;i++)
        {
            sortedMap.add(aux.get(i), originalMap.get(aux.get(i)));
        }
    }
}