package net.gshp.messagesandfiles.model;

import android.content.Context;

import net.gshp.messagesandfiles.adapter.RVInbox;
import net.gshp.messagesandfiles.dao.DaoFiles;
import net.gshp.messagesandfiles.dao.DaoMessages;
import net.gshp.messagesandfiles.dto.DtoMessageAndFiles;
import net.gshp.messagesandfiles.listener.OnClickItemRecyclerViewLisener;

import java.util.List;

/**
 * Created by gnu on 1/02/18.
 */

public class ModelInbox {

    private Context context;
    private List<DtoMessageAndFiles> lstMessageAndFiles;
    private RVInbox adapter;


    public ModelInbox(Context context) {
        this.context = context;
    }

    public RVInbox getAdapter(OnClickItemRecyclerViewLisener onClickItemRecyclerViewLisener) {
        lstMessageAndFiles = new DaoMessages(context).select();
        new DaoFiles(context).select(lstMessageAndFiles);
        return adapter = new RVInbox(context,lstMessageAndFiles, onClickItemRecyclerViewLisener);
    }

    public DtoMessageAndFiles getItemPosition(int position){
        return lstMessageAndFiles.get(position);

    }
}
