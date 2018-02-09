package net.gshp.messagesandfiles.dto;

/**
 * Created by gnu on 1/02/18.
 */

public class DtoDataProperties {

    private String dataBasePath;
    private String dataFilesPath;
    private int dataBaseVersion;

    public String getDataBasePath() {
        return dataBasePath;
    }

    public DtoDataProperties setDataBasePath(String dataBasePath) {
        this.dataBasePath = dataBasePath;
        return this;
    }

    public int getDataBaseVersion() {
        return dataBaseVersion;
    }

    public DtoDataProperties setDataBaseVersion(int dataBaseVersion) {
        this.dataBaseVersion = dataBaseVersion;
        return this;
    }

    public String getDataFilesPath() {
        return dataFilesPath;
    }

    public DtoDataProperties setDataFilesPath(String dataFilesPath) {
        this.dataFilesPath = dataFilesPath;
        return this;
    }
}
