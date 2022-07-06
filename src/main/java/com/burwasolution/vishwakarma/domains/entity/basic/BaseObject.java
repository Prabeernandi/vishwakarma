package com.burwasolution.vishwakarma.domains.entity.basic;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseObject {

    @Id
    private String id;
    private boolean deleted = false;
    private boolean isActive = true;
    @CreatedDate
    private Date createdDate;
    @LastModifiedDate
    private Date updatedDate;
    @CreatedBy
    private String createdUserId;
    @LastModifiedBy
    private String modifiedUserId;

    @JsonIgnore
    public String getId() {
        return id;
    }
    @JsonProperty
    public void setId(String id) {
        this.id = id;
    }

    @JsonIgnore
    public boolean isDeleted() {
        return deleted;
    }
    @JsonProperty
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @JsonIgnore
    public boolean isActive() {
        return isActive;
    }
    @JsonProperty
    public void setActive(boolean active) {
        isActive = active;
    }

    @JsonIgnore
    public Date getCreatedDate() {
        return createdDate;
    }
    @JsonProperty
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @JsonIgnore
    public Date getUpdatedDate() {
        return updatedDate;
    }
    @JsonProperty
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    @JsonIgnore
    public String getCreatedUserId() {
        return createdUserId;
    }
    @JsonProperty
    public void setCreatedUserId(String createdUserId) {
        this.createdUserId = createdUserId;
    }

    @JsonIgnore
    public String getModifiedUserId() {
        return modifiedUserId;
    }
    @JsonProperty
    public void setModifiedUserId(String modifiedUserId) {
        this.modifiedUserId = modifiedUserId;
    }
}
