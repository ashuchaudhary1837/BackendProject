package sample.webmvc.confuguration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;

public class WebApplicationConfiguration implements WebApplicationInitializer{
	
	@Override
	public void onStartup(ServletContext ctx)throws ServletException
	{
		AnnotationConfigWebApplicationContext annWebconfig=new AnnotationConfigWebApplicationContext();
		annWebconfig.register(SpringConfiguration.class);
		annWebconfig.setServletContext(ctx);
		ServletRegistration.Dynamic servlet=ctx.addServlet("dispatcher",new DispatcherServlet(annWebconfig));
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
		
	}

}
