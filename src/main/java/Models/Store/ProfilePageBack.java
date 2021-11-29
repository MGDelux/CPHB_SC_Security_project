package Models.Store;


import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

public class ProfilePageBack {


    private Long userID;
    private String userName;
    private String emailAdress;
    private Byte[] profilePicture;
    private double storeCredit;

    public ProfilePageBack(){
    }

    public ProfilePageBack(String userName, String emailAdress, double storeCredit, Byte[] profilePicture){
        this.userName = userName;
        this.emailAdress = emailAdress;
        this.storeCredit = storeCredit;
        this.profilePicture = profilePicture;
    }


    //Se Profil

    //Ændre brugernavn

    //Se store credit eller ændre creditkort

    //Upload Profil billede (PUT metode) accepter et billede fra frontend og send til persistence
    //@PUT
    //@Produces(Mediatype.Byte)
    //@Consumes(Mediatype.Byte)
    //@Path()


}
