package dev.luanc.library.service;

import dev.luanc.library.dto.publisher.PublisherDTO;
import dev.luanc.library.mapper.PublisherMapper;
import dev.luanc.library.model.Publisher;
import dev.luanc.library.repository.PublisherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PublisherService {
    private final PublisherRepository publisherRepository;

    public PublisherDTO addPublisher(PublisherDTO publisherReq) {
        Publisher publisher = publisherRepository.save(PublisherMapper.toEntity(publisherReq));
        return PublisherMapper.toPublisherDTO(publisher);
    }

    public PublisherDTO updatePublisher(int id, PublisherDTO publisherReq) {
        Publisher updatedPublisher = publisherRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Publisher not found"));
        updatedPublisher.setName(
                publisherReq.name() != null ? publisherReq.name() : updatedPublisher.getName());
        updatedPublisher.setCountry(
                publisherReq.country() != null ? publisherReq.country() : updatedPublisher.getCountry());
        return PublisherMapper.toPublisherDTO(publisherRepository.save(updatedPublisher));
    }

    public List<PublisherDTO> getAllPublishers() {
        return PublisherMapper.toPublisherDTOList(publisherRepository.findAll());
    }

    public PublisherDTO getPublisherById(int id) {
        return PublisherMapper.
                toPublisherDTO(publisherRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Publisher not found")));
    }
}
