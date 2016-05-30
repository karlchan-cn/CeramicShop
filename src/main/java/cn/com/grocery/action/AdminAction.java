/**
 * 
 */
package cn.com.grocery.action;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author karl
 *
 */
@Controller
@RequestMapping(value = { "/admin/console/" })
public class AdminAction implements InitializingBean {
	private static final Logger logger = LoggerFactory.getLogger(AdminAction.class);

	/**
	 * @return
	 * @throws InterruptedException
	 */
	@RequestMapping(value = "/index", method = { RequestMethod.GET })
	public ModelAndView index() throws InterruptedException {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(30000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		ModelAndView mav = new ModelAndView("/admin/console/index");
		return mav;
	}
	public static void main(String[] args) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		int idx = 0;
		for(;idx < 3000;idx++){
			HttpGet httpGet = new HttpGet("http://localhost:8090/admin/console/index");
			CloseableHttpResponse response1 = httpclient.execute(httpGet);
			response1.close();
		}		
	}

	@Override
	public void afterPropertiesSet() throws Exception {

	}
}
