package com.grsdev.springBoot2.pack03.docker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;

@RestController
@RequestMapping(path = "/docker")
public class DockerDemoController {


    @GetMapping(path = "/host")
    public DockerHostDetails getHost() throws UnknownHostException {

        InetAddress localHost = InetAddress.getLocalHost();

        return
                DockerHostDetails.builder()
                        .hostAddress(localHost.getHostAddress())
                        .hostName(localHost.getHostName())
                        .timeStamp(LocalDateTime.now().toString())
                        .build()
                ;
    }

}
