/**
 * This is for liking a posts it inherits Interaction class.
 */
public class Like extends Interaction
{
    /**
     * This is consturcter of Like class it calls constructer of the Interaction.
     * @param id interaction id.
     * @param acc_id account id
     * @param p_id which post is gonna be liked.
     */
    Like(int id, int acc_id,int p_id)
    {
        super(id,acc_id,p_id);
    }
    int get_postid()
    {
        return postid;
    }
}