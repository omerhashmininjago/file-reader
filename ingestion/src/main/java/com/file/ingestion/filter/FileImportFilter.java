package com.file.ingestion.filter;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class FileImportFilter {

    private FileFilter fileFilter;
    private MultipartFile multipartFile;

}
