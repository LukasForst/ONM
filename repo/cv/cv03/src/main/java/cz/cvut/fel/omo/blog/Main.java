package cz.cvut.fel.omo.blog;

import cz.cvut.fel.omo.blog.security.Account;
import cz.cvut.fel.omo.blog.security.AdminAccount;
import cz.cvut.fel.omo.blog.security.Blog;
import cz.cvut.fel.omo.blog.security.UserAccount;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static Logger logger = Logger.getGlobal();

    public static void main(String[] args) {

        //1.1 CREATING NEW ADMIN AND USER ACCOUNT
        Blog blog = new Blog();
        String username = "Tom_Hanks";
        String password = "password";
        boolean admin = true;
        blog.createNewAccount(username, password, admin);
        blog.createNewAccount("Nicolas_Cage", "password", false);

        // 1.2 LOGGING INTO THE ADMIN ACCOUNT
        Optional<Account> adminOptional = blog.login(username, password);
        if (!adminOptional.isPresent()) {
            logger.log(Level.WARNING, "Admin account with username \"" + username + "\" not found!\nExiting program....");
            return;
        }
        AdminAccount account = (AdminAccount) adminOptional.get();

        // 1.3 CREATING NEW TOPICS
        account.createNewTopic("AngularJS", "Typical issues encountered using AngularJS, also known as Angular1");
        account.createNewTopic("React", "Unlocking hidden power of javascript.");
        account.createNewTopic("FrontEnd development", "Various frameworks for frontend development.");

        blog.displayTopics();

        // 1.4 WRITING NEW POST
        account.writeNewPost("Why Angular JS", "HTML is great for declaring static documents, but it falters when we try to use it for declaring dynamic views in web-applications. AngularJS lets you extend HTML vocabulary for your application. The resulting environment is extraordinarily expressive, readable, and quick to develop.\n");
        account.writeNewPost("Stairway to React", "React makes it painless to create interactive UIs. Design simple views for each state in your application, and React will efficiently update and render just the right components when your data changes.\n");

        // 1.5 REGISTRING POSTS TO TOPICS
        Optional<Post> angularPost = blog.findPost("Why Angular JS");
        Optional<Post> reactPost = blog.findPost("Stairway to React");
        Optional<Topic> angularTopic = blog.findTopic("AngularJS");
        Optional<Topic> reactTopic = blog.findTopic("React");
        Optional<Topic> frontEndTopic = blog.findTopic("FrontEnd development");

        if(!angularPost.isPresent() || !reactPost.isPresent() || !angularTopic.isPresent() || !reactTopic.isPresent() || !frontEndTopic.isPresent()){
            logger.log(Level.WARNING, "One of post was not found! Exiting...");
            return;
        }

        angularPost.get().registerToTopic(angularTopic.get());
        angularPost.get().registerToTopic(frontEndTopic.get());
        reactPost.get().registerToTopic(reactTopic.get());
        reactPost.get().registerToTopic(frontEndTopic.get());

        // 1.6 PUBLISHING POST
        angularPost.get().publishPost();
        reactPost.get().publishPost();

        // 1.8 LOGGING INTO USER ACCOUNT
        Optional<Account> userOptional = blog.login("Nicolas_Cage", password);
        if (!userOptional.isPresent()) {
            logger.log(Level.WARNING, "User with name \"Nicolas_Cage\" not found!\nExiting program....");
            return;
        }
        UserAccount userAccount = (UserAccount) userOptional.get();

        // 1.7 READING DIFFERENT SECTIONS OF BLOG
        userAccount.readBlog();
        userAccount.readBlog("React");
        userAccount.readBlog("AngularJS");
        userAccount.readBlog("FrontEnd development");
        userAccount.readBlog("BackEnd");
    }
}