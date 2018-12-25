package training.training.controller.wrapper;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonSerialize
public class WrapperObj<T> {
    private T data;

    public WrapperObj() {
    }

    public WrapperObj(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString(){
        return "{data:" + data.toString() + "}";
    }
}
