package org.webonise.springboot.collectiondemo;

import java.util.List;
import java.util.Set;

public interface UserDB {
    List<User> getListOfUsers();

    Set<User> getSetOfUsers();
}
