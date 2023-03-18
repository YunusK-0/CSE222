package homework1;
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
    private String[] following = new String[2];
    private String[] followers = new String[2];
    /**
     * this is checks if a account is login or not it is automatically true with login function.
     * and it is false automatically when logout function is called
     */
    private boolean is_login = false;
    private Post[] posts;
    private int post_counter;
    private Message[] inbox;
    private Message[] outbox;
    private int count_inbox;
    private int count_outbox;
    /**
     * number of followings
     */
    private int int_following;
    /**
     * number of followers.
     */
    private int int_followers;
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
            return true;
        }
        else
            return false;
    }
    /**
     * the account was blocked by.
     */
    private String[] BlockedBy;
    /**
     * count blocking
     */
    private int NumberOfBlock;
    /**
     * part3 is done here
     * @param obj was blocked account it is.
     * 
     */
    public void BlockIt(Account obj)
    {
        System.out.println(username+" has just blocked "+obj.username);
        obj.BlockedBy[NumberOfBlock] = this.username;
        obj.NumberOfBlock++;
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
        int_following =0;
        int_followers=0;
        post_counter=0;
        posts = new Post[10];
        inbox = new Message[10];
        outbox = new Message[10];
        BlockedBy = new String[10];
        count_inbox =0;
        count_outbox=0;
        NumberOfBlock =0;
        System.out.println("An account with username "+ username+ " has been created.");
    }
    /**
     * checks if a user banned or not.
     * @param obj who banned to account
     * @return return true if is banned.
     */
    public boolean check_banned(Account obj)
    {
        for(int i = 0;i<NumberOfBlock&& i<10;i++)
        {
            if(BlockedBy[i] == obj.get_username())
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
            this.following[int_following] = new String(follow_me.get_username());
            int_following++;
            follow_me.set_followers(this);
            System.out.println(username + " has just started following to " + follow_me.get_username());
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
        {
            followers[int_followers] = new String(Follow_me.get_username());
            int_followers++;
        }
    }
    /**
     * this method in order to see caller follews who
     */
    public void see_followings()
    {
        if(is_login==true)
        {
            System.out.println("Following "+int_following+" account = ");
            for(int i =0;i<int_following;i++)
                System.out.println(following[i]);
        }
    }
    /**
     * this method for see followers of the caller.
     */
    public void see_followers()
    {
        if(is_login==true)
        {
            System.out.println("Followers "+int_followers +" =");
            for(int i =0;i<int_followers;i++)
                System.out.println(followers[i]);
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
            posts[post_counter] = input;
            post_counter++;
        }
    }
    public void detail()
    {
        
        posts[post_counter-1].DetailofPosts();
    }
    /**
     * It shares simple data about given account such as account id or username.
     * @param obj the profile that is wanted to be viewed
     */
    public void view(Account obj)
    {
        if(is_login == true && this.check_banned(obj)==false)
        {
            System.out.println("---------------");
            System.out.println("User id = "+obj.accountid+"\nUsername = "+obj.username+"\nBirthdate = "+obj.birthdate+"\nLocation = "+obj.location);
            obj.see_followings();
            obj.see_followers();
            System.out.println(obj.username+" has "+obj.post_counter+" posts");
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
        if(is_login ==true && this.check_banned(obj)==false)
        {
            for(int i =0;i<obj.post_counter;i++)
                System.out.println("Postid: "+i+" "+obj.username+": "+obj.posts[i].get_content());
        }
    }
    /**
     * This is like method callers a post who owner is as a parameter.
     * @param obj thats owner of the post.
     * @param iLikeit object of the like
     * @throws NullPointerException it checks if it boundry of the array.
     */
    public void liking(Account obj,Like iLikeit) throws NullPointerException
    {
        if(is_login==true && check_banned(obj)==false)
        {
            System.out.println(username+" liked a post");
            try {
                    int temp_post_id= iLikeit.get_postid();
                if(temp_post_id <=0)
                    throw new NullPointerException("invalid position at array");
                     obj.posts[temp_post_id-1].WasLiked(this);
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
            posts[num-1].see_likes();
    }
    /**
     * This is comment method for the callers.
     * @param obj who is owner of the post
     * @param itsIdea object of the comment
     * @throws NullPointerException checks whether null pointer, boundry of the array or not.
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
                    throw new NullPointerException("invalid position at array");
                obj.posts[temp_post_id-1].commented(this,itsIdea);
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
        posts[num-1].see_comments();
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
            this.outbox[count_outbox] = firstMessage;
            obj.inbox[obj.count_inbox] = firstMessage;
            obj.count_inbox++;
            count_outbox++;
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
                if(count_inbox>=10)
                {
                    count_inbox=0;
                    throw new ArrayIndexOutOfBoundsException("Max limit!!!!!");
                }
            }catch(ArrayIndexOutOfBoundsException e)
            {
                System.out.println(e);
            }
            if(count_outbox != 0)
            {
                for(int i=0 ;i < count_outbox;i++)
                    outbox[i].messagebox();
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
            if(count_inbox != 0)
            {
                System.out.println("There is/are "+count_inbox+" messages");
                for(int i=0 ;i < count_inbox;i++)
                    inbox[i].messagebox();
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
            for(int i =0;i<obj.post_counter;i++)
            {
                obj.posts[i].see_likes();
                obj.posts[i].see_comments();
            }
        }
    }
}