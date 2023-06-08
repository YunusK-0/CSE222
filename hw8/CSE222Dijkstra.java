import java.util.*;

import javax.print.attribute.standard.Destination;
import javax.xml.transform.Source;
/**
 * THIS CLASS IMPLEMENTS DIJSKTRA ALGORITHM IT TAKES 10 HOURS FOR 500*500 MAP!!!!!!!
 */
public class CSE222Dijkstra 
{
    /**
     * THAT CONTAINS EDGES WHOLE EDGES
     */
    private List<List<CSE222Graph.Edge>> edges;
    /**
     * SAME
     */
    private int start_x;
    /**
     * SAME
     */
    private int start_y;
    private int end_x;
    private int end_y;
    /**
     * PARENT ARRAY...
     */
    private int[][][] path_x;
    private List<List<Boolean>> marked;

    private int[][] distance;
    /**
     * CONSTURCTER
     * @param graph INITIALIZE.
     */
    public CSE222Dijkstra(CSE222Graph graph)
    {
        edges = graph.getEdges();
        start_x= graph.first_x();
        start_y = graph.first_y();
        end_x= graph.second_x();
        end_y=graph.second_y();
        distance = new int[1000][1000];
        path_x = new int[1000][1000][2];
        init_marked();
        set_start_weight_zero();
        fill_path_field();
        findPath();
    }
    /**
     * INITIALIZE THE WEIGHT
     */
    private void set_start_weight_zero()
    {
        for(int y =0;y<edges.get(start_x).size();y++)
        {
            Iterator<CSE222Graph.Edge> yunus = edges.get(start_x).iterator();
            for(int i=0;i<edges.size();i++)
            {
                for(CSE222Graph.Edge iterate : edges.get(i)) 
                {
                    if(iterate.getSource_x() == start_x && iterate.getSource_y() == start_y)
                        iterate.set_weight(1);
                    else if (iterate.getDest_x() == start_x && iterate.getDest_y() == start_y)
                        iterate.set_weight(1);


                }
            }      
        }
    }
    /**
     * STARTS MARKS FALSE
     */
    private void init_marked()
    {
        marked = new ArrayList<>(edges.size());
        for(int i =0;i<edges.size();i++)
        {
            marked.add(new ArrayList<>(edges.get(i).size()));
        }
        for(int i =0;i<edges.size();i++)
        {
            for(int j= 0;j<edges.get(i).size();j++)
            {
                marked.get(i).add(false);
            }
        }
    }
    /**
     * DIJKSTRA ALGORIHM IMPLEMENTED IN HERE
     * @return
     */
    public ArrayList<Integer> findPath()
    {
        HashSet<CSE222Graph.Edge> stock = new HashSet<CSE222Graph.Edge>();
        for(int i =0;i<edges.size();i++)
        {
            for(CSE222Graph.Edge iterate : edges.get(i))
            {
                if(!stock.contains(iterate) && (iterate.getSource_x() != start_x || edges.get(i).get(find_changed_source(iterate)).getSource_y()  != start_y ))
                {
                    stock.add(iterate);
                }
            }
        }
        CSE222Graph temp = new CSE222Graph();
        CSE222Graph.Edge currentedge = edges.get(start_x).get(0);
        currentedge.set_weight(1);
        distance[currentedge.getSource_x()][currentedge.getSource_y()] =1;
        CSE222Graph.Edge prev ;
        int i =0;
        int temp_weight = Integer.MAX_VALUE;
        while(!stock.isEmpty())
        {
            temp_weight = Integer.MAX_VALUE;
            if( i != 0)
            {
                prev = currentedge;
                for(CSE222Graph.Edge iterate : stock)
                {
                    if(distance[iterate.getSource_x()][iterate.getSource_y()] < temp_weight)
                    {
                        temp_weight = distance[iterate.getSource_x()][iterate.getSource_y()];
                        currentedge = iterate;
                    }
                }
                stock.remove(currentedge);
                
            }
            for(CSE222Graph.Edge iterate : edges.get(currentedge.getSource_x()))
            {
               
                if( iterate.getSource_y() == currentedge.getSource_y() )
                {
                    if( distance[iterate.getDest_x()][iterate.getDest_y()] >1 +  distance[currentedge.getSource_x()][currentedge.getSource_y()])
                    {
                        path_x[iterate.getDest_x()][iterate.getDest_y()][0] = currentedge.getSource_x();
                        path_x[iterate.getDest_x()][iterate.getDest_y()][1] = currentedge.getSource_y();
                        distance[iterate.getDest_x()][iterate.getDest_y()] = 1 + distance[currentedge.getSource_x()][currentedge.getSource_y()];
                        
                    }
                    
                    
                }
                
            }
            i++;
        }
        return print_path();


    }
    private int find_changed_source(CSE222Graph.Edge temp)
    {
        int i =0;
        for(CSE222Graph.Edge yunus : edges.get(temp.getSource_x()))
        {
            if(yunus.getSource_y() == temp.getSource_y())
            {
                return i ;
            }
            i++;
        }
        return -1;
    }
    private int find_changed_destination(CSE222Graph.Edge temp)
    {
        int i =0;
        for(CSE222Graph.Edge yunus : edges.get(temp.getSource_x()))
        {
            
            if(yunus.getDest_y() == temp.getDest_y())
                return i ;
            i++;
        }
        return -1;
    }
    private void fill_path_field()
    {
        for(int i =0;i<1000;i++)
        {
            for(int j=0;j<1000;j++)
            {
                for(int k=0;k<2;k++)
                    path_x[i][j][k] = -1;
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
    }
    private ArrayList<Integer> print_path()
    {

        int aux_x=end_x;
        int aux_y=end_y;
        int temp_x = aux_x;
        int temp_y = aux_y;
        ArrayList<Integer> return_val = new ArrayList<Integer>();
        CSE222Graph yunus=new CSE222Graph();
        while(!(aux_x == start_x && aux_y  == start_y))
        {
            return_val.add(aux_x);
            return_val.add(aux_y);
           temp_x= path_x[aux_x][aux_y][0];
           aux_y= path_x[aux_x][aux_y][1];

            aux_x=temp_x;
        }
        System.out.println(aux_x +","+aux_y);
        return_val.add(aux_x);
        return_val.add(aux_y);
        return return_val;
    }
    

}