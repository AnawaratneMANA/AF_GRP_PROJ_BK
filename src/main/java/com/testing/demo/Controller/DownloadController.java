package com.testing.demo.Controller;

import com.testing.demo.Model.Request.DownloadCategory;
import com.testing.demo.Model.Request.Users;
import com.testing.demo.Service.DownloadService;
import com.testing.demo.Service.UserService;
import com.testing.demo.Service.UserValidation;
import com.testing.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/v1")
public class DownloadController {
    @Autowired
    DownloadService downloadService;

    @PostMapping("/download/category")
    public ResponseEntity<?> createDownloadCategory (@RequestBody DownloadCategory downloadcategory){
        DownloadCategory downloadCategory = downloadService.createDownloadCategory(downloadcategory);
        return new ResponseEntity<>(downloadCategory, HttpStatus.OK);
    }

    @DeleteMapping("/delete/category/{type}")
    public ResponseEntity<?> deleteUser(@PathVariable String type){
        String response = downloadService.deleteDownloadCategory(type);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
