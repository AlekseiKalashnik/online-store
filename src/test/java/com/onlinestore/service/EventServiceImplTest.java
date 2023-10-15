//package com.onlinestore.service;
//
//import com.onlinestore.dto.EventDTO;
//import com.onlinestore.entity.Classifier;
//import com.onlinestore.entity.Event;
//import com.onlinestore.repository.EventRepository;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestInstance;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.ArgumentCaptor;
//import org.mockito.Captor;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.modelmapper.ModelMapper;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//
//import java.util.List;
//import java.util.stream.Stream;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.mockito.Mockito.when;
//
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//@ExtendWith(MockitoExtension.class)
//class EventServiceImplTest {
//
//    List<Event> eventList;
//
//    @Captor
//    private ArgumentCaptor<String> argumentCaptor;
//    @Mock
//    private EventRepository eventRepository;
//    @Mock
//    private ModelMapper modelMapper;
//    @InjectMocks
//    private EventServiceImpl eventService;
//
//    @BeforeAll
//    void init() {
//        eventList = List.of(
//                new Event("A", Classifier.MEETING),
//                new Event("B", Classifier.INCOME),
//                new Event("C", Classifier.NOTE));
//    }
//
//    @Test
//    void getAllEvents() {
//        when(eventService.getAllEvents(0, 3)).thenReturn(eventList.stream().map());
//        List<EventDTO> expectedList = eventService.getAllEvents(0, 3);
//        assertNotNull(expectedList);
//        assertEquals(expectedList.size(), eventList.size());
//        assertEquals(expectedList, eventList);
//
//    }
//
//    @Test
//    void getAllEventsWithClassifier() {
//    }
//
//    @Test
//    void getPlantPage() {
//        List<Event> eventList = Stream.of(
//                new Event("A", Classifier.MEETING),
//                new Event("B", Classifier.INCOME),
//                new Event("C", Classifier.NOTE))
//                .toList();
//        Pageable pageable = PageRequest.of(0, 3, Sort.by("date"));
//        when(eventRepository.findAll()).thenReturn(eventList);
//
//        assertEquals(pageable.getPageSize(), eventList.size());
//    }
//
//    @Test
//    void getPlantPageByClassifier() {
//    }
//
//    @Test
//    void saveEvent() {
//    }
//
//    @Test
//    void shouldConvertToEvent() {
//        EventDTO dto = EventDTO.builder()
//                .name("T")
//                .classifier(Classifier.MEETING)
//                .build();
//
//        Event expectedResult = new Event("T", Classifier.MEETING);
//
//        Event actualResult = modelMapper.map(dto, Event.class);
//
//        assertEquals(expectedResult, actualResult);
//    }
//
//    @Test
//    void shouldConvertToEventDTO() {
//    }
//}
