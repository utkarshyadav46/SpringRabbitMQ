package com.springrabbitmq.consumer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomMessageModel {
    private  String message="";
    private String messageId="";
    private Date  messageDate;

    public void setMessage(String message) {
        this.message = message;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public void setMessageDate(Date messageDate) {
        this.messageDate = messageDate;
    }
}
