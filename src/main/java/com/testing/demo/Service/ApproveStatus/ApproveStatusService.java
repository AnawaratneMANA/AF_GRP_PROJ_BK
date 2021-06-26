package com.testing.demo.Service.ApproveStatus;

import com.testing.demo.Model.Request.DownloadItems.DownloadItem;

import java.util.List;

public interface ApproveStatusService {
    List<DownloadItem> getApproveStatus();
}
