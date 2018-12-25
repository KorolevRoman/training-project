package training.training.view;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.validation.constraints.NotNull;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonSerialize
public class ResultView {
    @NotNull
    public Object result;

    public ResultView() {
    }

    public ResultView(@NotNull String result) {
        this.result = result;
    }

    @Override
    public String toString(){
        return "result: " + result;
    }
}
