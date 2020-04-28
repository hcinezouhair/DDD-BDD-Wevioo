package com.wevioo.demo.model.user;

import com.wevioo.demo.domain.aggregate.HistoryAction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
public class HistoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HISTORY_ID")
    private long historyId;

    @ManyToOne(targetEntity = UserEntity.class, cascade = {CascadeType.ALL})
    @JoinColumn(name = "USER_ID")
    private UserEntity user;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private HistoryAction action;

    @Column(name = "HISTORY_DATETIME")
    private LocalDateTime historyDateTime;

    @Column(length = 2000)
    private String comment;
}
