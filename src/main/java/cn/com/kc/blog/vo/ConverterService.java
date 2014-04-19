package cn.com.kc.blog.vo;

import java.io.Serializable;

public interface ConverterService<P extends Serializable, V extends Serializable> {

void convertPoToVo(P po, V vo);

void convertVoToPo(P po, V vo);
}
