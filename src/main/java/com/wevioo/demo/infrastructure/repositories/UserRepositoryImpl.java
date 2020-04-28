package com.wevioo.demo.infrastructure.repositories;

import com.wevioo.demo.domain.aggregate.History;
import com.wevioo.demo.domain.aggregate.User;
import com.wevioo.demo.domain.repositories.UserRepository;
import com.wevioo.demo.model.user.HistoryEntity;
import com.wevioo.demo.model.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private EntityManager em;

    @Override
    public void create(User user) {
        em.merge(buildUserEntity(user));
    }

    private UserEntity buildUserEntity(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity = userEntity.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .histories(buildHistoryEntitys(user.getHistories()))
                .build();
        for (HistoryEntity historyEntity: userEntity.getHistories() ) {
            historyEntity.setUser(userEntity);
        }
        return userEntity;
    }

    private List<HistoryEntity> buildHistoryEntitys(List<History> histories) {
        return histories.stream().map(h -> buildHistoryEntity(h)).collect(Collectors.toList());
    }

    private HistoryEntity buildHistoryEntity(History historie) {
        HistoryEntity historyEntity = new HistoryEntity();
        historyEntity = historyEntity.builder()
                .action(historie.getAction())
                .comment(historie.getComment())
                .historyDateTime(historie.getHistoryDateTime())
                .build();
        return historyEntity;
    }
}
