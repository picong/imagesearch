package com.imooc.imagesearch.repository;

import com.imooc.imagesearch.model.ImageMeta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ImageMetaRepository extends ElasticsearchRepository<ImageMeta, String> {

    @Query("{\"match_phrase\":{\"path\":\"?0\"}}")
    Page<ImageMeta> findByName(String keyword, Pageable pageable);
}
