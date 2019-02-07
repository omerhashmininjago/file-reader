package com.file.ingestion.filter;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class FileFilter {

    @NotNull
    private String systemName;

    @NotNull
    private String statementType;

}
