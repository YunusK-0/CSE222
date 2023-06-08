import java.util.*;
import java.io.IOException;
public class TestClass
{
    /**
     * it takes 10 hours for djikstra algorihm but it takes 5 seconds for bfs algorihm.!!!
     * @param args
     */
    public static void main(String[] args) {
        String inputFile= "map03.txt";
        CSE222Map map = new CSE222Map(inputFile);
        CSE222Graph graph = new CSE222Graph(map);
        CSE222Dijkstra dijkstra = new CSE222Dijkstra(graph);
        ArrayList<Integer> dijkstras_path = dijkstra.findPath();
        CSE222BFS bfs = new CSE222BFS(graph);
        ArrayList<Integer> BFSPath =  bfs.findPath();
        try
        {
            map.convertPNG();
            map.drawLine(dijkstras_path);
         }catch(IOException yunus)
         {
           System.out.println(yunus);
         }
        try
        {
            map.convertPNG();
            map.drawLine(BFSPath);
            map.writePath(BFSPath);
        }catch(IOException yunus)
        {
            System.out.println(yunus);
        }
        try
        {
            map.writePath(dijkstras_path);
        }catch(IOException yunus)
        {
            System.out.println(yunus);
        }
                ystem.out.println("Dijkstra path=>" + dijkstras_path);
        System.out.println("BFSPATH = "+ BFSPath);
    }
}