package com.e.multipleentries;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weioule
 * on 2019/7/9.
 */
public class GameCenterBean {
    private String id;
    private String key;
    private String name;
    private String url;
    private String img;
    private String desc;
    private String title;
    private String game_play_desc = "999人在玩";
    private String user_name;
    private String amount = "8888";
    private List<GameCenterBean> list = new ArrayList<>();

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGame_play_desc() {
        return game_play_desc;
    }

    public void setGame_play_desc(String game_play_desc) {
        this.game_play_desc = game_play_desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public List<GameCenterBean> getList() {
        return list;
    }

    public void setList(List<GameCenterBean> list) {
        this.list.addAll(list);
    }

}
