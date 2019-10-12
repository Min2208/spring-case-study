package com.codegym.service;

import com.codegym.model.Position;

import java.util.List;

public interface PositionService {
    Iterable<Position> findAll();

    Position findOne(long id);

    List<Position> save(List<Position> positions);

    List<Position> findAll(List<Long> ids);

    long count();

    void delete(long id);

    void delete(Position position);

    void delete(List<Position> positions);

    void deleteAll();


}
