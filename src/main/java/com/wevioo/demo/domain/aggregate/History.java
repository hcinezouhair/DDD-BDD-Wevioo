package com.wevioo.demo.domain.aggregate;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class History {

    private long historyId;

    private User user;

    private HistoryAction action;

    private LocalDateTime historyDateTime;

    private String comment;

}
