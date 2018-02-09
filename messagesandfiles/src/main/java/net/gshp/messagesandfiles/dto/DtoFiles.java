package net.gshp.messagesandfiles.dto;

/**
 * Created by gnu on 31/01/18.
 */

public class DtoFiles {

    private long id;
    private long idMessageFilesHead;
    private long idItemRelation;
    private String title;
    private String description;
    private String extention;
    private String md5;
    private String url;
    private long lastUpdate;

    public long getId() {
        return id;
    }

    public DtoFiles setId(long id) {
        this.id = id;
        return this;
    }

    public long getIdMessageFilesHead() {
        return idMessageFilesHead;
    }

    public DtoFiles setIdMessageFilesHead(long idMessageFilesHead) {
        this.idMessageFilesHead = idMessageFilesHead;
        return this;
    }

    public long getIdItemRelation() {
        return idItemRelation;
    }

    public DtoFiles setIdItemRelation(long idItemRelation) {
        this.idItemRelation = idItemRelation;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public DtoFiles setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public DtoFiles setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getExtention() {
        return extention;
    }

    public DtoFiles setExtention(String extention) {
        this.extention = extention;
        return this;
    }

    public String getMd5() {
        return md5;
    }

    public DtoFiles setMd5(String md5) {
        this.md5 = md5;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public DtoFiles setUrl(String url) {
        this.url = url;
        return this;
    }

    public long getLastUpdate() {
        return lastUpdate;
    }

    public DtoFiles setLastUpdate(long lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }
}
