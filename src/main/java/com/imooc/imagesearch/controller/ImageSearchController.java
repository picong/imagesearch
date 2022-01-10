package com.imooc.imagesearch.controller;

import com.imooc.imagesearch.model.ImageMeta;
import com.imooc.imagesearch.service.ImageMetaService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/image/")
public class ImageSearchController {

    @Resource
    private ImageMetaService imageMetaService;

    @GetMapping("search")
    public Page<ImageMeta> search(String keyword, int pageNum, int pageSize) throws UnsupportedEncodingException {

        return imageMetaService.findByKeyword(keyword, pageNum, pageSize);
    }

}
