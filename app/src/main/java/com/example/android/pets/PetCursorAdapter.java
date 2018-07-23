package com.example.android.pets;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.android.pets.data.PetContract;
import com.example.android.pets.data.PetContract.PetEntry;

/**
 * {@link PetCursorAdapter} is an adapter for a list or grid view
 * that uses a {@link Cursor} of pet data as its data source. This adapter knows
 * how to create list items for each row of pet data in the {@link Cursor}.
 */
public class PetCursorAdapter extends CursorAdapter {

    /**
     * Constructs a new {@link PetCursorAdapter}.
     *
     * @param context The context
     * @param c       The cursor from which to get the data.
     */
    public PetCursorAdapter(Context context, Cursor c) {
        super(context, c, 0 /* flags */);
    }

    /**
     * Makes a new blank list item view. No data is set (or bound) to the views yet.
     *
     * @param context app context
     * @param cursor  The cursor from which to get the data. The cursor is already
     *                moved to the correct position.
     * @param parent  The parent to which the new view is attached to
     * @return the newly created list item view.
     */
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }

    /**
     * This method binds the pet data (in the current row pointed to by cursor) to the given
     * list item layout. For example, the name for the current pet can be set on the name TextView
     * in the list item layout.
     *
     * @param view    Existing view, returned earlier by newView() method
     * @param context app context
     * @param cursor  The cursor from which to get the data. The cursor is already moved to the
     *                correct row.
     */
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // Find fields to populate in inflated template
        TextView tvName  = (TextView) view.findViewById(R.id.name);
        TextView tvSummary = (TextView) view.findViewById(R.id.summary);
        // Extract properties from cursor
        String name = cursor.getString(cursor.getColumnIndex(PetEntry.COLUMN_NAME));
        String breed = cursor.getString(cursor.getColumnIndex(PetEntry.COLUMN_BREED));
        int gender = cursor.getInt(cursor.getColumnIndex(PetEntry.COLUMN_GENDER));
        String genderString;
        if (gender == PetEntry.GENDER_MALE) {
            genderString = view.getResources().getString(R.string.gender_male);
        } else if (gender == PetEntry.GENDER_FEMALE) {
            genderString = view.getResources().getString(R.string.gender_female);
        } else {
            genderString = "";
        }
        int weight = cursor.getInt(cursor.getColumnIndex(PetEntry.COLUMN_WEIGHT));
        String summary = breed + " (" + genderString + ", " + weight + " kg)";
        // Populate fields with extracted properties
        tvName.setText(name);
        tvSummary.setText(summary);

        // TODO: Fill out this method
    }
}