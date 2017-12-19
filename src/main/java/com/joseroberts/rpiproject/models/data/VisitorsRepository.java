package com.joseroberts.rpiproject.models.data;

import com.joseroberts.rpiproject.models.Visitors;
import com.mongodb.DBCollection;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VisitorsRepository extends MongoRepository<Visitors, String>{
//    public static DBCollection store = MongoDAO.getDb().getCollection("visitors");

}
