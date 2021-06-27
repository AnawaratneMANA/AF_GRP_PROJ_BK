package com.testing.demo.Service.TotalUserCount;

import com.testing.demo.Model.Response.TotalUserCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TotalUserCountServiceImpl implements TotalUserCountService{

    @Autowired
    TotalUserCountService totalUserCountService;

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<TotalUserCount> getTotaluserCount() {
        return mongoTemplate.findAll(TotalUserCount.class);
    }
}
