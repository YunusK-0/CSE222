import javax.swing.text.Style;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import javax.swing.*;
/**
 * Constructer of gui 
 * That includes part-A in pdf such as root tree jtree fiels
 * then it includes queue for storage for moving for node.
 */
public class Gui
{
    /**
     * for the last part of jtree
     */
    private JTree tree;
    /**
     * it is used with "tree" variable
     */
    private DefaultMutableTreeNode root;
    /**
     * tree root and jf are used together.
     */
    private JFrame jf;
    /**
     * this is for getting data from txt to tree
     */
    private String[][] array;
    /**
     * constant values of initilizating 2D String array.
     */
    final private int col =1;
    /**
     * constant values of initilizating 2D String array.
     */
    final private int row=1;
    /**
     * this is for partE and it contains which node is going to be moved.
     */
    private String[] source;
    /**
     * this is for the part-A
     */
    private JTree son_part;
    private JFrame jf2;
    private DefaultMutableTreeNode last_root;
    /**
     * it contains childirend of the nodes which is going to be moved.
     */
    private Queue<DefaultMutableTreeNode> storage = new LinkedList<>();
    /**
     * init. gui 
     * init. roots
     * init frame
     */
    public Gui()
    {
        array = new String[col][row];
        root = new DefaultMutableTreeNode("root");
        last_root =new DefaultMutableTreeNode("First root");
        read_file();
        source = new String[row];
        //jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fill_tree_with_array();
    }
/**
 * this is post order method it has an helper 
 * algorithm is simple it goes down with recursively.
 * @param inputstring
 */
public void post_order(String inputstring)
{
    boolean res;
    DefaultMutableTreeNode temp = root;
    res = post_order(temp,inputstring);
    if(!res)
        System.out.println("Not found !!");
}
/**
 * helper method of post order.
 * @param temp current node
 * @param inputstring which is being searched.
 * @return
 */
private boolean post_order(DefaultMutableTreeNode temp, String inputstring)
{
    for(int i =0;i<temp.getChildCount();i++)
    {
        if(post_order((DefaultMutableTreeNode)temp.getChildAt(i), inputstring))
        {
            System.out.print(temp);
            return true;
        }
    }
    System.out.println(temp);
    if(temp.toString().equals(inputstring.toString()))
    {
        System.out.println( "founded!!");
        return true;
    }
    return false;
}
/**
 * it takes data from array to tree
 * simply position of current node is changed by find_target method.
 * then it adds to the position.
 */
private void fill_tree_with_array()
{
    DefaultMutableTreeNode temp = root;
    DefaultMutableTreeNode last_temp = last_root;
    int pos=-5;
    int k=0;
    boolean flag=false;
    boolean flag2=false;
    DefaultMutableTreeNode x_temp=root;
    for(int i=0;i<array.length;i++,k=0)
    {
        temp =root;
        last_temp = last_root;
        for(int j=0; j< array[i].length;j++, flag=false,k=0)
        {
            if( array[i][j] !=null&&array[i][j].length()!=0)
            {
                if(root.getChildCount() ==0)
                {
                    root.add(new DefaultMutableTreeNode(array[i][j]));
                    last_root.add(new DefaultMutableTreeNode(array[i][j]));
                }
                else
                {
                    if(find_target(temp, array[i][j])==null)
                    {
                        temp.add(new DefaultMutableTreeNode(array[i][j]));
                        last_temp.add(new DefaultMutableTreeNode(array[i][j]));
                        if(find_target(temp, array[i][j]) != null)
                        {
                            temp = find_target(temp, array[i][j]);
                            last_temp = find_target(last_temp, array[i][j]);
                        }
                        else
                        {
                            temp=root.getLastLeaf();
                            last_temp=last_root.getLastLeaf();
                        }
                        flag2=true;
                    }
                    else
                    {   
                        if (find_target(temp,array[i][j]).toString().equals(array[i][j]))
                        {
                            temp= find_target(temp, array[i][j]);
                            last_temp =find_target(last_temp, array[i][j]);
                            flag2=true;
                        }
                        else if (find_target(temp,array[i][j]).toString().equals(array[i][j]) & temp.toString().equals(array[i][j]))
                        {
                            temp= find_target(temp, array[i][j]);
                            last_temp =find_target(last_temp, array[i][j]);
                            flag2=true;
                        }
                        else
                        {
                        temp= find_target(temp, array[i][j]);
                        last_temp =find_target(last_temp, array[i][j]);
                        temp.add(new DefaultMutableTreeNode(array[i][j]));
                        last_temp.add(new DefaultMutableTreeNode(array[i][j]));
                        temp=temp.getNextNode();    
                        last_temp =last_temp.getNextNode(); 
                        flag2=true;      
                        }
                    }             
                }
            
                if(temp.getNextNode() != null && flag2!=true)
                        temp=temp.getNextNode();
                if(last_temp.getNextNode() != null && flag2!=true)
                        last_temp=last_temp.getNextNode();
            }
        }
        flag2=false;
    }
    last_gui();
}
/**
 * it search children of the given node 
 * @param temp current node
 * @param name the value that is being search.
 * @return return node if it is exist. else not. if it has no child it gives itself.
 */
private DefaultMutableTreeNode find_target(DefaultMutableTreeNode temp, String name)
{
    DefaultMutableTreeNode temp2=temp;
    if(temp.getChildCount()==0)
        return temp;
    else if (temp.toString().equals(name))
        return temp;
    else
    {
       int i=0;
       while(i<temp.getChildCount())
       {
            if(temp.getChildAt(i).toString().equals(name))
                return (DefaultMutableTreeNode)temp.getChildAt(i);
            i++;
       }
    }
    return null;

}
/**
 * it is not recursive algorithm it uses queue for breadfirst searching.
 * @param inputString the data which is being searched.
 */
public void bfs(String inputString)
{
    DefaultMutableTreeNode temp = root;
    Queue<DefaultMutableTreeNode> low_level = new LinkedList<DefaultMutableTreeNode>();
    DefaultMutableTreeNode temp2 = root;
    boolean flag=false;
    int i=0;
    int k=0;
    System.out.println(i);
    low_level.add(root);
    while(!low_level.isEmpty())
    {   temp2=low_level.poll();
        if(temp2.toString().equals(inputString.toString()))
        {
            System.out.println(i+". " +temp2+ "found!!!!");
            flag=true;
            break;
        }
        System.out.println(i+"."+ temp2);
        for(int j=0;j<temp2.getChildCount();j++)
            low_level.add((DefaultMutableTreeNode)temp2.getChildAt(j));
        i++;
    }
    if(!flag)
        System.out.println("not found!!!");
}
/**
 * it uses recursive search algorithm
 * @param inpuString data is being search.
 */
public void dfs(String inpuString)
{
    boolean flag;
    DefaultMutableTreeNode temp = root;
    flag= dfs(temp,inpuString);
    if(!flag)
        System.out.println("not found!!!");
}
/**
 * helper method of dfs.
 * @param temp current node
 * @param inpuString data which is being searched
 * @return true if it exist.
 */
private boolean dfs(DefaultMutableTreeNode temp,String inpuString)
{
    if(temp.toString().equals(inpuString.toString()))
    {
        System.out.println(temp+ "!!found!!!");
        return true;
    }
    else 
        System.out.println(temp);
    for(int i =temp.getChildCount()-1;i>=0;i--)
    {
        if(temp.getChildCount() !=0)
        {
           if(dfs((DefaultMutableTreeNode)temp.getChildAt(i),inpuString))
                return true;
        }
        
    }
    return false;
}
/**
 * it takes data from file to array.
 */
private void read_file()
{
    File file = new File("tree.txt");
    try 
    {
        Scanner read = new Scanner(file);
        int i=0;
        String temp_string;
        while(read.hasNextLine())
        {
            if(i==array.length)
                col_reallocation();
            temp_string = read.nextLine();
            split(temp_string,i);
            i++;
        }
        read.close();
    }catch(FileNotFoundException e)
    {
        System.out.println(e);
    }
}
/**
 * it splits data which is in txt file.
 * @param temp_string data which is going to be splited.
 * @param pos position of the current cursor.
 */
    private void split(String temp_string, int pos)
    {
        int k=0;
        
        int i=0;
        int j=0;
        int temp_i=0;
        for(;i<temp_string.length();i++)
        {
            for(j=i;j<temp_string.length();j++)
            {
                if(temp_string.charAt(j) == ';' )
                {
                    if(k == array[pos].length)
                        row_reallocation(pos);
                    
                    array[pos][k] = temp_string.substring(i, j);
                    k++;
                    i =j+1;
                    temp_i =i;
                }
                
            }
        }
        if(k ==array[pos].length)
            row_reallocation(pos);
        array[pos][k] = temp_string.substring(temp_i,j );
    }
    /**
     * row reallocation for array which includes data from txt.is done here 
     * @param pos which row is going to be increase.
     */
    private void row_reallocation(int pos)
    {
        String [][] new_array = array;
        array = new String [array.length][];
        for(int i=0;i<new_array.length;i++)
        {
            if(i == pos)
                array[i] = new String [new_array[i].length+1];
            else 
                array[i] = new String[new_array[i].length];
        }
        copy_data(new_array);
    }
    /**
     * row reallocation for array which includes data from txt.is done here 
     */
    private void col_reallocation()
    {
        int i=0;
        String [][] new_array = array;
        array = new String [array.length+1][];
        for(; i<new_array.length;i++)
            array[i] = new String [new_array[i].length]; 
        array[i] = new String [2];
        copy_data(new_array);
    }
    /**
     * copy data from 2D String array to another.
     * @param new_array temp array.
     */
    private void copy_data(String [][]new_array)
    {
        for(int i=0;i<new_array.length;i++)
        {
            for(int j=0;j<new_array[i].length;j++)
                array[i][j] = new_array[i][j];
        }
    }
    /**
     * this part is for removing data.
     * @param inputString input which is our source
     * @param destination destination it means location.
     */
    public void last_part(String inputString,String destination)
    {
        split(inputString);
        DefaultMutableTreeNode target=root;
        boolean res= false;
        res =last_part_check_input(inputString, destination);
        if(boyle_bir_cocuk(target, destination) ==null)
            target.add(new DefaultMutableTreeNode(destination));
        if(res !=false )
        {
            if(has_children())
            {
                fill_queue();
                target=find_target(root, destination);
                add_new_position(target);
            }
            else
            {
                fill_queue();
                target = find_target(root, destination);
                add_new_position(target);
            }
        }
        tree = new JTree(root);
        jf = new JFrame();
        jf.setSize(700,700);
        jf.setLayout(jf.getLayout());
        jf.setVisible(true);
        jf.add(tree);

    }
    /**
     * it checks it is exist or not
     * @param inputString source input
     * @param destination destination input
     * @return
     */
    private boolean last_part_check_input(String inputString,String destination)
    {
        DefaultMutableTreeNode temp= root;
        DefaultMutableTreeNode new_data = root;
        for(int i=0;i<source.length;i++)
        {
            new_data=temp;
            temp = find_target(temp, source[i]);
            if(temp == null)
            {
                System.out.println("Connot move"+inputString+" it doesn't exist");
                return false;
            }
        }
        return true;
    }
    /**
     * its only for filling the queue it also removes data from tree
     */
    private void fill_queue()
    {
        DefaultMutableTreeNode current = root;
        DefaultMutableTreeNode  temp = root;
        for(int i =0;i<source.length;i++)
        {
            current = find_target(current, source[i]);
            storage.add(current);
            if(current.getChildCount()  ==0)
                ((DefaultMutableTreeNode)current.getParent()).remove(current);
            else if( i+1< source.length&&current.getChildCount() ==1  && (current.getChildAt(0).toString().equals(source[i+1])))
                ((DefaultMutableTreeNode)current.getParent()).remove(current);
            if(i+1 == source.length && current.getChildCount() !=0)
            {
                for(int c= 0;c <current.getChildCount();c++)
                {
                    temp = (DefaultMutableTreeNode)current.getChildAt(c);
                    for(int j=0;j<temp.getChildCount();j++)
                    {
                        storage.add((DefaultMutableTreeNode)temp.getChildAt(j));
                        //((DefaultMutableTreeNode)temp.getParent()).remove(temp);
                        temp.remove((DefaultMutableTreeNode)temp.getChildAt(j));
                    }
                }

            }

        }
    }
    /**
     * this method for do you have that child?
     * @param temp current node.
     * @param name value of child
     * @return node if it is exist
     */
    private DefaultMutableTreeNode boyle_bir_cocuk(DefaultMutableTreeNode temp, String name)
    {
        if(temp.getChildCount()==0)
            return null;
        else if (temp.toString().equals(name))
            return temp;
        else
        {
           int i=0;
           while(i<temp.getChildCount())
           {
                if(temp.getChildAt(i).toString().equals(name))
                    return (DefaultMutableTreeNode)temp.getChildAt(i);
                i++;
           }
        }
        return null;
    
    }
    /**
     * it adds new position.
     * @param target destination location.
     */
    private void add_new_position(DefaultMutableTreeNode target)
    {
        storage.poll();
        DefaultMutableTreeNode temp =root;
        int count =0;
        while(storage.size()>0)
        {
            temp = storage.poll();
            if(boyle_bir_cocuk(target,temp.toString() ) !=null)
            {
                target = find_target(target, temp.toString());
                count++;
            }
            else
            {
                target.add(temp);
                target = find_target(target, temp.toString());
            }
        }
        if(count ==source.length-1)
            System.out.println("Overwritten happend!!!");
    }
    /**
     * this for partE it determines the node has children or not.
     */
    private boolean has_children()
    {
        DefaultMutableTreeNode current = root;
        for(int i =0;i<source.length;i++)
        {
            current = find_target(current, source[i]);
        }
        if(current.getChildCount() ==0)
            return false;
        return true;

    }
    /**
     * split data for parte
     * @param inputString input
     */
    private void split(String inputString)
    {
        int k=0;
        int i;
        int j=0;
        int temp_i=0;
        for(i=0;i<inputString.length();i++)
        {
            for(j=i;j<inputString.length();j++)
            {
                if(inputString.charAt(j) == '-')
                {
                    if(k==source.length)
                        reallocation();
                    source[k] = inputString.substring(i, j);
                    i = j+2;
                    temp_i =i;
                    k++;
                }
            }
        }
        if(k == source.length)
            reallocation();
        source[k] =inputString.substring(temp_i,j);
    }
    /**
     * reallocation for partE array.
     */
    private void reallocation()
    {
        String[] temp= source;
        source = new String[source.length+1];
        for(int i=0;i<temp.length;i++)
            source[i] = temp[i];
    }
    /**
     * printing first window.
     */
    private void last_gui()
    {
        DefaultMutableTreeNode current=root;
        DefaultMutableTreeNode last_current = last_root;
        jf2 = new JFrame();
        jf2.setSize(700,700);
        jf2.setLayout(jf2.getLayout());
        jf2.setVisible(true);
        son_part = new JTree(last_root);
        jf2.add(son_part);
    }
}