/**
 * it does the scenario 3 
 */
public class TestClass3
{
    public static void main(String[] args) {
        double start = System.nanoTime();
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

        System.out.println("------driver2 starts here");
        gizemsungu.login();
        Post thirdPost = new Post(1,2,"","","GTU!!");
        gizemsungu.addPost(thirdPost);
        Post forthPost = new Post(2,2,"","","Computer Science and Engineering!");
        gizemsungu.addPost(forthPost);
        gizemsungu.logout();

        sibelgulmez.login();
        sibelgulmez.view(gizemsungu);
        Like likeTheThird = new Like (1,0,1);
        sibelgulmez.liking(gizemsungu, likeTheThird);
        sibelgulmez.viewPosts(gizemsungu);
        sibelgulmez.viewInteraction(gizemsungu);
        sibelgulmez.logout();

        gokhankaya.login();
        gokhankaya.view(gizemsungu);
        Comment secondComment = new Comment(2, 1, 2, "Nice!!");
        gokhankaya.make_comment(gizemsungu, secondComment);
        gokhankaya.viewInteraction(gizemsungu);
        Message sendTo = new Message(2, 1, 2, "Hello!");
        gokhankaya.addOut(gizemsungu, sendTo);
        gokhankaya.logout();

        gizemsungu.login();
        gizemsungu.view(gizemsungu);
        gizemsungu.check_inbox();
        //gizemsungu.check_outbox();
        //sibelgulmez.liking(gizemsungu, likeTheThird);
        gizemsungu.BlockIt(sibelgulmez);
        gizemsungu.view(sibelgulmez);
        gizemsungu.logout();
        sibelgulmez.login();
        sibelgulmez.view(gizemsungu);
        Message lastMessage= new Message(3,0,2,"How are you");
        sibelgulmez.addOut(gizemsungu, lastMessage);
        sibelgulmez.viewPosts(gizemsungu);
        double end = System.nanoTime();
        System.out.println((end-start)/1000000000+ "second is the run time!!");

    }
}