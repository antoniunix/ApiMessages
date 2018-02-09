package net.gshp.messagesandfiles.dto;

/**
 * Created by gnu on 31/01/18.
 */

public class DtoMessageFileViewed {

    private long id;
    private long idItemRelation;
    private long date;
    private String tz;
    private String imei;
    private String hash;
    private int typeModule;
    private boolean send;

    public long getId() {
        return id;
    }

    public DtoMessageFileViewed setId(long id) {
        this.id = id;
        return this;
    }

    public long getIdItemRelation() {
        return idItemRelation;
    }

    public DtoMessageFileViewed setIdItemRelation(long idItemRelation) {
        this.idItemRelation = idItemRelation;
        return this;
    }

    public long getDate() {
        return date;
    }

    public DtoMessageFileViewed setDate(long date) {
        this.date = date;
        return this;
    }

    public String getTz() {
        return tz;
    }

    public DtoMessageFileViewed setTz(String tz) {
        this.tz = tz;
        return this;
    }

    public String getImei() {
        return imei;
    }

    public DtoMessageFileViewed setImei(String imei) {
        this.imei = imei;
        return this;
    }

    public String getHash() {
        return hash;
    }

    public DtoMessageFileViewed setHash(String hash) {
        this.hash = hash;
        return this;
    }

    public int getTypeModule() {
        return typeModule;
    }

    public DtoMessageFileViewed setTypeModule(int typeModule) {
        this.typeModule = typeModule;
        return this;
    }

    public boolean isSend() {
        return send;
    }

    public DtoMessageFileViewed setSend(boolean send) {
        this.send = send;
        return this;
    }
}
