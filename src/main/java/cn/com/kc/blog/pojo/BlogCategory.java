package cn.com.kc.blog.pojo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "BLOG_CATEGORY")
public class BlogCategory implements Serializable {

/**
	 * 
	 */
private static final long serialVersionUID = -2243315009224421667L;
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private String name;
@ManyToOne(cascade = { CascadeType.PERSIST }, fetch = FetchType.LAZY, targetEntity = BlogCategory.class)
@JoinColumn(name = "PARENT_ID", nullable = true)
private BlogCategory parent;
@OneToMany(cascade = { CascadeType.PERSIST }, fetch = FetchType.LAZY, mappedBy = "parent")
private List<BlogCategory> children;
@ManyToMany(cascade = { CascadeType.PERSIST }, fetch = FetchType.LAZY, targetEntity = BlogEntity.class)
@JoinTable(name = "BLOG_ENTITY_CATE", joinColumns = { @JoinColumn(name = "ENTITY_ID") },
				inverseJoinColumns = { @JoinColumn(name = "CATE_ID") })
private List<BlogEntity> entities;

public List<BlogEntity> getEntities() {
	return entities;
}

public void setEntities(List<BlogEntity> entities) {
	this.entities = entities;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public BlogCategory getParent() {
	return parent;
}

public void setParent(BlogCategory parent) {
	this.parent = parent;
}

public List<BlogCategory> getChildren() {
	return children;
}

public void setChildren(List<BlogCategory> children) {
	this.children = children;
}

}
