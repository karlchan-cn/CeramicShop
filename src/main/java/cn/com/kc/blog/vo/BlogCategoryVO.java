package cn.com.kc.blog.vo;

import java.io.Serializable;
import java.util.List;

public class BlogCategoryVO implements Serializable {

/**
	 * 
	 */
private static final long serialVersionUID = -2243315009224421667L;

private Long id;
private String name;

private BlogCategoryVO parent;

private List<BlogCategoryVO> children;

private List<BlogEntityVO> entities;

public List<BlogEntityVO> getEntities() {
	return entities;
}

public void setEntities(List<BlogEntityVO> entities) {
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

public BlogCategoryVO getParent() {
	return parent;
}

public void setParent(BlogCategoryVO parent) {
	this.parent = parent;
}

public List<BlogCategoryVO> getChildren() {
	return children;
}

public void setChildren(List<BlogCategoryVO> children) {
	this.children = children;
}

}
