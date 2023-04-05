import java.util.LinkedList;
import java.util.Iterator;

//import javax.lang.model.util.ElementScanner14;
/**
 * ever post is a object of the post class. it has post id , account id, number of likes... etc...
 */
public class Post
{
    /**
     * it starts from 1 for every account. when they share a post then it is increase
     */
    private int postid ;
    /**
     * it contains one the people who did the first interaction
     */
    private int accountid ;
    /**
     * it is linkedlist for who liked a post
     */
    private LinkedList<String> likes;
    /**
     * it containts comments on a post
     */
    private LinkedList<String> comments;
    /**
     * who did a comment on a post.
     */
    private LinkedList<String> WhoComments;
    /**
     * detail of the post this for who shared the post.
     */
    private String content;
    /**
     * Every post is object of the Post classes.
     * It includes number of the likes who liked it. Number of the comments and who says what.
     * @param id post id
     * @param ac_id account id who did the interaction.
     * @param temp_like who liked when it was created
     * @param temp_comment it is for put a comment when constructer. Otherwise leave it empty.
     * @param temp_content 
     */
    public Post(int id,int ac_id,String temp_like,String temp_comment, String temp_content)
    {
        postid = id;
        accountid = ac_id;
        content = temp_content;
        comments = new LinkedList<String>();
        likes = new LinkedList<String>();
        WhoComments = new LinkedList<String>();
    }
    /**
     * Empty constructer this is for test case.
     */
    public Post()
    {
        ;
    }
    /**
     * it gives information about post id and account id who did the interaction on the post.
     */
    public void DetailofPosts()
    {
        System.out.println("Post id= "+postid+ "\n account id = "+accountid);

    }
    /**
     * gettr method for post id
     * @return int as a post id
     */
    public int get_postid()
    {
        return postid;
    }
    /**
     * gettr method for account id 
     * @return return int thats account id
     */
    public int get_accountid()
    {
        return accountid;
    }
    /**
     * it is gettr method for content of the post.
     * Content is what creater says on its post.
     * @return string for content.
     */
    public String get_content()
    {
        return content;
    }
    /**
     * it gives information who liked the specified post.
     */
    public void see_likes()
    {
        System.out.println("----------");
        System.out.println("Post id= "+postid+" content: "+content);
        Iterator<String> temp_iter = likes.iterator();
        if(likes.size() >0)
            System.out.println("Post was liked by ");
        //for(int i=0;i<likes.size();i++)
        //    System.out.println(likes[i]);
        while(temp_iter.hasNext())
            System.out.println(temp_iter.next());
        
    }
    /**
     * callers likes a post of the parameter one
     * @param obj this is account of the be liked
     * @throws ArrayIndexOutOfBoundsException it throws exception if number of likes drops below to zero
     */
    public void WasLiked(Account obj) throws ArrayIndexOutOfBoundsException
    {
        System.out.println(likes.size());
        try
        {
            if(likes.size() >=0)
                likes.add(obj.get_username());
            else
                throw new ArrayIndexOutOfBoundsException("Less than zero");
            likes.size();
        }catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println(e);
        }
    }
    /**
     * callers dislikes a post of the parameter one
     * @param obj this is account who dislike
     * @throws ArrayIndexOutOfBoundsException it throws exception if number of likes drops below to zero
     */
    public void wasDisliking(Account obj) throws ArrayIndexOutOfBoundsException
    {
        try
        {
            if(likes.size() >=0)
                likes.remove(obj.get_username());
            else
                throw new ArrayIndexOutOfBoundsException("Less than zero");
            likes.size();
        }catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println(e);
        }
    }
    /**
     * For making a comments this method is calling.
     * owner of the posts call this methods.
     * @param commenter who comments the post
     * @param itsIdea his/her comments as a parameter.
     */
    public void commented(Account commenter, Comment itsIdea)
    {
        WhoComments.add(commenter.get_username());
        comments.add(itsIdea.get_content());
    }
    /**
     * For making a comments this method is calling.
     * owner of the posts call this methods.
     * @param commenter who comments the post
     * @param itsIdea his/her comments as a parameter.
     */
    public void uncommented(Account commenter, Comment itsIdea)
    {
        WhoComments.remove(commenter.get_username());
        comments.remove(itsIdea.get_content());
    }
    /**
     * it gives you detaile information about comments for the post.
     * owner of the post how to call it.
     */
    public void see_comments()
    {
        Iterator temp_iter = comments.iterator();
        Iterator temp_two = WhoComments.iterator();
        if(WhoComments.size()>0)
        System.out.println("Comment by ");
        for(int i=0;temp_iter.hasNext() && temp_two.hasNext();i++ )
            System.out.println("Comment "+i+": " +temp_two.next()+ " said "+ temp_iter.next());
        if(WhoComments.size()==0)
            System.out.println("Comment by nobody");
    }
    
    public String toString()
    {
        return content;
    }
}