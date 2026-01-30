package dev.luanc.library.service;

import dev.luanc.library.dto.publisher.publisherRequest;
import dev.luanc.library.model.Publisher;
import dev.luanc.library.repository.PublisherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PublisherService {
    private final PublisherRepository publisherRepository;

    public Publisher addPublisher(publisherRequest publisherReq){
        Publisher newPublisher = new Publisher();
        newPublisher.setName(publisherReq.name());
        newPublisher.setCountry(publisherReq.country());
        return publisherRepository.save(newPublisher);
    }
    public Publisher updatePublisher(int id, publisherRequest publisherReq){
        Publisher updatedPublisher = publisherRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Publisher not found"));
        updatedPublisher.setName(
                publisherReq.name() != null ? publisherReq.name() : updatedPublisher.getName());
        updatedPublisher.setCountry(
                publisherReq.country() != null ? publisherReq.country() : updatedPublisher.getCountry());
        return publisherRepository.save(updatedPublisher);
    }
    public List<Publisher> getAllPublishers(){
        return publisherRepository.findAll();
    }
    public Publisher getPublisherById(int id){
        return publisherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Publisher not found"));
    }
}
