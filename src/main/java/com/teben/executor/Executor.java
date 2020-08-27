package com.teben.executor;

import com.teben.config.Config;
import com.teben.service.BookService;
import com.teben.service.UserService;
import com.teben.view.Menu;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Executor {

    public static void startApplication() {
        var context = new AnnotationConfigApplicationContext(Config.class);

        UserService userService = context.getBean(UserService.class);
        userService.insertUsers();

        BookService bookService = context.getBean(BookService.class);
        bookService.insertBooks();

        Menu menu = context.getBean(Menu.class);
        menu.runMenu();
    }

}
