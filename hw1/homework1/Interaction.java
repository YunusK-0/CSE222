package homework1;
/**
 * this is base class for like and comment.
 */
public class Interaction
{
    /**
     * this is make every interaction specific
     */
    protected int interactionid;
    /**
     * who interacted 
     */
    protected int accountid;
    /**
     * which post has a interaction. Because every account has its specific postid.
     */
    protected int postid;
    /**
     * This is superclass for Like and Comment class
     * it includes interaction id , account id, post,id
     * @param id interaction id 
     * @param acc_id account id
     * @param p_id post id
     */
    public Interaction(int id,int acc_id,int p_id)
    {
        interactionid =id;
        accountid = acc_id;
        postid = p_id;
    }
}