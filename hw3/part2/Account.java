import java.util.LinkedList;
import java.util.Iterator;

/**
 * This is Account class it has relation with Post Message Interaction classses.
 */
public class Account
{
    /**
     * every account has unique account id
     */
    private int accountid;
    /**
     * username of the account
     */
    private String username;
    private String birthdate;
    private String location;
    private LinkedList<String> following = new LinkedList<String>();
    private LinkedList<String> followers = new LinkedList<String>();
    /**
     * this is checks if a account is login or not it is automatically true with login function.
     * and it is false automatically when logout function is called
     */
    private boolean is_login = false;
    private LinkedList<Post> posts = new LinkedList<Post>();
    private LinkedList<Message> inbox;
    private LinkedList<Message> outbox;
    /**
     * what have happened by this account.
     */
    private LinkedList<String> history = new LinkedList<String>();
    /**
     * There is a field that determines if user login or not.
     * @return return type is boolean if is_login true then return true. else false
     */
    public boolean login()
    {
        if(is_login == false)
        {
            is_login =true;
            System.out.println(username +" logging in");
            history.add("You logged in");
            return true;
        }
        else
            return false;
    }
    /**
     * the account was blocked by.
     */
    private LinkedList<String> BlockedBy;
    /**
     * part3 is done here
     * @param obj was blocked account it is.
     * 
     */
    public void BlockIt(Account obj)
    {
        System.out.println(username+" has just blocked "+obj.username);
        history.add(new String("You blocked "+ obj.username));
        obj.BlockedBy.add(this.username);
        this.followers.remove(obj.username);
        obj.following.remove(this.username);
    }
    /**
     * Unblocking section is here. Just a casual Social media after unblocking they are not following each other or one of them to another.
     */
    public void unblock(Account obj)
    {
        if(is_login==true && obj.BlockedBy.size() >0)
        {
            history.add(new String("You unblocked "+ obj.username));
            obj.BlockedBy.remove(this.username);
        }
        else
            System.out.println("Unblocking didn't work properly!!");            

    }
    /**
     * This constructer initiliaze the fields.
     * @param id every account has its account id 
     * @param nick nickname of the account
     * @param date birthdate of the account
     * @param city city that user lives or was born.
     */
    public Account(int id, String nick,String date,String city)
    {
        accountid = id;
        username = nick;
        birthdate = date;
        location = city;
        inbox = new LinkedList<Message>();
        outbox = new LinkedList<Message>();
        BlockedBy = new LinkedList<String>();
        System.out.println("An account with username "+ username+ " has been created.");
        history.add("An account with username "+ username+ " has been created.");
    }
    /**
     * checks if a user banned or not.
     * @param obj who banned to account
     * @return return true if is banned.
     */
    public boolean check_banned(Account obj)
    {
        for(int i = 0;i<BlockedBy.size()&& i<50;i++)
        {
            if(BlockedBy.get(i) == obj.get_username())
                return true;
        }
        return false;
    }
    /**
     *  this method follow a user to parameter one.
     * @param follow_me this is the account that is going to be followed by caller.
     */
    public void follow(Account follow_me)
    {
        if(is_login ==true && follow_me.check_banned(this) == false)
        {
            this.following.remove(follow_me.username);
            this.following.add(follow_me.username);
            follow_me.followers.remove(this.username);
            follow_me.followers.add(this.username);
            System.out.println(username + " has just started following to " + follow_me.get_username());
            history.add("you has just started following to " + follow_me.get_username());
        }
    }
    /**
     * an account unfollow another account.
     * @param unfollowMe the account that's going to be unfollowed.
     */
    public void unfollow(Account unfollowMe)
    {
        if(is_login==true)
        {
            this.following.remove(unfollowMe.username);
            unfollowMe.followers.remove(this.username);
            history.add("you has just started unfollowing to "+unfollowMe.get_username()+".");
        }
    }
    /**
     * gettr method of username
     * @return username as a string.
     */
    public String get_username()
    {
        return username;
    }
    /**
     * the followings calls this method in order to set who is followers who
     * @param Follow_me this is followers
     */
    public void set_followers(Account Follow_me)
    {
        if(is_login==true && Follow_me.check_banned(this)==false)
            followers.add(Follow_me.get_username());
    }
    /**
     * this method in order to see caller follews who
     */
    public void see_followings(Account obj)
    {
        Iterator temp_iterator = following.iterator();
        if(obj.is_login==true)
        {
            System.out.print("Following "+following.size()+" account = ");
            while(temp_iterator.hasNext())
                System.out.print(temp_iterator.next()+ " ");
            System.out.print("\n");
        }
    }
    /**
     * this method for see followers of the caller.
     */
    public void see_followers(Account obj)
    {
        Iterator temp_iterator = followers.iterator();
        if(obj.is_login==true)
        {
            System.out.print("Followers "+followers.size() +" = ");
            while(temp_iterator.hasNext())
                System.out.println(temp_iterator.next()+ " ");
            System.out.print("\n");
        }
    }
    /**
     * it is logging out method it makes automatically is_login false.
     * so that's how if a user logs out then it cannot do anything until logs in.
     * @return boolean if it is successful or not.
     */
    public boolean logout()
    {
        if(is_login==true)
        {
            is_login =false;
            System.out.println(username + " has just logged out.");
            history.add("You logged out");
            return true;
        }
        return false;
    }
    /**
     * it takes input as a parameter to share a post on the profile
     * @param input the pots that is going to be shared by the account.
     */
    public void addPost(Post input)
    {
        if(is_login==true)
        {
            posts.add(input);
            history.add("post shared. Post id=  "+input.get_postid() );
        }
    }
    /**
     * It shares simple data about given account such as account id or username.
     * @param obj the profile that is wanted to be viewed
     */
    public void view(Account obj)
    {
        Iterator<String> temp_following = obj.following.iterator();
        Iterator<String> temp_followers= obj.followers.iterator();
        if(is_login == true && this.check_banned(obj)==false)
        {
            System.out.println("---------------");
            System.out.println("User id = "+obj.accountid+"\nUsername = "+obj.username+"\nBirthdate = "+obj.birthdate+"\nLocation = "+obj.location);
            obj.see_followings(this);
            obj.see_followers(this);
            System.out.println(obj.username+" has "+obj.posts.size()+" posts");
            // System.out.print("following: ");
            // while(temp_following.hasNext())
                // System.out.print(temp_following.next()+ " ");
            // System.out.print("\n Followers: ");
            // while(temp_followers.hasNext())
                // System.out.println(temp_followers.next()+ " ");
            // System.out.print("\n");
        }
        else if ( this.check_banned(obj)==true)
            System.out.println("you are not allowed to view a profile");
    }
    /**
     * It gives detail about comments that on the post.
     * @param obj
     */
    public void viewPosts(Account obj)
    {
        Iterator temp_iterator = obj.posts.iterator();
        if(is_login ==true && this.check_banned(obj)==false)
        {
            for(int i =0;temp_iterator.hasNext();i++)
                System.out.println("Postid: "+i+" "+obj.username+": "+temp_iterator.next());
        }
    }
    /**
     * This is like method callers a post who owner is as a parameter.
     * @param obj thats owner of the post.
     * @param iLikeit object of the like
     * @throws NullPointerException it checks if it boundry of the linkedlist.
     */
    public void liking(Account obj,Like iLikeit) throws NullPointerException
    {
        if(is_login==true && check_banned(obj)==false)
        {
            System.out.println(username+" liked a post");
            try {
                    int temp_post_id= iLikeit.get_postid();
                if(temp_post_id <=0)
                    throw new NullPointerException("invalid position at linkedlist");
                     obj.posts.get(temp_post_id-1).WasLiked(this);
                     history.add("You liked a post of "+ obj.username+" post id was "+ iLikeit.get_postid());
            } catch (NullPointerException e) {
                System.out.println(e);
            }
        }
    }
    /**
     * This is like method callers a post who owner is as a parameter.
     * @param obj thats owner of the post.
     * @param dislike object of the dislike
     * @throws NullPointerException it checks if it boundry of the linkedlist.
     */
    public void disliking(Account obj,Like dislike) throws NullPointerException
    {
        if(is_login==true && check_banned(obj)==false)
        {
            try {
                int temp_post_id= dislike.get_postid();
                if(temp_post_id <=0)
                    throw new NullPointerException("invalid position at linkedlist");
                     obj.posts.get(temp_post_id-1).wasDisliking(this);
                     history.add("You disliked a post of "+ obj.username+" post id was "+ dislike.get_postid());
            } catch (NullPointerException e) {
                System.out.println(e);
            }
        }
    }
    /**
     * it says who liked the specified post.
     * @param num this is for which post.
     */
    public void like_detail(int num)
    {
        if(is_login==true)
            posts.get(num-1).see_likes();
    }
    /**
     * This is comment method for the callers.
     * @param obj who is owner of the post
     * @param itsIdea object of the comment
     * @throws NullPointerException checks whether null pointer, boundry of the linkedlist or not.
     */
    public void make_comment(Account obj,Comment itsIdea)throws NullPointerException
    {
        if(is_login == true)
        {
            System.out.println(username+" writing a command");
            try
            {
                int temp_post_id = itsIdea.get_postid();
                if(temp_post_id <=0)
                    throw new NullPointerException("invalid position at linkedlist");
                obj.posts.get(temp_post_id-1).commented(this,itsIdea);
                history.add("You make comment on a post of "+ obj.username+" post id was "+ itsIdea.get_postid());
            }catch(NullPointerException e)
            {
                System.out.println(e);
            }
        }
    }
    /**
    * This is uncomment method for the callers.
    * @param obj who is owner of the post
    * @param itsIdea object of the comment that is going to be deleted
    * @throws NullPointerException checks whether null pointer, boundry of the array or not.
    */
    public void make_uncomment(Account obj,Comment itsIdea)throws NullPointerException
    {
        if(is_login == true)
        {
            System.out.println(username+" writing a command");
            try
            {
                int temp_post_id = itsIdea.get_postid();
                if(temp_post_id <=0)
                    throw new NullPointerException("invalid position at array");
                obj.posts.get(temp_post_id-1).uncommented(this,itsIdea);
                history.add("You make uncomment on a post of "+ obj.username+" post id was "+ itsIdea.get_postid());
            }catch(NullPointerException e)
            {
                System.out.println(e);
            }
        }
    }
    /**
     * Like like_detail it gives information about specific posts.
     * @param num it says which post.
     */
    public void comment_detail(int num)
    {
        posts.get(num-1).see_comments();
    }
    /**
     * It send a message to inbox of a account and it drops outbox of the caller account
     * @param obj who receive the message
     * @param firstMessage message object and it contains details of the message.
     */
    public void addOut(Account obj,Message firstMessage)
    {
        if(is_login == true && check_banned(obj)==false)
        {
            System.out.println(username + " sending messege to "+ obj.username);
            this.outbox.add(firstMessage);
            obj.inbox.add(firstMessage);
            history.add("You send a message to "+ obj.username);
        }
        else if(check_banned(obj) == true)
        {
            System.out.println("you are blocked by "+obj.username);
        }
    }
    /**
     * it checks whether there is/are message or not in outbox
     * @throws ArrayIndexOutOfBoundsException it checks boundry of the array.
     */
    public void check_outbox() throws ArrayIndexOutOfBoundsException
    {
        if(is_login==true)
        {
            try
            {
                if(inbox.size()>=40)
                {
                    throw new ArrayIndexOutOfBoundsException("Max limit!!!!!");
                }
            }catch(ArrayIndexOutOfBoundsException e)
            {
                System.out.println(e);
            }
            if(outbox.size() != 0)
            {
                for(int i=0 ;i < outbox.size();i++)
                    outbox.get(i).messagebox();
            }
            else
                System.out.println("There is 0 outbox message.");
        }
    }
    /**
     * It checks message box of callers.
     */
    public void check_inbox()
    {
        if(is_login==true)
        {
            if(inbox.size() != 0)
            {
                System.out.println("There is/are "+inbox.size()+" messages");
                for(int i=0 ;i < inbox.size();i++)
                    inbox.get(i).messagebox();
            }
            else
                System.out.println("There is 0 inbox message.");
        }
    }
    /**
     * It gives the most detailed information about whole posts.
     * @param obj who has shared the posts.
     */
    public void viewInteraction(Account obj)
    {
        if(is_login==true && check_banned(obj)==false)
        {
            System.out.println("Viewing "+username+" posts interaction");
            for(int i =0;i<obj.posts.size();i++)
            {
                obj.posts.get(i).see_likes();
                obj.posts.get(i).see_comments();
            }
        }
    }
    public void showHistory()
    {
        Iterator<String> temp_iterator = history.iterator();
        if(is_login == true)
        {
            while(temp_iterator.hasNext())
                System.out.println(temp_iterator.next());
        }
    }
}