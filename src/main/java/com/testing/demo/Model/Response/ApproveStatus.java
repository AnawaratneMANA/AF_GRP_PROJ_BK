package com.testing.demo.Model.Response;

import org.springframework.data.annotation.Id;

public class ApproveStatus {
    @Id
    private String Id;
    private String ApproveCount;
    private String RejectedCount;
    private String TotalCount;

    public ApproveStatus(String approveCount, String rejectedCount, String totalCount) {
        ApproveCount = approveCount;
        RejectedCount = rejectedCount;
        TotalCount = totalCount;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getApproveCount() {
        return ApproveCount;
    }

    public void setApproveCount(String approveCount) {
        ApproveCount = approveCount;
    }

    public String getRejectedCount() {
        return RejectedCount;
    }

    public void setRejectedCount(String rejectedCount) {
        RejectedCount = rejectedCount;
    }

    public String getTotalCount() {
        return TotalCount;
    }

    public void setTotalCount(String totalCount) {
        TotalCount = totalCount;
    }
}
