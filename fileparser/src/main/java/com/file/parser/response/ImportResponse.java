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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ImportResponse{");
        sb.append("domainObjectList=").append(domainObjectList);
        sb.append('}');
        return sb.toString();
    }
}
