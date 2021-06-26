package com.testing.demo.Service.ApproveStatus;

import com.testing.demo.Model.Request.DownloadItems.DownloadItem;
import com.testing.demo.Model.Response.ApproveStatus;
import com.testing.demo.Repository.ApproveStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ApproveStatusServiceImpl implements ApproveStatusService{

    @Autowired
    ApproveStatusRepository approveStatusRepository;
    ApproveStatusService approveStatusService;

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<DownloadItem> getApproveStatus() {
        return mongoTemplate.findAll(DownloadItem.class);
    }
}
