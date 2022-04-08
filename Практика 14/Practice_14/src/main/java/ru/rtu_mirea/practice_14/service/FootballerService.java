package ru.rtu_mirea.practice_14.service;

import ru.rtu_mirea.practice_14.Footballer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FootballerService {
    private List<Footballer> footballerList;

    public FootballerService() {
        footballerList = new ArrayList<>();
        initialize();
    }

    private void initialize() {
        footballerList.add(new Footballer("Platon", "Sorokin"));
        footballerList.add(new Footballer("Alexandr", "Ivanov"));
        footballerList.add(new Footballer("Artemij", "Ivachev"));
    }

    public void add (Footballer footballer) {
        footballerList.add(footballer);
    }

    public List<Footballer> getAll() {
        return footballerList;
    }

    public void delete(Footballer footballer) {
        footballerList.remove(footballer);
    }
}
