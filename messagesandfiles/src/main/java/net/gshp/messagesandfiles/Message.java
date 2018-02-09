package net.gshp.messagesandfiles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import net.gshp.messagesandfiles.dao.DaoMessages;
import net.gshp.messagesandfiles.dto.DtoMessageAndFiles;
import net.gshp.messagesandfiles.model.ModelMessage;

public class Message extends AppCompatActivity implements View.OnClickListener {

    private long idMessage;
    private DtoMessageAndFiles dtoMessageAndFiles;
    private ModelMessage model;
    private TextView txtTitle;
    private WebView wbvMessage;
    private Button btnNext;

    private void init() {
        idMessage = getIntent().getLongExtra(getResources().getString(R.string.bundldeExtra), 0);
        model = new ModelMessage(this);
        dtoMessageAndFiles = model.getMessage(idMessage);
        txtTitle = findViewById(R.id.txtTitle);
        wbvMessage = findViewById(R.id.wbvMessage);
        btnNext = findViewById(R.id.btnNext);

        btnNext.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        getSupportActionBar().hide();
        init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        txtTitle.setText(dtoMessageAndFiles.getTitle());
        wbvMessage.loadData(dtoMessageAndFiles.getContent(), "text/html", "UTF-8");
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
