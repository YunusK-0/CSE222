import java.util.*;
/**
 * this is implements bfs algorithm by me.
 */
public class CSE222BFS {

    private List<List<CSE222Graph.Edge>> edges;
    private int start_x;
    private int start_y;
    private int end_x;
    private int end_y;
    private int[][][] path_x;
    private boolean[][] marked;

    private int[][] distance;
    /**
     * consturcter of bfs algorithm
     * initiliaze members
     * @param graph
     */
    public CSE222BFS(CSE222Graph graph)
    {
        edges = graph.getEdges();
        start_x= graph.first_x();
        start_y = graph.first_y();
        end_x= graph.second_x();
        end_y=graph.second_y();
        distance = new int[1000][1000];
        path_x = new int[1000][1000][2];
        marked = new boolean[1000][1000];
        init_marked();
        set_start_weight_zero();
        fill_path_field();
        findPath();
    }
    /**
     * the same as dijkstra class
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
    private void init_marked()
    {
        for(int i =0;i<1000;i++)
        {
            for(int j= 0;j<1000;j++)
            {
                marked[i][j] = false;
            }
        }
    }
    /**
     * find the feasable path for bfs algorithm
     * @return arraylist<Int> for the path
     */
    public ArrayList<Integer> findPath()
    {
        System.out.println("bfs !!!!********************");
        Queue<CSE222Graph.Edge> stock = new LinkedList<>();
        CSE222Graph temp = new CSE222Graph();
        CSE222Graph.Edge start_vertex = temp.new Edge(start_x, start_y, end_x, end_y);
        CSE222Graph.Edge currentedge = edges.get(start_x).get(find_changed_source(start_vertex));
        currentedge.set_weight(1);
        System.out.println("currreennttt ===> "+ currentedge);
        distance[currentedge.getSource_x()][currentedge.getSource_y()] =1;
        int i =0;
        int temp_weight = Integer.MAX_VALUE;
        stock.add(currentedge);
        marked[currentedge.getSource_x()][currentedge.getSource_y()] =true;
        while(!stock.isEmpty())
        {
            currentedge = stock.poll();
            if(currentedge.getSource_x() == end_x && currentedge.getSource_y() ==end_y)
            {
                break;
            }
            for(CSE222Graph.Edge iterate : edges.get(currentedge.getSource_x()))
            {
                if(iterate.getSource_y() == currentedge.getSource_y() && marked[iterate.getDest_x()][iterate.getDest_y()] == false)
                {
                    for(CSE222Graph.Edge aux: edges.get(iterate.getDest_x()))
                    {
                        if(aux.getSource_y() == iterate.getDest_y())
                        {
                            path_x[iterate.getDest_x()][iterate.getDest_y()][0] = iterate.getSource_x();
                            path_x[iterate.getDest_x()][iterate.getDest_y()][1] = iterate.getSource_y();

                            stock.add(aux);
                        }
                    }
                    marked[iterate.getDest_x()][iterate.getDest_y()] = true;
                }
            }
            marked[currentedge.getSource_x()][currentedge.getSource_y()] =true;

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
    /**
     * this is for me printing after that i change it for return arraylist.
     * @return
     */
    private ArrayList<Integer> print_path()
    {

        int aux_x=end_x;
        int aux_y=end_y;
        int temp_x = aux_x;
        int temp_y = aux_y;
        int i=0;
        ArrayList<Integer> return_val = new ArrayList<Integer>();
        CSE222Graph yunus=new CSE222Graph();
        while(!(aux_x == start_x && aux_y  == start_y))
        {

            return_val.add(aux_x);
            return_val.add(aux_y);
           temp_x= path_x[aux_x][aux_y][0];
           aux_y= path_x[aux_x][aux_y][1];
            i++;
            aux_x=temp_x;
        }
        System.out.println(aux_x +","+aux_y);
        return_val.add(aux_x);
        return_val.add(aux_y);
        return return_val;
    }
    

}

