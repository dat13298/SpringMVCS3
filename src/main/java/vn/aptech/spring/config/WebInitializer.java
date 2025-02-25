package vn.aptech.spring.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {PersistenceJPAConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {WebConfig.class};//trả về các lớp cấu hình cho DispatcherServlet (Web Application Context).
    }

    @Override
    protected String[] getServletMappings() {// method xác định các URL pattern mà DispatcherServlet sẽ xử lý.
        return new String[] {"/"};//đây là URL pattern mặc định, nó sẽ xử lý tất cả các request.
    }
}
