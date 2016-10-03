package org.webonise.springboot.collectiondemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Service
public class MongoDB implements UserDB {

    @Autowired
    UserMongoRespository userMongoRespository;

    @Bean
    public List<User> getListOfUsers() {
        Iterator<User> iterator = getUsersIterator();
        List<User> users = new ArrayList<>();
        while (iterator.hasNext()) {
            users.add(iterator.next());
        }
        return users;
    }

    @Bean
    public Set<User> getSetOfUsers() {
        Iterator<User> iterator = getUsersIterator();
        Set<User> users = new HashSet<>();
        while (iterator.hasNext()) {
            users.add(iterator.next());
        }

        return users;
    }

    private Iterator<User> getUsersIterator() {
        Iterable<User> iterable = userMongoRespository.findAll();
        return iterable.iterator();
    }
}
