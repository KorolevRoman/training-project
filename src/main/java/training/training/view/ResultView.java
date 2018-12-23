package training.training.view;

import javax.validation.constraints.NotNull;

public class ResultView {
    @NotNull
    public String result;

    public ResultView(@NotNull String result) {
        this.result = result;
    }

    @Override
    public String toString(){
        return "result:" + result;
    }
}
