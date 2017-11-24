package ru.babaets.databaseinterface.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import ru.babaets.databaseinterface.dao.KillerDAO;
import ru.babaets.databaseinterface.dao.KillerDAOImpl;
import ru.babaets.databaseinterface.dao.MurderDAO;
import ru.babaets.databaseinterface.dao.MurderDAOImpl;
import ru.babaets.databaseinterface.dao.MurderWithKillerDAO;
import ru.babaets.databaseinterface.dao.MurderWithKillerDAOImpl;

@Configuration
@ComponentScan(basePackages="ru.babaets.databaseinterface")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter{

	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(AdminInfo.DB_DRIVER);
		dataSource.setUrl(AdminInfo.DB_URL);
		dataSource.setUsername(AdminInfo.DB_USER);
		dataSource.setPassword(AdminInfo.DB_PASS);
		return dataSource;
	}
	
	@Bean
	public MurderDAO getMurderDAO() {
		return new MurderDAOImpl(getDataSource());
	}
	
	@Bean
	public KillerDAO getKillerDAO() {
		return new KillerDAOImpl(getDataSource());
	}
	
	@Bean
	public MurderWithKillerDAO getMurderWithKillerDAO() {
		return new MurderWithKillerDAOImpl(getDataSource());
	}
}
