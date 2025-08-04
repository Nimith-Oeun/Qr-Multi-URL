package com.personal.qr_scan.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class RedirectController {

    @GetMapping("/redirect")
    public ResponseEntity<Void> redirectBasedOnIp(HttpServletRequest request) {
        String clientIp = request.getRemoteAddr();
        String localIp = "http://192.168.18.243:9000/qr-menu-chhong_caffe";       // Change to your real local IP
        String publicIp = "http://43.230.192.156:8081/qr-menu-chhong_caffe";      // Change to your real public IP

        if (clientIp.startsWith("192.168.") || clientIp.startsWith("10.") || clientIp.startsWith("172.")) {
            return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(localIp)).build();
        } else {
            return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(publicIp)).build();
        }
    }
}
