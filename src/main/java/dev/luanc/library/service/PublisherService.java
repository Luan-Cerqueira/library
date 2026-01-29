package dev.luanc.library.service;

import dev.luanc.library.model.Publisher;
import dev.luanc.library.repository.PublisherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PublisherService {
    private final PublisherRepository publisherRepository;

    public Publisher addPublisher(Publisher publisher){
        return publisherRepository.save(publisher);
    }
    public Publisher updatePublisher(int id, Publisher publisher){
        Publisher updatedPublisher = publisherRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Publisher not found"));
        updatedPublisher.setName(
                publisher.getName() != null ? publisher.getName() : updatedPublisher.getName());
        updatedPublisher.setCountry(
                publisher.getCountry() != null ? publisher.getCountry() : updatedPublisher.getCountry());
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
