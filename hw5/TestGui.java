import java.util.Scanner;

public class TestGui
{
    public static void main(String[] args) {
        Gui a = new Gui();
        //a.read_file();
        //a.read_array();
        Scanner scan = new Scanner (System.in);
        System.out.println("Give an NODE for bfs");
        String inputString  = scan.nextLine();
        a.bfs(inputString);
        System.out.println("give an node for dfs");
        inputString = scan.nextLine();
        a.dfs(inputString);
        System.out.println("give an node for post order ");
        inputString = scan.nextLine();
        a.post_order(inputString);
        System.out.println("give a node that is going to be moved.");
        //System.out.println(inputString);
        inputString = scan.nextLine();
        System.out.println("destination.");
        String destination = scan.nextLine();
        a.last_part(inputString,destination);


        int a=9;
        int b=16;
        System.out.println(a+b^1/2);
    }
}