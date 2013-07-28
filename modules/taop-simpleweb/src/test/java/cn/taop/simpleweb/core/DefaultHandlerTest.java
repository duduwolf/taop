package cn.taop.simpleweb.core;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.easymock.classextension.EasyMock;
import org.junit.Test;

import cn.taop.container.ContainerFactory;
import cn.taop.simpleweb.Constants;
import cn.taop.simpleweb.Handler;
import cn.taop.simpleweb.SimpleWebServlet;


public class DefaultHandlerTest {

	@Test
	public void testHandle() {
		SimpleWebServlet simple = new SimpleWebServlet();
		ServletConfig config = EasyMock.createMock(ServletConfig.class);
		try {
			simple.init(config);
		} catch (ServletException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		
		Handler handler = ContainerFactory.getContainer(Constants.SIMPLEWEB_CODE).getBean(Handler.class);
		try {
			handler.handle(null, null);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
