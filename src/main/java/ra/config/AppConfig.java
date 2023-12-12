package ra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//Đánh dấu đây là lớp cấu hình, khi ứng dụng chạy đọc và nạp vào container
@Configuration
@EnableWebMvc
//scan các package để tìm các lớp trong package này đươc đánh dấu là @component, @controller, @service, @repository để khởi tạo đối tượng nạp vào container
@ComponentScan(basePackages = {"ra.controller","ra.serviceImp","ra.repositoryImp"})
public class AppConfig {
    //Cấu hình thư mục chứa các view
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        //set đường dẫn thư mục chứa các view
        resolver.setPrefix("/views/");
        //set loại file cua view
        resolver.setSuffix(".jsp");
        return resolver;
    }
}
