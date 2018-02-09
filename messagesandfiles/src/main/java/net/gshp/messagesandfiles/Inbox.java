package net.gshp.messagesandfiles;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import net.gshp.messagesandfiles.dto.DtoMessageAndFiles;
import net.gshp.messagesandfiles.listener.OnClickItemRecyclerViewLisener;
import net.gshp.messagesandfiles.model.ModelInbox;
import net.gshp.messagesandfiles.network.DownloadFile;
import net.gshp.messagesandfiles.util.ReadPropertiesAssets;

public class Inbox extends AppCompatActivity implements OnClickItemRecyclerViewLisener {

    private RecyclerView rcvInbox;
    private ModelInbox model;
    private LinearLayoutManager linearLayoutManager;

    public void init() {
        rcvInbox = findViewById(R.id.rcvInbox);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rcvInbox.setLayoutManager(linearLayoutManager);
        model = new ModelInbox(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_inbox);
        init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        rcvInbox.setAdapter(model.getAdapter(this));
    }

    @Override
    public void onClickItemRecyclerView(View view, int position, int request, Object obj) {
        DtoMessageAndFiles dtoMessageAndFiles = model.getItemPosition(position);
        if (dtoMessageAndFiles.getTypeModule() == getResources().getInteger(R.integer.type_module_message)) {
            startActivity(new Intent(this, Message.class).putExtra(getString(R.string.bundldeExtra), dtoMessageAndFiles.getIdItemRelation()));
        }else if(dtoMessageAndFiles.getTypeModule() == getResources().getInteger(R.integer.type_module_file)){
            new DownloadFile((ProgressBar) view).execute(dtoMessageAndFiles.getUrl(),new ReadPropertiesAssets().readPropertiesFile(this).getDataFilesPath(),null);
        }
    }
}
