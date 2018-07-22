package com.example.android.pets.data;

import android.provider.BaseColumns;

public final class PetContract {

    private PetContract() {}

    public static abstract class PetEntry implements BaseColumns {

        public static final String TABLE_NAME = "pets";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_BREED = "breed";
        public static final String COLUMN_GENDER = "gender";
        public static final String COLUMN_WEIGHT = "weight";

        /**
         * Possible values for the Gender
         * Only 3 values are permitted
         * 1: Male, 2: Female, 3: Unknown
         */
        public static final int GENDER_MALE = 1;
        public static final int GENDER_FEMALE = 2;
        public static final int GENDER_UNKNOWN = 0;
    }
}
