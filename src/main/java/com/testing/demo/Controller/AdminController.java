package com.testing.demo.Controller;

import com.testing.demo.Model.Request.DownloadCategory;
import com.testing.demo.Model.Request.DownloadItems.DownloadItem;
import com.testing.demo.Model.Response.ApproveStatus;
import com.testing.demo.Model.Response.TotalUserCount;
import com.testing.demo.Service.ApproveStatus.ApproveStatusService;
import com.testing.demo.Service.TotalUserCount.TotalUserCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/v1")
public class AdminController {
    @Autowired
    ApproveStatusService approveStatusService;

    @Autowired
    TotalUserCountService totalUserCountService;

    @GetMapping("/approveStatuses")
    public ResponseEntity<?> getApproveStatus(){
        int count1 = 0;
        int count2 = 0;
        List<DownloadItem> downloadItems = approveStatusService.getApproveStatus();
        if(downloadItems.size() >= 0){
            for (DownloadItem i : downloadItems){
                if (i.getApprovalStatus().contentEquals("approve")){
                    count1++;
                }else if (i.getApprovalStatus().contentEquals("reject")){
                    count2++;
                }
            }
            ApproveStatus approveStatus = new ApproveStatus(String.valueOf(count1), String.valueOf(count2), String.valueOf(count1+count2));
            return new ResponseEntity<>(approveStatus, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No Categories", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/totalUserCount")
    public ResponseEntity<?> getTotalUserCount(){
        List<TotalUserCount> totaluserCount = totalUserCountService.getTotaluserCount();
        if(totaluserCount.size() >= 0){
            return new ResponseEntity<>(totaluserCount, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No Categories", HttpStatus.NOT_FOUND);
        }
    }
}
