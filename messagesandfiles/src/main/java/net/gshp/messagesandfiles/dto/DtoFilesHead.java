package net.gshp.messagesandfiles.dto;

/**
 * Created by gnu on 31/01/18.
 */

public class DtoFilesHead {
    private long id;
    private String description;
    private String startDate;
    private String endDate;

    public long getId() {
        return id;
    }

    public DtoFilesHead setId(long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public DtoFilesHead setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getStartDate() {
        return startDate;
    }

    public DtoFilesHead setStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    public String getEndDate() {
        return endDate;
    }

    public DtoFilesHead setEndDate(String endDate) {
        this.endDate = endDate;
        return this;
    }
}
