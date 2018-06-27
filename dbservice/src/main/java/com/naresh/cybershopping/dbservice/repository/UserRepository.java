package com.naresh.cybershopping.dbservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.naresh.cybershopping.dbservice.document.Users;

public interface UserRepository extends MongoRepository<Users,Integer> {
	Users findById(int id);
}
