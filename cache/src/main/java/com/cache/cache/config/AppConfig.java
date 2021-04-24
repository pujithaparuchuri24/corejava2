package com.cache.cache.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MaxSizeConfig;



@Configuration

public class AppConfig {
	@Bean
	public Config cacheconfig() throws Exception
	{
		return  new Config().setInstanceName("hazelxast-instance").
				addMapConfig(  new MapConfig().
						setName("stud-cache").
						setTimeToLiveSeconds(2000)
					//	setMaxSizeConfig(new MaxSizeConfig(200,MaxSizeConfig.
							//	MaxSizePolicy.FREE_HEAP_SIZE)).
					//	setEvictionPolicy(EvictionPolicy.LRU)
						
						     );
					}



}
