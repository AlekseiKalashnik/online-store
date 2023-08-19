package com.onlinestore.controller;

import com.onlinestore.dto.EventDTO;
import com.onlinestore.exception.EventNotCreatedException;
import com.onlinestore.service.EventServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Event controller")
@RequestMapping("api/v1/events")
public class EventController {

    private final EventServiceImpl eventserviceImpl;

    @GetMapping("/{pageNumber}/{pageSize}")
    @Operation(
            summary = "Get events",
            description = "Show list of events with pagination"
    )
    public ResponseEntity<List<EventDTO>> getAllEvents(
            @PathVariable @Min(0) @Parameter(description = "Number of pages, must be greater than 0") Integer pageNumber,
            @PathVariable @Min(1) @Parameter(description = "Number of lines, must be greater than 1 ") Integer pageSize) {
        List<EventDTO> resultList = eventserviceImpl.getAllEvents(pageNumber, pageSize);
        return new ResponseEntity<>(resultList, HttpStatus.OK);
    }

    @GetMapping("/{pageNumber}/{pageSize}/{classifier}")
    @Operation(
            summary = "Get events by classifier",
            description = "Show list of events with pagination and classifier"
    )
    public ResponseEntity<List<EventDTO>> getAllEventsWithClassifier(
            @PathVariable @Min(0) @Parameter(description = "Number of pages, must be greater than 0") Integer pageNumber,
            @PathVariable @Min(1) @Parameter(description = "Number of lines, must be greater than 1 ") Integer pageSize,
            @PathVariable @Parameter(description = "Accepted values: OUTCOME, TASK, INCOME, MEETING, ASSIGNMENT, NOTE") String classifier) {
        List<EventDTO> resultList = eventserviceImpl.getAllEventsWithClassifier(pageNumber, pageSize, classifier);
        return ResponseEntity.ok(resultList);
    }

    @PostMapping("/event")
    @Operation(
            summary = "Add event",
            description = "Create new event in the store"
    )
    public ResponseEntity<HttpStatus> addEvent(@Valid @RequestBody EventDTO eventDTO, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
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
        return ResponseEntity.ok().build();
    }
}
