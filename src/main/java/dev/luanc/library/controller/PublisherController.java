package dev.luanc.library.controller;

import dev.luanc.library.dto.publisher.PublisherDTO;
import dev.luanc.library.service.PublisherService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/publishers")
@AllArgsConstructor
@Tag(name = "Publisher", description = "Publisher Controller for publisher management")
public class PublisherController {
    private PublisherService publisherService;

    @PostMapping
    public ResponseEntity<PublisherDTO> addPublisher(@Valid @RequestBody PublisherDTO publisherDTO) {
        PublisherDTO publisher = publisherService.addPublisher(publisherDTO);
        return new ResponseEntity<>(publisher, HttpStatus.CREATED);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<PublisherDTO> getPublisher(@PathVariable Integer id) {
        PublisherDTO publisher = publisherService.getPublisherById(id);
        return new ResponseEntity<>(publisher, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PublisherDTO>> getAllPublishers() {
        return new ResponseEntity<>(publisherService.getAllPublishers(), HttpStatus.OK);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<PublisherDTO> updatePublisher(@Valid @PathVariable Integer id, @RequestBody PublisherDTO publisherDTO) {
        return new ResponseEntity<>(publisherService.updatePublisher(id, publisherDTO), HttpStatus.OK);
    }
}
