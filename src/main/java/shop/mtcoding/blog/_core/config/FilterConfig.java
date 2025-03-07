package shop.mtcoding.blog._core.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import shop.mtcoding.blog._core.filter.CorsFilter;

@RequiredArgsConstructor
@Configuration
public class FilterConfig {
    private final CorsFilter corsFilter;

    @Bean(name = "CustomCors")
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        System.out.println("CORS 필터 등록");
//        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter()); // 이렇게 뉴해서 넣으면 밸류가 안 들어가
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(corsFilter);
        bean.addUrlPatterns("/*");
        bean.setOrder(0); // 낮은 번호부터 실행됨.
        return bean;
    }
}