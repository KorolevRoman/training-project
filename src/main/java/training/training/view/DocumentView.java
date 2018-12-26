package training.training.view;

import javax.validation.constraints.NotEmpty;

public class DocumentView {

    public Integer id;

    @NotEmpty
    public String number;

    @NotEmpty
    public String dateIssue;

    public Integer codeOfDocument;

    public String typeOfDocument;


    public DocumentView() {
    }

    public DocumentView(String number, String dateIssue, Integer codeOfDocument) {
        this.number = number;
        this.dateIssue = dateIssue;
        this.codeOfDocument = codeOfDocument;
    }
}
