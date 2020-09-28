package test.common;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.core.RedisTemplate;

@Ignore
public class TestRedis extends JUnitConfig {

    @Autowired
    @Qualifier("redisTemplate")
    RedisTemplate<Object, Object> redisTemplate;

    @Test
    public void getOauth2Token() {

	redisTemplate.getConnectionFactory();
	redisTemplate.opsForValue().set("A", "AAAAAAAA");
    }

}
