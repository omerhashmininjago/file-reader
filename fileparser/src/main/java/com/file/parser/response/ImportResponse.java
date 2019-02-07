package com.file.parser.response;


import java.util.List;

public final class ImportResponse {

    private List domainObjectList;

    public ImportResponse(){

    }

    public List getDomainObjectList() {
        return domainObjectList;
    }

    public void setDomainObjectList(List domainObjectList) {
        this.domainObjectList = domainObjectList;
    }
}
