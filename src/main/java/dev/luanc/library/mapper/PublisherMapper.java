package dev.luanc.library.mapper;

import dev.luanc.library.dto.publisher.PublisherDTO;
import dev.luanc.library.model.Publisher;

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
}
