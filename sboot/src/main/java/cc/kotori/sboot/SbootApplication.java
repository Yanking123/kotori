package cc.kotori.sboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling//启用定时任务
public class SbootApplication extends SpringBootServletInitializer
{
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SbootApplication.class);
    }
	
	public static void main(String[] args) 
	{
		SpringApplication.run(SbootApplication.class, args);
	}
}
