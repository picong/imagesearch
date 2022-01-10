package com.imooc.imagesearch.service.impl;

import com.imooc.imagesearch.model.ImageMeta;
import com.imooc.imagesearch.repository.ImageMetaRepository;
import com.imooc.imagesearch.service.ImageMetaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

@Service
public class ImageMetaServiceImpl implements ImageMetaService {

    @Resource
    private ImageMetaRepository imageMetaRepository;
    @Resource
    private ElasticsearchRestTemplate elasticsearchTemplate;

    @Override
    public ImageMeta save(ImageMeta imageMeta) {
        return imageMetaRepository.save(imageMeta);
    }

    @Override
    public void deleteIndex(String index) {
//        elasticsearchTemplate.deleteIndex(index);
    }

    @Override
    public Page<ImageMeta> findByKeyword(String keyword, int pageNum, int pageSize) throws UnsupportedEncodingException {
        if (pageNum <= 0) {
            pageNum = 0;
        } else {
            pageNum -= 1;
        }
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<ImageMeta> imageMetas = imageMetaRepository.findByName(keyword, pageable);
        if (!CollectionUtils.isEmpty(imageMetas.getContent())) {
            for (ImageMeta imageMeta : imageMetas.getContent()) {
                String encode = URLEncoder.encode(imageMeta.getPath(), "UTF-8");
                imageMeta.setPath(encode);
            }
        }
        return imageMetas;
    }

    @Override
    public void batchSave(List<ImageMeta> metaList) {
        imageMetaRepository.saveAll(metaList);
    }

}
