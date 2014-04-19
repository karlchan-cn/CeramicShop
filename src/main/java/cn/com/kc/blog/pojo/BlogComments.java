/**
 * 
 */
package cn.com.kc.blog.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author chenjinlong2
 * 
 */
@Entity
@Table(name = "BLOG_COMMENT")
public class BlogComments implements Serializable {

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = 9056046604238945833L;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST }, targetEntity = BlogEntity.class)
	@JoinColumn(name = "ENTITY_ID", nullable = false)
	private BlogEntity entity;
	private String content;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne(cascade = { CascadeType.PERSIST }, fetch = FetchType.LAZY, targetEntity = BlogUser.class)
	@JoinColumn(name = "USER_ID", nullable = false)
	private BlogUser user;
	private Timestamp commenttime;

	public String getContent() {
		return content;
	}

	public BlogEntity getEntity() {
		return entity;
	}

	public void setEntity(BlogEntity entity) {
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

	public BlogUser getUser() {
		return user;
	}

	public void setUser(BlogUser user) {
		this.user = user;
	}

	public Timestamp getCommenttime() {
		return commenttime;
	}

	public void setCommenttime(Timestamp commenttime) {
		this.commenttime = commenttime;
	}

}
