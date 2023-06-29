package com.example.manager.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.manager.R;
import com.example.manager.model.ChatMessage;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<ChatMessage> chatMessageList;
    private String sendid;
    private static final int TYPE_SEND = 1;
    private static final int TYPE_RECEIVE = 2;

    public ChatAdapter(Context context, List<ChatMessage> chatMessageList, String sendid) {
        this.context = context;
        this.chatMessageList = chatMessageList;
        this.sendid = sendid;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == TYPE_SEND){
            view = LayoutInflater.from(context).inflate(R.layout.item_send_message, parent, false);
            return new SendMessViewHolder(view);
        }else {
            view = LayoutInflater.from(context).inflate(R.layout.item_received_message, parent, false);
            return new ReceivedViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_SEND){
            ((SendMessViewHolder) holder).txtmess.setText(chatMessageList.get(position).mess);
            ((SendMessViewHolder) holder).txttime.setText(chatMessageList.get(position).datetime);
        }else {
            ((ReceivedViewHolder) holder).txtmess.setText(chatMessageList.get(position).mess);
            ((ReceivedViewHolder) holder).txttime.setText(chatMessageList.get(position).datetime);
        }
    }

    @Override
    public int getItemCount() {
        return chatMessageList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (chatMessageList.get(position).sendid.equals(sendid)){
            return TYPE_SEND;
        }else {
            return TYPE_RECEIVE;
        }

    }

    class SendMessViewHolder extends RecyclerView.ViewHolder{

        TextView txtmess, txttime;

        public SendMessViewHolder(@NonNull View itemView) {
            super(itemView);

            txtmess = itemView.findViewById(R.id.txtmessagesend);
            txttime = itemView.findViewById(R.id.txttimesend);
        }
    }

    class ReceivedViewHolder extends RecyclerView.ViewHolder{

        TextView txtmess, txttime;

        public ReceivedViewHolder(@NonNull View itemView) {
            super(itemView);

            txtmess = itemView.findViewById(R.id.txtmessagereceived);
            txttime = itemView.findViewById(R.id.txttimereceived);
        }
    }

}
