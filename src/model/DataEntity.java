package model;

import java.time.LocalDateTime;

public abstract class DataEntity {

    private String createdAt;
    private String upadtedAt;

    public DataEntity(){
        this.createdAt = LocalDateTime.now().toString();
        this.upadtedAt = LocalDateTime.now().toString();
    }

    public void touch(){
        this.upadtedAt = LocalDateTime.now().toString();
    }

    public String getCreatedAt(){
        return createdAt;
    }

    public String getUpadtedAt(){
        return upadtedAt;
    }
}
