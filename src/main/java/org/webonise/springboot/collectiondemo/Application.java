package org.webonise.springboot.collectiondemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Component
public class Application {

    @Autowired
    UserList userList;

    @Autowired
    UserSet userSet;

    @Autowired
    UserMap userMap;

    @Autowired
    DateOfBirthComparator dateOfBirthComparator;

    public void start() {

        listDemo();
        setDemo();
        mapDemo();
    }

    private void listDemo() {

        System.out.println("\n==============List obtained from DB===============");
        userList.displayList();

        System.out.println("\n==============Add User to UserList===============");
        User user = new User();
        user.setId("00001");
        user.setName("Kuldeep Singh");
        user.setDOB("18-06-1993");
        user.setEmail("kuldeepsingh@gmial.com");
        userList.add(user);
        userList.displayList();

        System.out.println("\n==============After Sorting by name===============");
        userList.sort();
        userList.displayList();

        System.out.println("\n==============Equals Demo===============");
        List<User> users = userList.getUserList();
        User user1 = users.get(0);
        User user2 = users.get(2);

        System.out.println("is " + user1.getName() + " equals to " + user2.getName() + "?");
        if (user1.equals(user2)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        System.out.println("\n================Comparator Demo==================");
        Collections.sort(users, dateOfBirthComparator);
        userList.displayList();

        System.out.println("\n==============clear UserList===============");
        userList.clear();
        userList.displayList();
    }

    private void setDemo() {

        System.out.println("\n==============Set obtained from DB===============");
        userSet.displaySet();

        System.out.println("\n==============Add User to UserSet===============");
        User user = new User();
        user.setId("00001");
        user.setName("Kuldeep Singh");
        user.setDOB("18-06-1993");
        user.setEmail("kuldeepsingh@gmial.com");
        userSet.add(user);
        userSet.displaySet();

        System.out.println("\n==============Equals Demo===============");
        Set<User> users = userSet.getUserSet();
        Iterator<User> iterator = users.iterator();
        User user1 = iterator.next();
        User user2 = iterator.next();

        System.out.println("is " + user1.getName() + " equals to " + user2.getName() + "?");
        if (user1.equals(user2)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        System.out.println("\n==============clear UserSet===============");
        userSet.clear();
        userSet.displaySet();
    }

    private void mapDemo() {

        System.out.println("\n==============Map===============");
        userMap.displayMap();

        System.out.println("\n==============Map.containKey(Object key)===============");
        System.out.println("is 2 key exits ?");
        System.out.println(userMap.containKey(2));

        System.out.println("\n==============Map.containValue(Object value)===============");
        System.out.println("is value at 2 exits ?");
        System.out.println(userMap.containValue(userMap.get(2)));

        System.out.println("\n==============Add User to UserMap===============");
        User user = new User();
        user.setId("00001");
        user.setName("Kuldeep Singh");
        user.setDOB("18-06-1993");
        user.setEmail("kuldeepsingh@gmial.com");
        userMap.add(3, user);
        userMap.displayMap();

        System.out.println("\n==============remove User from UserMap===============");
        userMap.remove(2);
        userMap.displayMap();

        System.out.println("\n==============Add replace User in UserMap===============");
        User replaceUser = new User();
        replaceUser.setId("00001");
        replaceUser.setName("Kuldeep Sharma");
        replaceUser.setDOB("18-06-1993");
        replaceUser.setEmail("kuldeepsingh@gmial.com");
        userMap.replace(1, replaceUser);
        userMap.displayMap();

        System.out.println("\n==============clear UserMap===============");
        userMap.clear();
        userMap.displayMap();
    }
}
