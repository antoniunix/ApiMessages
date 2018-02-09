package net.gshp.messagesandfiles.dto;

/**
 * Created by gnu on 31/01/18.
 */

public class DtoMessage {

    private long id;
    private long idItemRelation;
    private int type;
    private String title;
    private String description;
    private String content;
    private String endDate;

    public long getId() {
        return id;
    }

    public DtoMessage setId(long id) {
        this.id = id;
        return this;
    }

    public long getIdItemRelation() {
        return idItemRelation;
    }

    public DtoMessage setIdItemRelation(long idItemRelation) {
        this.idItemRelation = idItemRelation;
        return this;
    }

    public int getType() {
        return type;
    }

    public DtoMessage setType(int type) {
        this.type = type;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public DtoMessage setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public DtoMessage setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getContent() {
        return content;
    }

    public DtoMessage setContent(String content) {
        this.content = content;
        return this;
    }

    public String getEndDate() {
        return endDate;
    }

    public DtoMessage setEndDate(String endDate) {
        this.endDate = endDate;
        return this;
    }
}
