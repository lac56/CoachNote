package com.example.coachnote;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

/**
 * This class is required for the RecyclerView.
 * With this we are able to show our database result.
 */
public class ClubMemberAdapter extends RecyclerView.Adapter<ClubMemberAdapter.ClubMemberViewHolder> {
    private Context mContext; /** mContext: It will store infromatoion about DeleteClubMemberClass*/
    private Cursor mCursor; /** mCursor: It holds the incoming data from Club table */

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

    // This method creates a ViewHolder. This holds the database result.
    // So it will creates one club member list to every objects.
    @Override
    public ClubMemberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.club_member_list, parent, false);
        return new ClubMemberViewHolder(view);
    }
    // This method assign the data to the view holder.
    @Override
    public void onBindViewHolder(ClubMemberViewHolder holder, int position) {
        if (!mCursor.moveToPosition(position)) {
            return;
        }
        int id = mCursor.getInt(mCursor.getColumnIndex(DatabaseHelper.CLUBMEMBERS_COL_1));
        String ClubMemberName = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.CLUBMEMBERS_COL_2));
        holder.clubMemberText.setText(ClubMemberName);
    }

    // It has to be overridden. Returns with the number of rows in the cursor.
    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }
}