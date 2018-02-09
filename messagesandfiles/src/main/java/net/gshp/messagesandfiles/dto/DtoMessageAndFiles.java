package net.gshp.messagesandfiles.dto;

/**
 * Created by gnu on 1/02/18.
 */

public class DtoMessageAndFiles {
    private long id;
    private long idItemRelation;
    private int type;
    private String title;
    private String description;
    private String content;
    private String endDate;
    private String extention;
    private String md5;
    private String url;
    private long lastUpdate;
    private int typeModule;

    public long getId() {
        return id;
    }

    public DtoMessageAndFiles setId(long id) {
        this.id = id;
        return this;
    }

    public long getIdItemRelation() {
        return idItemRelation;
    }

    public DtoMessageAndFiles setIdItemRelation(long idItemRelation) {
        this.idItemRelation = idItemRelation;
        return this;
    }

    public int getType() {
        return type;
    }

    public DtoMessageAndFiles setType(int type) {
        this.type = type;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public DtoMessageAndFiles setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public DtoMessageAndFiles setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getContent() {
        return content;
    }

    public DtoMessageAndFiles setContent(String content) {
        this.content = content;
        return this;
    }

    public String getEndDate() {
        return endDate;
    }

    public DtoMessageAndFiles setEndDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    public String getExtention() {
        return extention;
    }

    public DtoMessageAndFiles setExtention(String extention) {
        this.extention = extention;
        return this;
    }

    public String getMd5() {
        return md5;
    }

    public DtoMessageAndFiles setMd5(String md5) {
        this.md5 = md5;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public DtoMessageAndFiles setUrl(String url) {
        this.url = url;
        return this;
    }

    public long getLastUpdate() {
        return lastUpdate;
    }

    public DtoMessageAndFiles setLastUpdate(long lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }

    public int getTypeModule() {
        return typeModule;
    }

    public DtoMessageAndFiles setTypeModule(int typeModule) {
        this.typeModule = typeModule;
        return this;
    }


}
