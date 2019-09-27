package com.gxlirong.cloud.entities.po;

import lombok.Data;

@Data
public class OaUser {
    private long id;
    private String jobNumber;
    private String username;
    private String password;
    private String name;
    private String mobile;
    private Boolean enabled;
    private Boolean accountNonExpired;
    private Boolean credentialsNonExpired;
    private Boolean accountNonLocked;
    private long createdId;
    private long createdTime;
    private String createdBy;
    private long updatedId;
    private long updatedTime;
    private String updatedBy;
}
