/**
 * Comment class extend interaction.
 */
public class Comment extends Interaction
{
    private String content;
    /**
     * Constructer of Comment class with 4 parameters.
     * @param id special interaction id
     * @param acc_id which account did the interaction
     * @param p_id which post did the interaction
     * @param discussion the commemnt that was done by an account
     * 
     */
    public Comment(int id,int acc_id,int p_id,String discussion)
    {
        super(id,acc_id,p_id);
        content = discussion;
    }
    /**
     * Gettr method for postid
     * @return return an integer thats is id of the specified post.
     */
    public int get_postid()
    {
        return postid;
    }
    /**
     * Gettr method for comment on the post.
     * @return return string that is comment by the account on the post.
     */
    public String get_content()
    {
        return content;
    }
}