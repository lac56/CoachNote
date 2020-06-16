package com.example.coachnote;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ClubMemberAdapter extends RecyclerView.Adapter<ClubMemberAdapter.ClubMemberViewHolder> {
    private Context mContext;
    private Cursor mCursor;

    // Constructor
    public ClubMemberAdapter(Context context, Cursor cursor) {
        mContext = context;
        mCursor = cursor;
    }

    // View holder constructor
    public class ClubMemberViewHolder extends RecyclerView.ViewHolder {
        public TextView idText;
        public TextView clubMemberText;
        public ClubMemberViewHolder(View itemView) {
            super(itemView);
            clubMemberText = itemView.findViewById(R.id.textview_club_member_name);
        }
    }
    @Override
    public ClubMemberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.club_member_list, parent, false);
        return new ClubMemberViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ClubMemberViewHolder holder, int position) {
        if (!mCursor.moveToPosition(position)) {
            return;
        }
        int id = mCursor.getInt(mCursor.getColumnIndex(DatabaseHelper.CLUBMEMBERS_COL_1));
        String ClubMemberName = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.CLUBMEMBERS_COL_2));
        holder.clubMemberText.setText(ClubMemberName);
    }
    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }
}