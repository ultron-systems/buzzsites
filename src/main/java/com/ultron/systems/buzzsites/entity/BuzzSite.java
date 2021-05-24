package com.ultron.systems.buzzsites.entity;

public class BuzzSite {
    private Integer id;
    private String url;
    private String description;
    private Long upvotes = 0L;

    public BuzzSite() {
    }

    public BuzzSite(Integer id, String url) {
        this.id = id;
        this.url = url;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(Long upvotes) {
        this.upvotes = upvotes;
    }
}
