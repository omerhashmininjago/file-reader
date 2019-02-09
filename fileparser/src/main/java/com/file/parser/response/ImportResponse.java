package com.file.parser.response;


import java.util.List;

public final class ImportResponse<T> {

    private List<T> domainObjectList;

    public ImportResponse() {

    }

    public List<T> getDomainObjectList() {
        return domainObjectList;
    }

    public void setDomainObjectList(List<T> domainObjectList) {
        this.domainObjectList = domainObjectList;
    }
}
