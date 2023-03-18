package homework1;
/**
 * Every message is a object of the Message class.
 */
public class Message
{
    /**
     * to make every message as a unique one
     */
    public int messageid; 
    /**
     * who send it it gives a integer value and another times it is converted.
     */
    public int senderid;
    /**
     * the receiver of the message like 'senderid' this is also converted
     */
    public int receiverid;
    /**
     * this is string that has the message.
     */
    public String content;
    /**
     * This is message class it send a message to outbox and inbox.
     * @param id to specife id of the message
     * @param s_id sender id
     * @param r_id receiver id
     * @param temp_content message it is as a string
     */
    public Message(int id,int s_id,int r_id,String temp_content)
    {
        messageid = id;
        senderid = s_id;
        receiverid = r_id;
        content = temp_content;
    }
    /**
     * To determine who send the message and who get the message it uses senderid and receiverid
     */
    public void messagebox()
    {
        System.out.println("Message ID= "+messageid);
        if(senderid==0)
            System.out.println("From: Sibel Gulmez");
        else if (senderid==1)
            System.out.println("From: Gokhan Kaya");
        else if(senderid ==2)
            System.out.println("From: Gizem Sungu");
        if(receiverid==0)
            System.out.println("to:: Sibel Gulmez");
        else if (receiverid==1)
            System.out.println("to: Gokhan Kaya");
        else if(receiverid ==2)
            System.out.println("to: Gizem Sungu");
        System.out.println("Message = "+content);
    }
}