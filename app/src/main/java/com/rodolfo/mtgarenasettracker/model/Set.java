package com.rodolfo.mtgarenasettracker.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "set_table")
public class Set {
    @ColumnInfo(name = "object")
    public String object;

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    public String id;

    @ColumnInfo(name = "code")
    public String code;

    @ColumnInfo(name = "mtgo_code")
    public String mtgo_code;

    @ColumnInfo(name = "arena_code")
    public String arena_code;

    @ColumnInfo(name = "tcgplayer_id")
    public int tcgplayer_id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "uri")
    public String uri;

    @ColumnInfo(name = "scryfall_uri")
    public String scryfall_uri;

    @ColumnInfo(name = "search_uri")
    public String search_uri;

    @ColumnInfo(name = "released_at")
    public String released_at;

    @ColumnInfo(name = "set_type")
    public String set_type;

    @ColumnInfo(name = "card_count")
    public int card_count;

    @ColumnInfo(name = "printed_size")
    public int printed_size;

    @ColumnInfo(name = "digital")
    public boolean digital;

    @ColumnInfo(name = "nonfoil_only")
    public boolean nonfoil_only;

    @ColumnInfo(name = "foil_only")
    public boolean foil_only;

    @ColumnInfo(name = "block_code")
    private String block_code;

    @ColumnInfo(name = "block")
    private String block;

    @ColumnInfo(name = "icon_svg_uri")
    private String icon_svg_uri;

    @ColumnInfo(name = "common")
    private int common;

    @ColumnInfo(name = "uncommon")
    private int uncommon;

    @ColumnInfo(name = "rare")
    private int rare;

    @ColumnInfo(name = "mythic")
    private int mythic;

    @ColumnInfo(name = "total_cards")
    private int total_cards;

    @ColumnInfo(name = "my_common")
    private int my_common;

    @ColumnInfo(name = "my_uncommon")
    private int my_uncommon;

    @ColumnInfo(name = "my_rare")
    private int my_rare;

    @ColumnInfo(name = "my_mythic")
    private int my_mythic;

    @ColumnInfo(name = "my_total_cards")
    private int my_total_cards;

    @Ignore
    public Set() {
    }

    public Set(String object, String id, String code, String mtgo_code, String arena_code, int tcgplayer_id, String name, String uri, String scryfall_uri, String search_uri, String released_at, String set_type, int card_count, int printed_size, boolean digital, boolean nonfoil_only, boolean foil_only, String block_code, String block, String icon_svg_uri) {
        this.object = object;
        this.id = id;
        this.code = code;
        this.mtgo_code = mtgo_code;
        this.arena_code = arena_code;
        this.tcgplayer_id = tcgplayer_id;
        this.name = name;
        this.uri = uri;
        this.scryfall_uri = scryfall_uri;
        this.search_uri = search_uri;
        this.released_at = released_at;
        this.set_type = set_type;
        this.card_count = card_count;
        this.printed_size = printed_size;
        this.digital = digital;
        this.nonfoil_only = nonfoil_only;
        this.foil_only = foil_only;
        this.block_code = block_code;
        this.block = block;
        this.icon_svg_uri = icon_svg_uri;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMtgo_code() {
        return mtgo_code;
    }

    public void setMtgo_code(String mtgo_code) {
        this.mtgo_code = mtgo_code;
    }

    public String getArena_code() {
        return arena_code;
    }

    public void setArena_code(String arena_code) {
        this.arena_code = arena_code;
    }

    public int getTcgplayer_id() {
        return tcgplayer_id;
    }

    public void setTcgplayer_id(int tcgplayer_id) {
        this.tcgplayer_id = tcgplayer_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getScryfall_uri() {
        return scryfall_uri;
    }

    public void setScryfall_uri(String scryfall_uri) {
        this.scryfall_uri = scryfall_uri;
    }

    public String getSearch_uri() {
        return search_uri;
    }

    public void setSearch_uri(String search_uri) {
        this.search_uri = search_uri;
    }

    public String getReleased_at() {
        return released_at;
    }

    public void setReleased_at(String released_at) {
        this.released_at = released_at;
    }

    public String getSet_type() {
        return set_type;
    }

    public void setSet_type(String set_type) {
        this.set_type = set_type;
    }

    public int getCard_count() {
        return card_count;
    }

    public void setCard_count(int card_count) {
        this.card_count = card_count;
    }

    public int getPrinted_size() {
        return printed_size;
    }

    public void setPrinted_size(int printed_size) {
        this.printed_size = printed_size;
    }

    public boolean isDigital() {
        return digital;
    }

    public void setDigital(boolean digital) {
        this.digital = digital;
    }

    public boolean isNonfoil_only() {
        return nonfoil_only;
    }

    public void setNonfoil_only(boolean nonfoil_only) {
        this.nonfoil_only = nonfoil_only;
    }

    public boolean isFoil_only() {
        return foil_only;
    }

    public void setFoil_only(boolean foil_only) {
        this.foil_only = foil_only;
    }

    public String getBlock_code() {
        return block_code;
    }

    public void setBlock_code(String block_code) {
        this.block_code = block_code;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getIcon_svg_uri() {
        return icon_svg_uri;
    }

    public void setIcon_svg_uri(String icon_svg_uri) {
        this.icon_svg_uri = icon_svg_uri;
    }

    public int getCommon() {
        return common;
    }

    public void setCommon(int common) {
        this.common = common;
    }

    public int getUncommon() {
        return uncommon;
    }

    public void setUncommon(int uncommon) {
        this.uncommon = uncommon;
    }

    public int getRare() {
        return rare;
    }

    public void setRare(int rare) {
        this.rare = rare;
    }

    public int getMythic() {
        return mythic;
    }

    public void setMythic(int mythic) {
        this.mythic = mythic;
    }

    public int getMy_common() {
        return my_common;
    }

    public void setMy_common(int my_common) {
        this.my_common = my_common;
    }

    public int getMy_uncommon() {
        return my_uncommon;
    }

    public void setMy_uncommon(int my_uncommon) {
        this.my_uncommon = my_uncommon;
    }

    public int getMy_rare() {
        return my_rare;
    }

    public void setMy_rare(int my_rare) {
        this.my_rare = my_rare;
    }

    public int getMy_mythic() {
        return my_mythic;
    }

    public void setMy_mythic(int my_mythic) {
        this.my_mythic = my_mythic;
    }

    public int getTotal_cards() {
        return total_cards;
    }

    public void setTotal_cards(int total_cards) {
        this.total_cards = total_cards;
    }

    public int getMy_total_cards() {
        return my_total_cards;
    }

    public void setMy_total_cards(int my_total_cards) {
        this.my_total_cards = my_total_cards;
    }

    @Override
    public String toString() {
        return "Set{" +
                "object='" + object + '\'' +
                ", id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", mtgo_code='" + mtgo_code + '\'' +
                ", arena_code='" + arena_code + '\'' +
                ", tcgplayer_id=" + tcgplayer_id +
                ", name='" + name + '\'' +
                ", uri='" + uri + '\'' +
                ", scryfall_uri='" + scryfall_uri + '\'' +
                ", search_uri='" + search_uri + '\'' +
                ", released_at='" + released_at + '\'' +
                ", set_type='" + set_type + '\'' +
                ", card_count=" + card_count +
                ", printed_size=" + printed_size +
                ", digital=" + digital +
                ", nonfoil_only=" + nonfoil_only +
                ", foil_only=" + foil_only +
                ", block_code='" + block_code + '\'' +
                ", block='" + block + '\'' +
                ", icon_svg_uri='" + icon_svg_uri + '\'' +
                '}';
    }
}