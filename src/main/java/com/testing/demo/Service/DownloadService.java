package com.testing.demo.Service;
import com.testing.demo.Model.Request.DownloadCategory;
import java.util.List;

public interface DownloadService {
    DownloadCategory createDownloadCategory(DownloadCategory downloadCategory);
    String deleteDownloadCategory(String id);
    List<DownloadCategory> getAllDownloadCategories();

    /**
     * In case need a update method add a update method here.
     * **/
}
