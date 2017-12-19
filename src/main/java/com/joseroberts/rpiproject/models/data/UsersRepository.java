package com.joseroberts.rpiproject.models.data;

import com.joseroberts.rpiproject.models.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends MongoRepository<Users, String>{
}
