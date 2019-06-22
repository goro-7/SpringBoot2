package com.grsdev.springBoot2.pack03.docker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping(path="/docker")
public class DockerDemoController {


    @GetMapping(path="/host")
    public String getHost() throws UnknownHostException {

        return InetAddress.getLocalHost().getHostName();
    }

}
