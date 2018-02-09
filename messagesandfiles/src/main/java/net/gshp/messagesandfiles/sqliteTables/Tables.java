package net.gshp.messagesandfiles.sqliteTables;

/**
 * Created by gnu on 31/01/18.
 */

public class Tables {

    public final static String TABLE_FILES_HEAD = "CREATE TABLE IF NOT EXISTS files_head(" +
            "id INTEGER," +
            "description TEXT," +
            "start_date TEXT," +
            "end_date TEXT)";

    public final static String TABLE_FILES = "CREATE TABLE IF NOT EXISTS files(" +
            "id INTEGER," +
            "id_message_files_head INTEGER," +
            "id_item_relation INTEGER," +
            "title TEXT," +
            "description TEXT," +
            "extention TEXT," +
            "md5 TEXT," +
            "url TEXT," +
            "last_update INTEGER)";

    public final static String TABLE_MESSAGES = "CREATE TABLE IF NOT EXISTS message(" +
            "id INTEGER," +
            "id_item_relation INTEGER," +
            "type INTEGER," +
            "title TEXT," +
            "description TEXT," +
            "content TEXT," +
            "end_date TEXT)";

    public final static String TABLE_MESSAGE_FILE_VIEWED = "CREATE TABLE IF NOT EXISTS message_file_viewed(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
            "id_item_relation INTEGER," +
            "date INTEGER," +
            "tz TEXT," +
            "imei TEXT," +
            "hash TEXT," +
            "type_module INTEGER," +
            "send INTEGER)";
}
