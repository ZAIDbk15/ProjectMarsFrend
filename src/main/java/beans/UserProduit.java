package beans;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Categorie;
import model.Produit;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.BasicHttpClientResponseHandler;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "userProduit", eager = true)
@SessionScoped
public class UserProduit {

    private final String restResource ="http://localhost:8080/ProjectMarsBcEnd/api/produits";
    Produit[] listProduit;
    private  String result="tesst";
    private  String key;
    private Produit selectedProduit;
    private List<Produit> filteredProduit;
    private List<Categorie> allCategories;

    public  void getAllProduit(){

        try {

            CloseableHttpClient client= HttpClients.createDefault();
            HttpGet request=new HttpGet(restResource);
            result=client.execute(request,new BasicHttpClientResponseHandler());
            ObjectMapper objectMapper = new ObjectMapper();
            listProduit = objectMapper.readValue(result, Produit[].class);
            System.out.println(listProduit);
        } catch (Exception e) {
            System.out.println("Errure lore de l'execute de getAllUsers \n"+e);
        }


    }
    public void searchQuery() {
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            if (key != null && !key.equals("")) {
                HttpGet request=new HttpGet(restResource+"/keyword/"+key);
                result=client.execute(request,new BasicHttpClientResponseHandler());
                ObjectMapper objectMapper = new ObjectMapper();
                listProduit = objectMapper.readValue(result, Produit[].class);
            }else{
                getAllProduit();
            }
            System.out.println(listProduit.length);
        } catch (Exception e) {
            System.out.println("Error during searchQuery execution: " + e);
        }
    }


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getRestResource() {
        return restResource;
    }

    public Produit[] getListProduit() {
        return listProduit;
    }

    public void setListProduit(Produit[] listProduit) {
        this.listProduit = listProduit;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Produit getSelectedProduit() {
        return selectedProduit;
    }

    public void setSelectedProduit(Produit selectedProduit) {
        this.selectedProduit = selectedProduit;
    }

    public List<Produit> getFilteredProduit() {
        return filteredProduit;
    }

    public void setFilteredProduit(List<Produit> filteredProduit) {
        this.filteredProduit = filteredProduit;
    }

    public List<Categorie> getAllCategories() {
        return allCategories;
    }

    public void setAllCategories(List<Categorie> allCategories) {
        this.allCategories = allCategories;
    }
}