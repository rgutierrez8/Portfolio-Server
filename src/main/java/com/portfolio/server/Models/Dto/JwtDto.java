package com.portfolio.server.Models.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class JwtDto {
    
    private String accessToken;
    private String username;
}
