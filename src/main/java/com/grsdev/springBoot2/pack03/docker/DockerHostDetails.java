package com.grsdev.springBoot2.pack03.docker;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DockerHostDetails {

    private String hostName;
    private String hostAddress;
    private String timeStamp;
}
