package org.webonise.springboot.collectiondemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class UserList {

    @Autowired
    @Qualifier("getListOfUsers")
    private List<User> users;

    public void displayList() {

        if (users.isEmpty()) {
            System.out.println("DB is empty");
        } else {
            for (User user : users) {
                System.out.println(user.getId() + " : " + user.getName() + " : " + user.getDOB() + " : " + user.getEmail());
            }
        }
    }

    public void sort() {
        //using comparable interface to sort user defined class list
        Collections.sort(this.users);
    }

    public List<User> getUserList() {

        return users;
    }

    public void add(User user) {

        users.add(user);
    }

    public void clear() {

        users.clear();
    }
}
