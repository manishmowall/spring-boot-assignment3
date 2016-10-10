package org.webonise.springboot.collectiondemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

@Component
public class UserMap {
    private final Set<User> userSet;
    private final Map<Integer, User> users;

    @Autowired
    public UserMap(@Qualifier("getSetOfUsers") final Set<User> userSet, @Qualifier("getHashMap") final Map<Integer, User> users) {
        this.userSet = userSet;
        this.users = users;
        mappingToHashMap();
    }

    private void mappingToHashMap() {
        int i = 0;
        for (User user : userSet) {
            users.put(i, user);
            i++;
        }
    }

    public void displayMap() {

        if (users.isEmpty()) {
            System.out.println("no userMap found");
        } else {
            Set<Integer> keyset = users.keySet();
            for (Integer key : keyset) {
                User user = users.get(key);
                System.out.println(key + " : " + user.getId() + " : " + user.getName() + ", " + user.getDOB() + ", " + user.getEmail());
            }
        }
    }

    public void clear() {

        users.clear();
    }

    public String containKey(Integer key) {

        return users.containsKey(key) ? "YES" : "NO";
    }

    public User get(Integer key) {

        return users.get(key);
    }

    public String containValue(User value) {

        return users.containsValue(value) ? "YES" : "NO";
    }

    public void add(Integer key, User user) {

        users.put(key, user);
    }

    public void remove(Integer key) {

        users.remove(key);
    }

    public void replace(Integer key, User value) {

        users.remove(key, value);
    }
}
