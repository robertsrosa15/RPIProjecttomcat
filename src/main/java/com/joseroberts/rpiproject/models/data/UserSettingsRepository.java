package com.joseroberts.rpiproject.models.data;

import com.joseroberts.rpiproject.models.UserSettings;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository("usersettings")
public interface UserSettingsRepository extends MongoRepository<UserSettings, String>{
}
