package com.rodolfo.mtgarenasettracker.model;

public class Set {
    private String object;
    private String id;
    private String code;
    private String mtgo_code;
    private String arena_code;
    private float tcgplayer_id;
    private String name;
    private String uri;
    private String scryfall_uri;
    private String search_uri;
    private String released_at;
    private String set_type;
    private float card_count;
    private float printed_size;
    private boolean digital;
    private boolean nonfoil_only;
    private boolean foil_only;
    private String block_code;
    private String block;
    private String icon_svg_uri;

    public Set() {
    }

    public Set(String object, String id, String code, String mtgo_code, String arena_code, float tcgplayer_id, String name, String uri, String scryfall_uri, String search_uri, String released_at, String set_type, float card_count, float printed_size, boolean digital, boolean nonfoil_only, boolean foil_only, String block_code, String block, String icon_svg_uri) {
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

    public float getTcgplayer_id() {
        return tcgplayer_id;
    }

    public void setTcgplayer_id(float tcgplayer_id) {
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

    public float getCard_count() {
        return card_count;
    }

    public void setCard_count(float card_count) {
        this.card_count = card_count;
    }

    public float getPrinted_size() {
        return printed_size;
    }

    public void setPrinted_size(float printed_size) {
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