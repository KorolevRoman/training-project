package training.training.controller;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import training.training.view.EmployeeView;
import training.training.view.OfficeView;
import training.training.view.OrganizationView;

@ControllerAdvice
public class ResponseBodyController implements ResponseBodyAdvice<Object>{
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (o instanceof OrganizationView || o instanceof OfficeView || o instanceof EmployeeView){
            return new WrapperObj<>(o);
        } else {
            return new WrapperError<>(o);
        }
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    @JsonSerialize
    private class WrapperObj<T> {
        private final Object data;

        public WrapperObj(Object data) {
            this.data = data;
        }
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    @JsonSerialize
    private class WrapperError<T> {
        private final Object error;

        public WrapperError(Object error) {
            this.error = error.toString();
        }
    }

}
