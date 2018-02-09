package net.gshp.messagesandfiles.model;

import android.content.Context;

import net.gshp.messagesandfiles.dao.DaoMessages;
import net.gshp.messagesandfiles.dto.DtoMessage;
import net.gshp.messagesandfiles.dto.DtoMessageAndFiles;

/**
 * Created by gnu on 7/02/18.
 */

public class ModelMessage {
    private Context context;

    public ModelMessage(Context context) {
        this.context = context;
    }

    public DtoMessageAndFiles getMessage(long idMessage) {
        return new DaoMessages(context).selectMessageById(idMessage);
    }


}
