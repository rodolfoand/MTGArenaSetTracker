package com.rodolfo.mtgarenasettracker.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "card_table")
public class Card {

    @ColumnInfo(name = "object")
    private String object;

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private String id;

    @ColumnInfo(name = "oracle_id")
    private String oracle_id;

    @ColumnInfo(name = "mtgo_id")
    private float mtgo_id;

    @ColumnInfo(name = "tcgplayer_id")
    private float tcgplayer_id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "lang")
    private String lang;

    @ColumnInfo(name = "released_at")
    private String released_at;

    @ColumnInfo(name = "uri")
    private String uri;

    @ColumnInfo(name = "scryfall_uri")
    private String scryfall_uri;

    @ColumnInfo(name = "layout")
    private String layout;

    @ColumnInfo(name = "highres_image")
    private boolean highres_image;

    @ColumnInfo(name = "mana_cost")
    private String mana_cost;

    @ColumnInfo(name = "cmc")
    private float cmc;

    @ColumnInfo(name = "type_line")
    private String type_line;

    @ColumnInfo(name = "reserved")
    private boolean reserved;

    @ColumnInfo(name = "foil")
    private boolean foil;

    @ColumnInfo(name = "nonfoil")
    private boolean nonfoil;

    @ColumnInfo(name = "oversized")
    private boolean oversized;

    @ColumnInfo(name = "promo")
    private boolean promo;

    @ColumnInfo(name = "reprint")
    private boolean reprint;

    @ColumnInfo(name = "variation")
    private boolean variation;

    @ColumnInfo(name = "set")
    private String set;

    @ColumnInfo(name = "set_name")
    private String set_name;

    @ColumnInfo(name = "set_type")
    private String set_type;

    @ColumnInfo(name = "set_uri")
    private String set_uri;

    @ColumnInfo(name = "set_search_uri")
    private String set_search_uri;

    @ColumnInfo(name = "scryfall_set_uri")
    private String scryfall_set_uri;

    @ColumnInfo(name = "rulings_uri")
    private String rulings_uri;

    @ColumnInfo(name = "prints_search_uri")
    private String prints_search_uri;

    @ColumnInfo(name = "collector_number")
    private String collector_number;

    @ColumnInfo(name = "digital")
    private boolean digital;

    @ColumnInfo(name = "rarity")
    private String rarity;

    @ColumnInfo(name = "card_back_id")
    private String card_back_id;

    @ColumnInfo(name = "artist")
    private String artist;

    @ColumnInfo(name = "illustration_id")
    private String illustration_id;

    @ColumnInfo(name = "border_color")
    private String border_color;

    @ColumnInfo(name = "frame")
    private String frame;

    @ColumnInfo(name = "full_art")
    private boolean full_art;

    @ColumnInfo(name = "textless")
    private boolean textless;

    @ColumnInfo(name = "booster")
    private boolean booster;

    @ColumnInfo(name = "story_spotlight")
    private boolean story_spotlight;

    @ColumnInfo(name = "edhrec_rank")
    private float edhrec_rank;

    @Ignore
    public Card() {
    }

    public Card(String object, String id, String oracle_id, float mtgo_id, float tcgplayer_id, String name, String lang, String released_at, String uri, String scryfall_uri, String layout, boolean highres_image, String mana_cost, float cmc, String type_line, boolean reserved, boolean foil, boolean nonfoil, boolean oversized, boolean promo, boolean reprint, boolean variation, String set, String set_name, String set_type, String set_uri, String set_search_uri, String scryfall_set_uri, String rulings_uri, String prints_search_uri, String collector_number, boolean digital, String rarity, String card_back_id, String artist, String illustration_id, String border_color, String frame, boolean full_art, boolean textless, boolean booster, boolean story_spotlight, float edhrec_rank) {
        this.object = object;
        this.id = id;
        this.oracle_id = oracle_id;
        this.mtgo_id = mtgo_id;
        this.tcgplayer_id = tcgplayer_id;
        this.name = name;
        this.lang = lang;
        this.released_at = released_at;
        this.uri = uri;
        this.scryfall_uri = scryfall_uri;
        this.layout = layout;
        this.highres_image = highres_image;
        this.mana_cost = mana_cost;
        this.cmc = cmc;
        this.type_line = type_line;
        this.reserved = reserved;
        this.foil = foil;
        this.nonfoil = nonfoil;
        this.oversized = oversized;
        this.promo = promo;
        this.reprint = reprint;
        this.variation = variation;
        this.set = set;
        this.set_name = set_name;
        this.set_type = set_type;
        this.set_uri = set_uri;
        this.set_search_uri = set_search_uri;
        this.scryfall_set_uri = scryfall_set_uri;
        this.rulings_uri = rulings_uri;
        this.prints_search_uri = prints_search_uri;
        this.collector_number = collector_number;
        this.digital = digital;
        this.rarity = rarity;
        this.card_back_id = card_back_id;
        this.artist = artist;
        this.illustration_id = illustration_id;
        this.border_color = border_color;
        this.frame = frame;
        this.full_art = full_art;
        this.textless = textless;
        this.booster = booster;
        this.story_spotlight = story_spotlight;
        this.edhrec_rank = edhrec_rank;
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

    public String getOracle_id() {
        return oracle_id;
    }

    public void setOracle_id(String oracle_id) {
        this.oracle_id = oracle_id;
    }

    public float getMtgo_id() {
        return mtgo_id;
    }

    public void setMtgo_id(float mtgo_id) {
        this.mtgo_id = mtgo_id;
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

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getReleased_at() {
        return released_at;
    }

    public void setReleased_at(String released_at) {
        this.released_at = released_at;
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

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public boolean isHighres_image() {
        return highres_image;
    }

    public void setHighres_image(boolean highres_image) {
        this.highres_image = highres_image;
    }

    public String getMana_cost() {
        return mana_cost;
    }

    public void setMana_cost(String mana_cost) {
        this.mana_cost = mana_cost;
    }

    public float getCmc() {
        return cmc;
    }

    public void setCmc(float cmc) {
        this.cmc = cmc;
    }

    public String getType_line() {
        return type_line;
    }

    public void setType_line(String type_line) {
        this.type_line = type_line;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public boolean isFoil() {
        return foil;
    }

    public void setFoil(boolean foil) {
        this.foil = foil;
    }

    public boolean isNonfoil() {
        return nonfoil;
    }

    public void setNonfoil(boolean nonfoil) {
        this.nonfoil = nonfoil;
    }

    public boolean isOversized() {
        return oversized;
    }

    public void setOversized(boolean oversized) {
        this.oversized = oversized;
    }

    public boolean isPromo() {
        return promo;
    }

    public void setPromo(boolean promo) {
        this.promo = promo;
    }

    public boolean isReprint() {
        return reprint;
    }

    public void setReprint(boolean reprint) {
        this.reprint = reprint;
    }

    public boolean isVariation() {
        return variation;
    }

    public void setVariation(boolean variation) {
        this.variation = variation;
    }

    public String getSet() {
        return set;
    }

    public void setSet(String set) {
        this.set = set;
    }

    public String getSet_name() {
        return set_name;
    }

    public void setSet_name(String set_name) {
        this.set_name = set_name;
    }

    public String getSet_type() {
        return set_type;
    }

    public void setSet_type(String set_type) {
        this.set_type = set_type;
    }

    public String getSet_uri() {
        return set_uri;
    }

    public void setSet_uri(String set_uri) {
        this.set_uri = set_uri;
    }

    public String getSet_search_uri() {
        return set_search_uri;
    }

    public void setSet_search_uri(String set_search_uri) {
        this.set_search_uri = set_search_uri;
    }

    public String getScryfall_set_uri() {
        return scryfall_set_uri;
    }

    public void setScryfall_set_uri(String scryfall_set_uri) {
        this.scryfall_set_uri = scryfall_set_uri;
    }

    public String getRulings_uri() {
        return rulings_uri;
    }

    public void setRulings_uri(String rulings_uri) {
        this.rulings_uri = rulings_uri;
    }

    public String getPrints_search_uri() {
        return prints_search_uri;
    }

    public void setPrints_search_uri(String prints_search_uri) {
        this.prints_search_uri = prints_search_uri;
    }

    public String getCollector_number() {
        return collector_number;
    }

    public void setCollector_number(String collector_number) {
        this.collector_number = collector_number;
    }

    public boolean isDigital() {
        return digital;
    }

    public void setDigital(boolean digital) {
        this.digital = digital;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getCard_back_id() {
        return card_back_id;
    }

    public void setCard_back_id(String card_back_id) {
        this.card_back_id = card_back_id;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getIllustration_id() {
        return illustration_id;
    }

    public void setIllustration_id(String illustration_id) {
        this.illustration_id = illustration_id;
    }

    public String getBorder_color() {
        return border_color;
    }

    public void setBorder_color(String border_color) {
        this.border_color = border_color;
    }

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public boolean isFull_art() {
        return full_art;
    }

    public void setFull_art(boolean full_art) {
        this.full_art = full_art;
    }

    public boolean isTextless() {
        return textless;
    }

    public void setTextless(boolean textless) {
        this.textless = textless;
    }

    public boolean isBooster() {
        return booster;
    }

    public void setBooster(boolean booster) {
        this.booster = booster;
    }

    public boolean isStory_spotlight() {
        return story_spotlight;
    }

    public void setStory_spotlight(boolean story_spotlight) {
        this.story_spotlight = story_spotlight;
    }

    public float getEdhrec_rank() {
        return edhrec_rank;
    }

    public void setEdhrec_rank(float edhrec_rank) {
        this.edhrec_rank = edhrec_rank;
    }
}
