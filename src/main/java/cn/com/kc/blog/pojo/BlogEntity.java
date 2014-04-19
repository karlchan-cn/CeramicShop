/**
 * 
 */
package cn.com.kc.blog.pojo;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author chenjinlong2
 * 
 */
@Entity
@Table(name = "BLOG_ENTITY")
public class BlogEntity implements Serializable {

/**
	 * 
	 */
private static final long serialVersionUID = 3390558414263442995L;
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
@NotNull
private String title;
@NotNull
private Timestamp createdate;
@NotNull
@Column(columnDefinition = "TEXT")
private String content;
/**
 * P-all S-friend X-self
 */
@NotNull
private String readprivate;
@NotNull
private Boolean commentable;
@NotNull
private Boolean isTemp;
@OneToMany(fetch = FetchType.EAGER, targetEntity = BlogImage.class, mappedBy = "entity", cascade = { CascadeType.REMOVE })
private List<BlogImage> images;

@ManyToOne(cascade = { CascadeType.PERSIST }, fetch = FetchType.LAZY, targetEntity = BlogUser.class)
@JoinColumn(name = "USER_ID", nullable = false)
private BlogUser user;

@OneToMany(cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY, mappedBy = "entity")
private Set<BlogComments> comments;
@ManyToMany(cascade = { CascadeType.PERSIST }, fetch = FetchType.LAZY, targetEntity = BlogCategory.class, mappedBy = "entities")
private List<BlogCategory> categorys;

public List<BlogImage> getImages() {
	return images;
}

public void setImages(List<BlogImage> images) {
	this.images = images;
}

public String getReadprivate() {
	return readprivate;
}

public void setReadprivate(String readprivate) {
	this.readprivate = readprivate;
}

public Boolean getIsTemp() {
	return isTemp;
}

public void setIsTemp(Boolean isTemp) {
	this.isTemp = isTemp;
}

public Boolean getCommentable() {
	return commentable;
}

public void setCommentable(Boolean commentable) {
	this.commentable = commentable;
}

public List<BlogCategory> getCategorys() {
	return categorys;
}

public void setCategorys(List<BlogCategory> categorys) {
	this.categorys = categorys;
}

public Set<BlogComments> getComments() {
	return comments;
}

public void setComments(Set<BlogComments> comments) {
	this.comments = comments;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public Timestamp getCreatedate() {
	return createdate;
}

public void setCreatedate(Timestamp createdate) {
	this.createdate = createdate;
}

public String getContent() {
	return content;
}

public void setContent(String content) {
	this.content = content;
}

public BlogUser getUser() {
	return user;
}

public void setUser(BlogUser user) {
	this.user = user;
}

}