package org.webonise.springboot.collectiondemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class UserSet {

    @Autowired
    @Qualifier("getSetOfUsers")
    private Set<User> users;

    public void displaySet() {

        if (users.isEmpty()) {
            System.out.println("no users found");
        } else {
            for (User user : users) {
                System.out.println(user.getId() + " : " + user.getName() + " : " + user.getDOB() + " : " + user.getEmail());
            }
        }
    }

    public Set<User> getUserSet() {

        return users;
    }

    public void add(User user) {

        users.add(user);
    }

    public void clear() {

        users.clear();
    }
}
