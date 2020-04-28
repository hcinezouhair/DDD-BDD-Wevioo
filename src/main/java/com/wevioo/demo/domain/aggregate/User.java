package com.wevioo.demo.domain.aggregate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static java.time.LocalDateTime.now;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private long userId;

    private String firstName;

    private String lastName;

    private String email;

    private List<History> histories;

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        initHistories();
    }

    private void initHistories() {
        History history = new History();
        history.setAction(HistoryAction.CREATION);
        history.setComment("created by the user system");
        history.setHistoryDateTime(now());
        history.setUser(this);
        histories = new ArrayList<>();
        histories.add(history);
    }
}
