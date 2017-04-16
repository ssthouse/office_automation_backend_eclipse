package com.ssthouse.officeautomation.domain;

import javax.persistence.*;

/**
 * Created by ssthouse on 10/04/2017.
 */
@Entity
@Table(name = "user_config", schema = "office_automation", catalog = "")
public class UserConfigEntity {
    private int id;
    private String username;
    private String homePageConfig;
    private String toolsPageConfig;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 30)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "home_page_config", nullable = true, length = 100)
    public String getHomePageConfig() {
        return homePageConfig;
    }

    public void setHomePageConfig(String homePageConfig) {
        this.homePageConfig = homePageConfig;
    }

    @Basic
    @Column(name = "tools_page_config", nullable = true, length = 100)
    public String getToolsPageConfig() {
        return toolsPageConfig;
    }

    public void setToolsPageConfig(String toolsPageConfig) {
        this.toolsPageConfig = toolsPageConfig;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserConfigEntity that = (UserConfigEntity) o;

        if (id != that.id) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (homePageConfig != null ? !homePageConfig.equals(that.homePageConfig) : that.homePageConfig != null)
            return false;
        if (toolsPageConfig != null ? !toolsPageConfig.equals(that.toolsPageConfig) : that.toolsPageConfig != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (homePageConfig != null ? homePageConfig.hashCode() : 0);
        result = 31 * result + (toolsPageConfig != null ? toolsPageConfig.hashCode() : 0);
        return result;
    }
    
    @Transient
    public boolean isValid(){
    	// TODO un solved
    	return true;
    }
}
