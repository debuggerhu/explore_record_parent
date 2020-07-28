package com.hhx.stream;

/**
 * @author huhaixaing
 * @date 2020/7/28 14:12
 * @Description: PACKAGE_NAME
 */

public class Link {
    private String name;
    private String path;
    private String description;

    public Link() {
    }

    public Link(String name, String path, String description) {
        this.name = name;
        this.path = path;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Link{" +
                "name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
