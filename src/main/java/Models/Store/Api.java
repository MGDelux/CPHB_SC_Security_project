package Models.Store;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * CREATED BY mathias @ 29-11-2021 - 12:13
 **/
@Entity(name = "API_KEY")
public class Api {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "API_ID")
    private Long id;
    String apikey;

    public Api() {
    }

    public Api(String apikey) {
        this.apikey = apikey;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }
}
