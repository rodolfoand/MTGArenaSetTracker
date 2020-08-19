package com.rodolfo.mtgarenasettracker.room;

import android.provider.BaseColumns;

public final class SetContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private SetContract() {}

    /* Inner class that defines the table contents */
    public static class SetEntry implements BaseColumns {
        public static final String TABLE_NAME = "set";
        public static final String COLUMN_NAME_OBJECT = "object";
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_CODE = "code";
        public static final String COLUMN_NAME_ARENA_CODE = "arena_code";
        public static final String COLUMN_NAME_TCQPLAYER_ID = "tcgplayer_id";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_URI = "uri";
        public static final String COLUMN_NAME_SCRYFALL_URI = "scryfall_uri";
        public static final String COLUMN_NAME_SEARCH_URI = "search_uri";
        public static final String COLUMN_NAME_RELEASED_AT = "released_at";
        public static final String COLUMN_NAME_SET_TYPE = "set_type";
        public static final String COLUMN_NAME_CARD_COUNT = "card_count";
        public static final String COLUMN_NAME_PRINTED_SIZE = "printed_size";
        public static final String COLUMN_NAME_DIGITAL = "digital";
        public static final String COLUMN_NAME_NONFOIL_ONLY = "nonfoil_only";
        public static final String COLUMN_NAME_FOIL_ONLY = "foil_only";
        public static final String COLUMN_NAME_BLOC_CODE = "block_code";
        public static final String COLUMN_NAME_BLOCK = "block";
        public static final String COLUMN_NAME_ICON_SVG_URI = "icon_svg_uri";
    }
}
