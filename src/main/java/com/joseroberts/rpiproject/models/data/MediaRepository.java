package com.joseroberts.rpiproject.models.data;


import com.joseroberts.rpiproject.models.Media;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository("media")

public interface MediaRepository extends MongoRepository<Media, String> {
}
