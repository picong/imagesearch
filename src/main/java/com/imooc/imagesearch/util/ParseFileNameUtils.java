package com.imooc.imagesearch.util;

import com.imooc.imagesearch.model.ImageMeta;
import lombok.extern.slf4j.Slf4j;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * 递归文件目录，将所有文件遍历一次
 */
@Slf4j
public class ParseFileNameUtils {


    private static List<ImageMeta> list = new ArrayList<>();

    public static List<ImageMeta> foreachDir(String absolutePath) {

        Path path = Paths.get(absolutePath);
        try (Stream<Path> pathStream = Files.list(path)) {
            pathStream.forEach(path1 -> {
               if (Files.isRegularFile(path1)) {
                   Path filePath = path1.getFileName();
                   String pathStr = path1.getParent().getFileName() + "/" + filePath.toString();
                   ImageMeta imageMeta = new ImageMeta();
                   imageMeta.setFileName(filePath.toString());
                   imageMeta.setPath(pathStr);
                   list.add(imageMeta);
                   return;
               }
               foreachDir(path1.toAbsolutePath().toString());
            });
        } catch (Exception e) {
           log.error("遍历图片失败 e: {}", e);
        }

        return list;
    }

    public static void main(String[] args) {
        List<ImageMeta> imageMetas = foreachDir("E:\\所有图集合\\所有图集合");
        System.out.println(imageMetas);
    }
}
