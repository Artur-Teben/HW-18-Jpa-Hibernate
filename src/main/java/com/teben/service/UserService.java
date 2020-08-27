package com.teben.service;

import com.teben.models.Book;
import com.teben.models.User;
import com.teben.repository.BookRepository;
import com.teben.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BookRepository bookRepository;

    public void insertUsers() {
        createUser(new User("Alona", "Tal", 36, "+17456384675", new ArrayList<>()));
        createUser(new User("Ben", "Affleck", 48, "+18675948737", new ArrayList<>()));
        createUser(new User("Jennifer", "Aniston", 51, "+10955746385", new ArrayList<>()));
        createUser(new User("Shaya", "La Boeuf", 34, "+10936741134", new ArrayList<>()));
    }

    public void createUser(User user) {
        userRepository.createUser(user);
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public User getUserById(Long id) {
        return userRepository.getUserById(id);
    }

    public void deleteUser(Long userId) {
        User user = getUserById(userId);

        userRepository.deleteUser(user);
    }

    public void editUser(Long userId, String firstName, String lastName, Integer age, String number) {
        User user = getUserById(userId);

        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAge(age);
        user.setNumber(number);

        userRepository.editUser(user);
    }

    public void addBookToUser(Long userId, Long bookId) {
        User user = getUserById(userId);
        Book book = bookRepository.getBookById(bookId);

        List<Book> userBooks = user.getBookList();
        userBooks.add(book);
        book.setOwner(user);
        userRepository.editUser(user);
    }

    public List<Book> getAllUserBooks(Long userId) {
        return getUserById(userId).getBookList();
    }

}
