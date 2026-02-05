package dev.luanc.library.mapper;

import dev.luanc.library.dto.publisher.PublisherDTO;
import dev.luanc.library.model.Publisher;
import org.apache.catalina.mapper.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class PublisherMapper {
    public static Publisher toEntity(PublisherDTO publisherReq) {
        return Publisher.builder()
                .name(publisherReq.name())
                .country(publisherReq.country())
                .build();
    }

    public static PublisherDTO toPublisherDTO(Publisher publisher) {
        return new PublisherDTO(
                publisher.getName(),
                publisher.getCountry()
        );
    }

    public static List<PublisherDTO> toPublisherDTOList(List<Publisher> publisher) {
        return publisher.stream()
                .map(PublisherMapper::toPublisherDTO)
                .toList();
    }
}
