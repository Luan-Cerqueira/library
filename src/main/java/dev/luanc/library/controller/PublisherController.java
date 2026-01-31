package dev.luanc.library.controller;

import dev.luanc.library.dto.author.AuthorDTO;
import dev.luanc.library.dto.publisher.PublisherDTO;
import dev.luanc.library.model.Publisher;
import dev.luanc.library.service.PublisherService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publishers")
@AllArgsConstructor
public class PublisherController {
    private PublisherService publisherService;

    @PostMapping
    public ResponseEntity<PublisherDTO> addPublisher(@RequestBody PublisherDTO publisherDTO) {
        PublisherDTO publisher = publisherService.addPublisher(publisherDTO);
        return new ResponseEntity<>(publisher, HttpStatus.CREATED);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<PublisherDTO> getPublisher(@PathVariable Integer id) {
        PublisherDTO publisher = publisherService.getPublisherById(id);
        return new ResponseEntity<>(publisher, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Publisher>> getAllPublishers() {
        return new ResponseEntity<>(publisherService.getAllPublishers(), HttpStatus.OK);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<PublisherDTO> updatePublisher(@PathVariable Integer id, @RequestBody PublisherDTO publisherDTO) {
        return new ResponseEntity<>(publisherService.updatePublisher(id, publisherDTO), HttpStatus.OK);
    }
}
