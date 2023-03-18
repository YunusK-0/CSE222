package homework1;
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
     * it is array for who liked a post
     */
    private String[] likes;
    /**
     * Number of the likes.
     */
    private int NumofLikes;
    /**
     * it containts comments on a post
     */
    private String[] comments;
    /**
     * it counts number of the comments
     */
    private int NumofComments;
    /**
     * who did a comment on a post.
     */
    private String[] WhoComments;
    /**
     * it counts who did the comment
     */
    private int who_counter;
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
        comments = new String[10];
        likes = new String[10];
        WhoComments = new String[10];
        NumofLikes =0;
        NumofComments = 0;
        who_counter =0;
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
        if(NumofLikes >0)
            System.out.println("Post was liked by ");
        for(int i=0;i<NumofLikes;i++)
            System.out.println(likes[i]);
        
    }
    /**
     * callers likes a post of the parameter one
     * @param obj this is account of the be liked
     * @throws ArrayIndexOutOfBoundsException it throws exception if number of likes drops below to zero
     */
    public void WasLiked(Account obj) throws ArrayIndexOutOfBoundsException
    {
        System.out.println(NumofLikes);
        try
        {
            if(NumofLikes >=0)
                likes[NumofLikes] = obj.get_username();
            else
                throw new ArrayIndexOutOfBoundsException("Less than zero");
            NumofLikes++;
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
        WhoComments[who_counter] = commenter.get_username();
        comments[NumofComments] = itsIdea.get_content();
        who_counter++;
        NumofComments++;
    }
    /**
     * it gives you detaile information about comments for the post.
     * owner of the post how to call it.
     */
    public void see_comments()
    {
        if(who_counter>0)
        System.out.println("Comment by ");
        for(int i =0;i<who_counter;i++)
            System.out.println("Comment "+i +": "+WhoComments[i]+ " said "+ comments[i]);
        if(who_counter==0)
            System.out.println("Comment by nobody");
    }
    
}