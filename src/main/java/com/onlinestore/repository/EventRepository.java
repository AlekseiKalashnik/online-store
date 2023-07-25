package com.onlinestore.repository;

import com.onlinestore.entity.Classifier;
import com.onlinestore.entity.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
    public Page<Event> findAllByClassifier(Classifier classifier, Pageable pageable);
}
