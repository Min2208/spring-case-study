package com.codegym.service.ipml;

import com.codegym.model.Position;
import com.codegym.repository.PositionRepository;
import com.codegym.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionRepository positionRepository;

    @Override
    public Iterable<Position> findAll() {
        return positionRepository.findAll();
    }

    @Override
    public Position findOne(long id) {
        return null;
    }

    @Override
    public List<Position> save(List<Position> positions) {
        return null;
    }

    @Override
    public List<Position> findAll(List<Long> ids) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public void delete(Position position) {

    }

    @Override
    public void delete(List<Position> positions) {

    }

    @Override
    public void deleteAll() {

    }
}
