package com.imooc.imagesearch;

import com.imooc.imagesearch.service.ImageMetaService;
import com.imooc.imagesearch.util.ParseFileNameUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class ImagesearchApplicationTests {

    @Resource
    private ImageMetaService imageMetaService;

//    @Test
    void batchSaveTest() {
        imageMetaService.batchSave(ParseFileNameUtils.foreachDir("E:\\所有图集合\\所有图集合"));
    }

}
