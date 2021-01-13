package org.ut.rmes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ut.rmes.entity.Remind;
import org.ut.rmes.repository.RemindRepository;

import java.util.List;

@Service
public class RemindServiceImpl implements ReminderService {

    @Autowired
    private RemindRepository repository;

    @Override
    public List<Remind> getAll() {
        System.out.println("repos " + repository);
        return repository.findAll();
    }

    @Override
    public Remind getByID(long remindID) {
        return repository.getOne(remindID);
    }

    @Override
    public Remind save(Remind remind) {
        System.out.println("reminder: " + remind.getId());
        return repository.saveAndFlush(remind);
    }

    @Override
    public void remove(long id) {
        repository.deleteById(id);
    }
}
