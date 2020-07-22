package pl.patryk.wine.service.impl;

import com.vaadin.flow.server.VaadinServlet;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class BeansSupplier {
    public static <T> T get(Class<T> serviceType) {
        return WebApplicationContextUtils
                .getWebApplicationContext(VaadinServlet.getCurrent().getServletContext())
                .getBean(serviceType);
    }
}
