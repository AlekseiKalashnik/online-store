package com.onlinestore.service;

import com.onlinestore.dto.EventDTO;

import java.util.List;

public interface EventService {
     List<EventDTO> getAllEvents(Integer pageNumber, Integer pageSize);
     List<EventDTO> getAllEventsWithClassifier(Integer pageNumber, Integer pageSize, String classifier);
}
