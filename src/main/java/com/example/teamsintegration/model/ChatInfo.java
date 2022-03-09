package com.example.teamsintegration.model;

import lombok.Data;

@Data
public class ChatInfo {

    private String threadId;
    private String messageId;
    private String replyChainMessageId;

}
