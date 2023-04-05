import java.util.LinkedList;
/**
 * Scenario1.
 */
public class TestClass1
{
    public static void main(String[] args) {
        double start= System.nanoTime();
        Account sibelgulmez = new Account(0, "sibelgulmez","12.01.1885", "London");
        Account gokhankaya = new Account(1, "gokhankaya", "18.06.1994", "Paris");
        Account gizemsungu  = new Account(2, "gizemsungu", "27.12.1980", "Istanbul");
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
        double end = System.nanoTime();
        System.out.println((end-start)/1000000000+ "second is the run time!!");
    }
}