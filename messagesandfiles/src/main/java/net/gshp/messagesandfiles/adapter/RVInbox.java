package net.gshp.messagesandfiles.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import net.gshp.messagesandfiles.R;
import net.gshp.messagesandfiles.dto.DtoMessageAndFiles;
import net.gshp.messagesandfiles.listener.OnClickItemRecyclerViewLisener;

import java.util.List;

/**
 * Created by gnu on 1/02/18.
 */

public class RVInbox extends RecyclerView.Adapter<RVInbox.ViewHolder> {

    private List<DtoMessageAndFiles> lstInbox;
    private OnClickItemRecyclerViewLisener OnClickItemRecyclerViewLisener;
    private Context context;

    public RVInbox(Context context, List<DtoMessageAndFiles> lstInbox, OnClickItemRecyclerViewLisener OnClickItemRecyclerViewLisener) {
        this.lstInbox = lstInbox;
        this.context = context;
        this.OnClickItemRecyclerViewLisener = OnClickItemRecyclerViewLisener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_inbox, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        DtoMessageAndFiles dto = lstInbox.get(position);
        holder.txtTitle.setText(dto.getTitle());
        holder.txtDescription.setText(dto.getDescription());
        holder.txtDate.setText(dto.getEndDate());

        if (dto.getTypeModule() == context.getResources().getInteger(R.integer.type_module_message)) {
            switch (dto.getType()) {

                case 1:
                    holder.imgType.setImageResource(R.drawable.ic_warning_black_24dp);
                    break;
                case 2:
                    holder.imgType.setImageResource(R.drawable.ic_info_black_24dp);
                    break;
                case 3:
                    holder.imgType.setImageResource(R.drawable.ic_computer_black_24dp);
                    break;

                default:
                    holder.imgType.setImageResource(R.drawable.ic_warning_black_24dp);
                    break;

            }
            holder.id_progressbar.setVisibility(View.GONE);
        } else if (dto.getTypeModule() == context.getResources().getInteger(R.integer.type_module_file)) {
            if (dto.getExtention().equals(".mp4") || dto.getExtention().equals(".avi") || dto.getExtention().equals(".mpg")) {
                holder.imgType.setImageResource(R.drawable.ic_video_library_black_24dp);
            } else if (dto.getExtention().equals(".pdf")) {
                holder.imgType.setImageResource(R.drawable.ic_picture_as_pdf_black_24dp);
            } else if (dto.getExtention().equals(".png") || dto.getExtention().equals(".jpg")) {
                holder.imgType.setImageResource(R.drawable.ic_photo_black_24dp);
            }
            holder.id_progressbar.setVisibility(View.VISIBLE);
        }

        if (position % 2 != 0) {
            holder.rltMain.setBackgroundResource(R.color.colorZebraOdd);
        } else {
            holder.rltMain.setBackgroundResource(R.color.colorZebraPair);
        }
    }

    @Override
    public int getItemCount() {
        return lstInbox.size();
    }

    public DtoMessageAndFiles getItem(int position) {
        return lstInbox.get(position);
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtTitle, txtDescription, txtDate;
        ImageView imgType, imgViewed;
        RelativeLayout rltMain;
        ProgressBar id_progressbar;

        ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtDescription = itemView.findViewById(R.id.txtDescription);
            txtDate = itemView.findViewById(R.id.txtDate);
            imgType = itemView.findViewById(R.id.imgType);
            imgViewed = itemView.findViewById(R.id.imgViewed);
            rltMain = itemView.findViewById(R.id.rltMain);
            id_progressbar = itemView.findViewById(R.id.id_progressbar);

        }

        @Override
        public void onClick(View v) {
            OnClickItemRecyclerViewLisener.onClickItemRecyclerView(id_progressbar, getAdapterPosition(), 0, null);
        }
    }
}
