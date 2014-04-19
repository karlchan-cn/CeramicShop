/**
 * 
 */
package cn.com.kc.blog.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;



/**
 * @author chenjinlong2
 * 
 */

public class BlogEntityVO implements Serializable {

/**
	 * 
	 */
private static final long serialVersionUID = 3390558414263442995L;

private Long id;

private String title;

private Timestamp createdate;

private String content;
/**
 * P-all S-friend X-self
 */

private String readprivate;

private Boolean commentable;

private Boolean isTemp;

private List<BlogImageVO> images;

public List<BlogImageVO> getImages() {
	return images;
}

public void setImages(List<BlogImageVO> images) {
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

private BlogUserVO user;

private List<BlogCategoryVO> categorys;

public List<BlogCategoryVO> getCategorys() {
	return categorys;
}

public void setCategorys(List<BlogCategoryVO> categorys) {
	this.categorys = categorys;
}

private Set<BlogCommentsVO> comments;

public Set<BlogCommentsVO> getComments() {
	return comments;
}

public void setComments(Set<BlogCommentsVO> comments) {
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

public BlogUserVO getUser() {
	return user;
}

public void setUser(BlogUserVO user) {
	this.user = user;
}

}