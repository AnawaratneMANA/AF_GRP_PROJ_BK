package com.testing.demo.Service.DownloadItemService;

import com.testing.demo.Model.Request.DownloadCategory;
import com.testing.demo.Model.Request.DownloadItems.DownloadItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Service
public class DownloadItemServiceImpl implements DownloadItemService {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public DownloadItem createDownloadItem(DownloadItem downloadItem) {
        DownloadItem item = new DownloadItem();
        item.setFileName(downloadItem.getFileName());
        item.setPath(downloadItem.getPath());
        item.setFileType(downloadItem.getFileType());
        item.setPublisherName(downloadItem.getPublisherName());
        item.setApprovalStatus(downloadItem.getApprovalStatus());
        return item;
    }

    @Override
    public String deleteDownloadItem(String id) {
        mongoTemplate.remove(new Query(where("id").is(id)), DownloadItem.class);
        return "User id is " + id;
    }

    @Override
    public List<DownloadItem> getAllDownloadItems() {
        return mongoTemplate.findAll(DownloadItem.class);
    }
}
