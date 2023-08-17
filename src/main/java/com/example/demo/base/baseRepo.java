package com.example.demo.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface baseRepo<E extends BaseEntity> extends JpaRepository<E,Long> {
}
