package com.matricula;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;

@Configuration
public class MongoConfig implements InitializingBean {
	
	@Autowired
	@Lazy
	private MappingMongoConverter mappingMongoConverter;
	
	@Override
	public void afterPropertiesSet() throws Exception{
		mappingMongoConverter.setTypeMapper(new DefaultMongoTypeMapper(null));
	}

	
	
}
