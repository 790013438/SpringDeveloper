package cn.pzhu.spring.config;

import com.alibaba.fastjson.JSONObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;

@Configuration
public class SortOrResponseBeanConfiguration {

    @Bean
    Sort idASCSort() {
        return new Sort(Sort.Direction.ASC, "id");
    }

    @Bean
    JSONObject failJSONObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", false);
        return jsonObject;
    }
}
