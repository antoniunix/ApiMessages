package net.gshp.messagesandfiles.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import net.gshp.messagesandfiles.R;
import net.gshp.messagesandfiles.dto.DtoDataProperties;
import net.gshp.messagesandfiles.dto.DtoMessage;
import net.gshp.messagesandfiles.dto.DtoMessageAndFiles;
import net.gshp.messagesandfiles.sqliteTables.AppDB;
import net.gshp.messagesandfiles.util.ReadPropertiesAssets;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gnu on 1/02/18.
 */

public class DaoMessages {

    protected AppDB helper;
    protected SQLiteDatabase db;
    protected Cursor cursor;

    private final static String TABLE_NAME = "message";
    private final static String PK_FIELD = "id";


    private final static String ID = "id";
    private final static String ID_ITEM_RELATION = "id_item_relation";
    private final static String TYPE = "type";
    private final static String TITLE = "title";
    private final static String DESCRIPTION = "description";
    private final static String CONTENT = "content";
    private final static String END_DATE = "end_date";

    private Context context;

    public DaoMessages(Context context) {
        helper = new AppDB(context, new ReadPropertiesAssets().readPropertiesFile(context));
        this.context = context;
    }

    /**
     * Insert
     */
    public int insert(List<DtoMessage> obj) {
        db = helper.getWritableDatabase();
        int resp = 0;
        try {
            String qry = "INSERT INTO " +
                    TABLE_NAME + " (" + ID + "," + ID_ITEM_RELATION + "," + TYPE
                    + "," + TITLE + "," + DESCRIPTION + "," + CONTENT + "," + END_DATE + ") " +
                    "VALUES(?,?,?,?,?,?,?,?,?)";

            SQLiteStatement insStmnt = db.compileStatement(qry);
            db.beginTransaction();
            for (DtoMessage dto : obj) {
                try {
                    insStmnt.bindLong(1, dto.getId());
                } catch (Exception e) {
                    insStmnt.bindNull(1);
                }
                try {
                    insStmnt.bindLong(2, dto.getIdItemRelation());
                } catch (Exception e) {
                    insStmnt.bindNull(2);
                }
                try {
                    insStmnt.bindLong(3, dto.getType());
                } catch (Exception e) {
                    insStmnt.bindNull(3);
                }
                try {
                    insStmnt.bindString(4, dto.getTitle());
                } catch (Exception e) {
                    insStmnt.bindNull(4);
                }
                try {
                    insStmnt.bindString(5, dto.getDescription());
                } catch (Exception e) {
                    insStmnt.bindNull(5);
                }
                try {
                    insStmnt.bindString(6, dto.getContent());
                } catch (Exception e) {
                    insStmnt.bindNull(6);
                }
                try {
                    insStmnt.bindString(7, dto.getEndDate());
                } catch (Exception e) {
                    insStmnt.bindNull(7);
                }
                insStmnt.executeInsert();
            }
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
            db.close();
        }
        return resp;
    }

    public List<DtoMessageAndFiles> select() {
        db = helper.getReadableDatabase();

        String qry = "SELECT DISTINCT\n" +
                "message.id,\n" +
                "message.id_item_relation,\n" +
                "message.title,\n" +
                "message.description,\n" +
                "message.content,\n" +
                "message.end_date,\n" +
                "message.type\n" +
                "FROM\n" +
                "message";
        cursor = db.rawQuery(qry, null);
        List<DtoMessageAndFiles> obj = new ArrayList<>();
        DtoMessageAndFiles catalog;
        if (cursor.moveToFirst()) {
            int columnId = cursor.getColumnIndexOrThrow(ID);
            int columnIdItemRelation = cursor.getColumnIndexOrThrow(ID_ITEM_RELATION);
            int columnTitle = cursor.getColumnIndexOrThrow(TITLE);
            int columnDescription = cursor.getColumnIndexOrThrow(DESCRIPTION);
            int columnContent = cursor.getColumnIndexOrThrow(CONTENT);
            int columnEndDate = cursor.getColumnIndexOrThrow(END_DATE);
            int columnType = cursor.getColumnIndexOrThrow(TYPE);

            do {
                catalog = new DtoMessageAndFiles();
                catalog.setId(cursor.getLong(columnId));
                catalog.setIdItemRelation(cursor.getLong(columnIdItemRelation));
                catalog.setTitle(cursor.getString(columnTitle));
                catalog.setDescription(cursor.getString(columnDescription));
                catalog.setContent(cursor.getString(columnContent));
                catalog.setEndDate(cursor.getString(columnEndDate));
                catalog.setType(cursor.getInt(columnType));
                catalog.setTypeModule(context.getResources().getInteger(R.integer.type_module_message));
                obj.add(catalog);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return obj;
    }

    public DtoMessageAndFiles selectMessageById(long id) {
        db = helper.getReadableDatabase();

        String qry = "SELECT DISTINCT\n" +
                "message.id,\n" +
                "message.id_item_relation,\n" +
                "message.title,\n" +
                "message.description,\n" +
                "message.content,\n" +
                "message.end_date,\n" +
                "message.type\n" +
                "FROM\n" +
                "message\n" +
                "WHERE message.id_item_relation=" + id;
        cursor = db.rawQuery(qry, null);
        DtoMessageAndFiles catalog = new DtoMessageAndFiles();
        if (cursor.moveToFirst()) {
            int columnId = cursor.getColumnIndexOrThrow(ID);
            int columnIdItemRelation = cursor.getColumnIndexOrThrow(ID_ITEM_RELATION);
            int columnTitle = cursor.getColumnIndexOrThrow(TITLE);
            int columnDescription = cursor.getColumnIndexOrThrow(DESCRIPTION);
            int columnContent = cursor.getColumnIndexOrThrow(CONTENT);
            int columnEndDate = cursor.getColumnIndexOrThrow(END_DATE);
            int columnType = cursor.getColumnIndexOrThrow(TYPE);

            catalog.setId(cursor.getLong(columnId));
            catalog.setIdItemRelation(cursor.getLong(columnIdItemRelation));
            catalog.setTitle(cursor.getString(columnTitle));
            catalog.setDescription(cursor.getString(columnDescription));
            catalog.setContent(cursor.getString(columnContent));
            catalog.setEndDate(cursor.getString(columnEndDate));
            catalog.setType(cursor.getInt(columnType));
            catalog.setTypeModule(context.getResources().getInteger(R.integer.type_module_message));
        }
        cursor.close();
        db.close();
        return catalog;
    }
}
