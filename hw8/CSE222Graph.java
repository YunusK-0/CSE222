import java.util.*;
/**
 * THIS IS FOR GRAPH. IT HAS EDGES INSIDE
 * EDGE CLASS IS INNER CASS
 */
public class CSE222Graph
{
    /**
     * CONTAINS EDGE
     */
    private List<List<Edge>> edges;
    /**
     * X START POSITION
     */
    private int start_x;
    /**
     * Y START POSITION
     */
    private int start_y;
    /**
     * X FINISH POSITION
     */
    private int end_x;
    /**
     * Y FINISH POSITION
     */
    private int end_y;
    /**
     * CONSTRUCTER OF CSE222GRAPH
     */
    public CSE222Graph(CSE222Map map)
    {
        ArrayList<ArrayList<Integer>> auxMap= map.getMap();

        start_x=map.getStart_x();
        start_y=map.getStart_y();
        end_x = map.getEndPosition_x();
        end_y = map.getEndPosition_y();

        edges = new ArrayList<>();
        fill_the_edges(auxMap);
    }
    public CSE222Graph()
    {
        ;
    }

    /**
     * THIS IS A EDGE CLASS WHICH HAS COORDINATION OF SOURCE AND COORDINATION OF DESTINATION.
     * SOURCE_x SOURCE_Y -> DESTINATION_X,DESTINATION_Y
     */
    public class Edge implements Comparable<Edge>
    {
        private int source_x;
        private int source_y;
        private int destination_x;
        private int destination_y;
        private int weight= 214748367;
        public Edge(int for_source_x,int for_source_y, int for_destination_x ,int for_destination_y)
        {
            source_x = for_source_x;
            source_y = for_source_y;

            destination_x = for_destination_x;
            destination_y = for_destination_y;

        }

        @Override
        public int compareTo(Edge a) {
            if (weight < a.weight)
                return -1;
            if (weight > a.weight)
                return 1;
            else {
                if (this.getDest_x() < a.getDest_x())
                    return -1;
                if (this.getDest_x() > a.getDest_x())
                    return 1;
                if (this.getDest_y() < a.getDest_y())
                    return -1;
                if (this.getDest_y() > a.getDest_y())
                    return 1;
                return 0;
            }
        }
        
        public boolean first_equals_y(Edge aux1, Edge aux2)
        {
            int num = aux1.source_y - aux2.destination_y;
            if(num ==0)
                return true;
            return false;

        }
        public boolean equals(Object o)
        {
            Edge aux = (Edge)o;
            if(source_x== aux.source_x &&  source_y == aux.source_y&&destination_x== aux.destination_x && destination_y == aux.destination_y)
                return true;
            return false;
        }
        /**
         * SAMPLE GETTR METHOD
         * @return INTEGER
         */
        public int getDest_x()
        {
            return destination_x;
        }
        /**
         * SAMPLE GETTR METHOD
         * @return INTEGER
         */
        public int getDest_y()
        {
            return destination_y;
        }
        /**
         * SAMPLE GETTR METHOD
         * @return INTEGER
         */
        public int getSource_x()
        {
            return source_x;
        }
        /**
         * SAMPLE GETTR METHOD
         * @return INTEGER
         */
        public int getSource_y()
        {
            return source_y;
        }
        public String toString()
        {
            return "("+source_x+","+source_y+"->"+destination_x+","+destination_y+" WEİGHT="+ weight+")";
        }
        public boolean set_weight(int newWeight)
        {
            if(newWeight<weight)
            {
                weight = newWeight;
                return true;
            }
            return false;
        }
        public int get_weight()
        {
            return weight;
        }
    }
    public void insert(Edge a)
    {
        edges.get(a.getSource_x()).add(a);
    }
    public boolean isEdge(int source,Edge a)
    {
        return edges.get(source).contains(a);
    }
    public Edge getEdge(int source_first,int source_second, int destination_first,int destination_second)
    {
        Edge target = new Edge(source_first,source_second,destination_first,destination_second);
        if(edges.get(source_first).contains(target))
        {
           for(Edge iterate : edges.get(source_first))
           {
                if(iterate.equals(target))
                    return iterate;      
           }
        }
        return null;
    }
    private void fill_the_edges(ArrayList<ArrayList<Integer>> auxMap)
    {
        for(int i =0;i<auxMap.size();i++)
        {
            edges.add(new LinkedList<>());
            for(int j=0;j<auxMap.get(i).size();j++)
            {
                if(auxMap.get(i).get(j) == 0)
                {
                    if(j+1 != auxMap.get(i).size() && auxMap.get(i).get(j+1) ==0)
                    {
                        edges.get(i).add(new Edge(i,j,i,j+1));
                    }
                    if (j-1 >=0 && auxMap.get(i).get(j-1) ==0)
                    {
                        edges.get(i).add(new Edge(i,j,i,j-1));
                    }
                    if (i+1 <auxMap.size() && auxMap.get(i+1).get(j) ==0)
                    {
                        edges.get(i).add(new Edge(i,j,i+1,j));
                        // edges.get(i).add(new Edge (i+1,j,i,j));
                    }
                    if (i-1 >=0 && auxMap.get(i-1).get(j) ==0)
                         edges.get(i).add(new Edge(i,j,i-1,j));
                    if (i+1 <auxMap.size() && j+1<auxMap.get(i+1).size() && auxMap.get(i+1).get(j+1) ==0)
                        edges.get(i).add(new Edge(i,j,i+1,j+1));
                    if (i+1 <auxMap.size() && j-1>=0 &&auxMap.get(i+1).get(j-1) ==0)
                        edges.get(i).add(new Edge(i,j,i+1,j-1));
                    if (i-1 >=0 && j-1>=0 &&auxMap.get(i-1).get(j-1) ==0)
                    {
                        edges.get(i).add(new Edge(i,j,i-1,j-1));
                        
                    }
                    if (i-1 >=0 && j+1<auxMap.get(i-1).size() &&auxMap.get(i-1).get(j+1) ==0)
                    {
                        edges.get(i).add(new Edge(i,j,i-1,j+1));
                    }
                }
            
            }
        }
    }
    /***
     * EDGE GETTR
     * @return
     */
    public List<List<Edge>> getEdges()
    {
        return edges;
    }
    public int first_x()
    {
        return start_x;
    }
    public int first_y()
    {
        return start_y;
    }
    public int second_x()
    {
        return end_x;
    }
    public int second_y()
    {
        return end_y;
    }

}