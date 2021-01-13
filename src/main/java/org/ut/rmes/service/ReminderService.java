package org.ut.rmes.service;

import org.ut.rmes.entity.Remind;

import java.util.List;

public interface ReminderService {
    List<Remind> getAll();

    Remind getByID(long remindID);

    Remind save(Remind remind);

    void remove(long id);
}
