package com.onlinestore.service;

import com.onlinestore.dto.EventDTO;
import com.onlinestore.entity.Classifier;
import com.onlinestore.entity.Event;
import com.onlinestore.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EventServiceImpl implements EventService{
    private final EventRepository eventRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<EventDTO> getAllEvents(Integer pageNumber, Integer pageSize) {
        log.info("begin getAllEvents()");
        return getPlantPage(pageNumber, pageSize)
                .getContent()
                .stream()
                .map(this::convertToEventDTO)
                .toList();
    }

    @Override
    public List<EventDTO> getAllEventsWithClassifier(Integer pageNumber,
                                                     Integer pageSize,
                                                     String classifier) {
        log.info("begin getAllEvents()");
        return getPlantPageByClassifier(pageNumber, pageSize, Classifier.valueOf(classifier))
                .getContent()
                .stream()
                .map(this::convertToEventDTO)
                .toList();
    }

    public Page<Event> getPlantPage(Integer pageNumber, Integer pageSize) {
        log.info("begin getPlantPage()");
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("date"));
        return eventRepository.findAll(pageable);
    }

    public Page<Event> getPlantPageByClassifier(Integer pageNumber,
                                                Integer pageSize,
                                                Classifier classifier) {
        log.info("begin getPlantPageByClassifier()");
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("date"));
        return eventRepository.findAllByClassifier(classifier, pageable);
    }

    @Transactional
    public void saveEvent(EventDTO eventDTO) {
        log.info("begin addEvent()");
        Event event = convertToEvent(eventDTO);
        enrich(event);
        eventRepository.save(event);
        log.info("event has saved");
    }

    public void enrich(Event event) {
        event.setDate(LocalDateTime.now());
    }

    private Event convertToEvent(EventDTO eventDTO) {
        return modelMapper.map(eventDTO, Event.class);
    }

    private EventDTO convertToEventDTO(Event event) {
        return modelMapper.map(event, EventDTO.class);
    }
}
