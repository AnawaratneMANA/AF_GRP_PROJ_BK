package com.testing.demo.Service.DownloadItemService;
import com.testing.demo.Model.Request.DownloadItems.DownloadItem;

import java.util.List;

public interface DownloadItemService {
    DownloadItem createDownloadItem(DownloadItem downloadItem);
    String deleteDownloadItem(String id);
    List<DownloadItem> getAllDownloadItems();
}
