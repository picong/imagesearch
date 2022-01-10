package com.imooc.imagesearch.service;

import com.imooc.imagesearch.model.ImageMeta;
import org.springframework.data.domain.Page;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface ImageMetaService {

    ImageMeta save(ImageMeta imageMeta);

    void deleteIndex(String index);

    Page<ImageMeta> findByKeyword(String keyword, int pageNum, int pageSize) throws UnsupportedEncodingException;

    void batchSave(List<ImageMeta> metaList);

}
