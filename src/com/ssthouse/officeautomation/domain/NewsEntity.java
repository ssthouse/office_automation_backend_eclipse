package com.ssthouse.officeautomation.domain;

import javax.persistence.*;

import com.ssthouse.officeautomation.util.StringUtil;

/**
 * Created by ssthouse on 15/05/2017.
 */
@Entity
@Table(name = "news", schema = "office_automation", catalog = "")
public class NewsEntity {
    private int id;
    private String title;
    private String link;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title", nullable = false, length = 1000)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "link", nullable = false, length = 1000)
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NewsEntity that = (NewsEntity) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (link != null ? !link.equals(that.link) : that.link != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (link != null ? link.hashCode() : 0);
        return result;
    }
    
    @Transient
    public boolean isValid(){
    	if(StringUtil.isEmpty(this.link, this.title)){
    		return false;
    	}
    	return true;
    }
}
