/**
 * 
 */
package cn.com.kc.blog.vo;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author chenjinlong2
 * 
 */

public class BlogCommentsVO implements Serializable {

/**
 * serialVersionUID.
 */
private static final long serialVersionUID = 9056046604238945833L;

private BlogEntityVO entity;
private String content;

private Long id;

private BlogUserVO user;
private Timestamp commenttime;

public String getContent() {
	return content;
}

public BlogEntityVO getEntity() {
	return entity;
}

public void setEntity(BlogEntityVO entity) {
	this.entity = entity;
}

public void setContent(String content) {
	this.content = content;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public BlogUserVO getUser() {
	return user;
}

public void setUser(BlogUserVO user) {
	this.user = user;
}

public Timestamp getCommenttime() {
	return commenttime;
}

public void setCommenttime(Timestamp commenttime) {
	this.commenttime = commenttime;
}

}
