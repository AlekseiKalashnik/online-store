package com.onlinestore.controller;

import com.onlinestore.dto.EventDTO;
import com.onlinestore.exception.EventNotCreatedException;
import com.onlinestore.service.EventServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/events")
public class EventController {

    private final EventServiceImpl eventserviceImpl;

    @GetMapping("/{pageNumber}/{pageSize}")
    public ResponseEntity<List<EventDTO>> getAllEvents(@PathVariable Integer pageNumber,
                                                       @PathVariable Integer pageSize) {
        List<EventDTO> resultList = eventserviceImpl.getAllEvents(pageNumber, pageSize);
        return new ResponseEntity<>(resultList, HttpStatus.OK);
    }

    @GetMapping("/{pageNumber}/{pageSize}/{classifier}")
    public ResponseEntity<List<EventDTO>> getAllEventsWithClassifier(@PathVariable Integer pageNumber,
                                                                     @PathVariable Integer pageSize,
                                                                     @PathVariable(name = "classifier", required = false) String classifier) {
        List<EventDTO> resultList = eventserviceImpl.getAllEventsWithClassifier(pageNumber, pageSize, classifier);
        return new ResponseEntity<>(resultList, HttpStatus.OK);
    }

    @PostMapping("/addEvent")
    public ResponseEntity<HttpStatus> addEvent(@RequestBody @Valid EventDTO eventDTO,
                                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder builderErrMessage = new StringBuilder();

            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                builderErrMessage.append(error.getField())
                        .append(" - ")
                        .append(error.getDefaultMessage())
                        .append(";");
            }
            throw new EventNotCreatedException(builderErrMessage.toString());
        }
        eventserviceImpl.saveEvent(eventDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
