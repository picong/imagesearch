package com.imooc.imagesearch.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

@Data
@Document(indexName = "imagemeata")
public class ImageMeta {
    @Id
    private String id;

    @Field("file_name")
    private String fileName;

    @Field("path")
    private String path;
}
