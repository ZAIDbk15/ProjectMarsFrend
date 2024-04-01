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
import org.primefaces.PrimeFaces;
import org.primefaces.context.PrimeRequestContext;

@ManagedBean(name = "userProduit", eager = true)
@SessionScoped
public class UserProduit {

    private final String restResource ="http://localhost:8080/ProjectMarsBcEnd/api/produits";
    Produit[] listProduit;
    private  String result="tesst";

    private Produit selectedProduit;
    private List<Produit> filteredProduit;
    private List<Categorie> allCategories;
    private String key;

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
    public  void searchQuery(){

        try {

            CloseableHttpClient client= HttpClients.createDefault();
            if (!key.equals("")){
                HttpGet request=new HttpGet(restResource+"/keyword/"+key);
                result=client.execute(request,new BasicHttpClientResponseHandler());
                ObjectMapper objectMapper = new ObjectMapper();
                listProduit = objectMapper.readValue(result, Produit[].class);
                //PrimeRequestContext.getCurrentInstance().i("form:productsGrid");
            }else{
                getAllProduit();
            }

            System.out.println(listProduit.length);
        } catch (Exception e) {
            System.out.println("Errure lore de l'execute de getAllUsers \n"+e);
        }


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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
/*    public void getAllProduit() {
        try {
            HttpGet request = new HttpGet(restResource);
            CloseableHttpClient client = HttpClients.createDefault();
            result = client.execute(request, new BasicHttpClientResponseHandler());
            JSONArray jsonArray = new JSONArray(result);
            listProduit.clear();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Produit produit = new Produit();
                produit.setId(jsonObject.getInt("id"));
                produit.setDesignation(jsonObject.getString("designation"));
                produit.setPrix(jsonObject.getFloat("prix"));
                produit.setQuantite(jsonObject.getInt("quantite"));
                produit.setPhoto(jsonObject.getString("photo"));
                produit.setSdr(jsonObject.getInt("sdr"));
                System.out.println(produit);
                listProduit.add(produit);

            }
        } catch (Exception e) {
            System.out.println("Erreur lors de l'execution de getAllUsers:\n" + e);
        }
    }*/