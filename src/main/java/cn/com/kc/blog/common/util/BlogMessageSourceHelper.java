package cn.com.kc.blog.common.util;

import javax.annotation.Resource;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

/**
 * Blog message helper class.
 * 
 * @author kchen1
 * 
 */
@Component("cn.com.kc.blog.common.util.BlogMessageSourceHelper")
@Scope("singleton")
public class BlogMessageSourceHelper {

@Resource(name = "messageSource")
private MessageSource messageSource;

public MessageSource getMessageSource() {
	return messageSource;
}

private MessageSourceAccessor messageSourceAccessor;

/**
 * method get message source accessor.
 * 
 * @return MessageSourceAccessor
 */
public MessageSourceAccessor getAccessor() {
	if (messageSourceAccessor == null)
		messageSourceAccessor = new MessageSourceAccessor(getMessageSource());
	return messageSourceAccessor;
}

}
