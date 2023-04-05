/**
 * it does the scenario 4 
 */
public class TestClass4
{
    public static void main(String[] args) {
        double start = System.nanoTime();
        Account sibelgulmez = new Account(0, "sibelgulmez","12.01.1885", "London");
        Account gokhankaya = new Account(1, "gokhankaya", "18.06.1994", "Paris");
        Account gizemsungu  = new Account(2, "gizemsungu", "27.12.1980", "Istanbul");
        /*---------------Bot Account ------------*/
        Account account1 = new Account(3,"account1","1.1.2001","Kocaeli");
        Account account2 = new Account(4,"account2","1.1.2001","İzmir");
        Account account3 = new Account(5,"account3","1.1.2001","Bursa");
        Account account4 = new Account(6,"account4","1.1.2001","Adana");
        Account account5 = new Account(7,"account5","1.1.2001","Trabzon");
        Account account6 = new Account(8,"account6","1.1.2001","Ankara");
        Account account7 = new Account(9,"account7","1.1.2001","Antalya");
        /*--------------------------------------------- */
        sibelgulmez.login();
        Post firstPost = new Post(1,0,"","","I like JAVA");
        sibelgulmez.addPost(firstPost);
        Post secondPost = new Post(2,0,"","","Java The Coffe");
        sibelgulmez.addPost(secondPost);
        sibelgulmez.follow(gizemsungu);
        sibelgulmez.follow(gokhankaya);
        sibelgulmez.logout();

        gokhankaya.login();
        gokhankaya.view(sibelgulmez);
        gokhankaya.viewPosts(sibelgulmez);
        Like iLikeit = new Like(0,1,1);
        gokhankaya.liking(sibelgulmez,iLikeit);
        Comment firstComment = new Comment(1, 1, 1, "me too!");
        gokhankaya.make_comment(sibelgulmez, firstComment);
        gokhankaya.follow(sibelgulmez);
        gokhankaya.follow(gizemsungu);
        Message firstMessage = new Message(1,1,2,"This homework is too easy!");
        gokhankaya.addOut(gizemsungu, firstMessage);
        gokhankaya.logout();

        gizemsungu.login();
        gizemsungu.check_outbox();
        gizemsungu.check_inbox();
        gizemsungu.view(sibelgulmez);
        gizemsungu.viewPosts(sibelgulmez);
        gizemsungu.viewInteraction(sibelgulmez);
        gizemsungu.logout();
        /* part 4 starts here */
        /* first two accounts are liking and one of them unlike  */

        account1.login();
        Like like1 = new Like(1, 3, 1);
        account1.liking(sibelgulmez, like1);
        account1.logout();
        
        account2.login();
        Like like2 = new Like(1,4,1);
        account2.liking(sibelgulmez,like2);
        account2.viewInteraction(sibelgulmez);
        account2.disliking(sibelgulmez, like2);
        account2.viewInteraction(sibelgulmez);
        account2.logout();

        /*------------ */
        /*two account folllow and then one of them unfollow */
        account3.login();
        account3.follow(sibelgulmez);
        account3.logout();

        account4.login();
        account4.follow(sibelgulmez);
        account4.view(sibelgulmez);
        account4.unfollow(sibelgulmez);
        account4.view(sibelgulmez);
        account4.logout();

        /*------------ */
        /*Two account make a comment on a post but one of them is going to take it back */
        account5.login();
        Comment comment2 = new Comment(1, 7, 1, "C is better!");
        account5.make_comment(sibelgulmez, comment2);
        account5.logout();

        account6.login();
        Comment comment3 = new Comment(1, 8, 1,"ChatGPT is the greatest!");
        account6.make_comment(sibelgulmez, comment3);
        account6.viewInteraction(sibelgulmez);
        account6.make_uncomment(sibelgulmez, comment3);
        account6.viewInteraction(sibelgulmez);
        account6.logout();
        /*---------------------- */
        /* Last account is going to follow sibelgulmez then it will be blocked */
        account7.login();
        account7.follow(sibelgulmez);
        account7.logout();

        sibelgulmez.login();
        sibelgulmez.BlockIt(account7);
        sibelgulmez.logout();
        account7.login();
        account7.view(sibelgulmez);
        account7.logout();
        sibelgulmez.login();
        sibelgulmez.unblock(account7);
        sibelgulmez.logout();

        account7.login();
        account7.view(sibelgulmez);
        account7.logout();
        double end = System.nanoTime();
        System.out.println((end-start)/1000000000+ "second is the run time!!");
    }
}