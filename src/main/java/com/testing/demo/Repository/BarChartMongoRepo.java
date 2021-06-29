package com.testing.demo.Repository;

import com.testing.demo.Model.Request.Events;
import com.testing.demo.Model.Response.BarChartModel;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BarChartMongoRepo extends MongoRepository<Events, Integer> {
    @Query(value = "{'eventPlace': {$elemMatch :{$in: ?0}}}", fields = "{eventName: 1}")
    public List<Events> getItemByYear(String [] categories);
}
