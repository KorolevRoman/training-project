package training.training.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "Document_type")
public class TypeOfDocument {

    @Id
    @Column
    private Integer code;

    @Column
    private String name;

    @OneToMany(
            mappedBy = "typeOfDocument",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Document> documents;

    public Set<Document> getDocuments() {
        return documents;
    }

    public void addDocument(Document document){
        getDocuments().add(document);
        document.setTypeOfDocument(this);
    }

    public void removeDocument(Document document){
        getDocuments().remove(document);
        document.setTypeOfDocument(null);
    }

    public String getName() {
        return name;
    }

    public Integer getCode() {
        return code;
    }
}
