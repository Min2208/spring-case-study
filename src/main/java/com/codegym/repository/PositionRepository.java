package com.codegym.repository;

import com.codegym.model.Position;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PositionRepository extends CrudRepository<Position, Long> {
}
