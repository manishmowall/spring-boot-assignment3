package org.webonise.springboot.collectiondemo;


import org.springframework.data.repository.CrudRepository;

public interface UserMongoRespository extends CrudRepository<User, String> {
}
