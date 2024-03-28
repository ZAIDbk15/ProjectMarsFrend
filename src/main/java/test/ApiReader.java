package test;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Produit;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;;

import java.util.List;

public class ApiReader {

    public List<Produit> readApi(String apiUrl) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Produit> produits = null;

        try {
            // Read JSON data from the API URL
            Produit[] produitsArray = objectMapper.readValue(new URL(apiUrl), Produit[].class);
            produits = Arrays.asList(produitsArray);
        } catch (IOException e) {
            // Handle IO exception (e.g., network error, JSON parsing error)
            e.printStackTrace();
        }

        return produits;
    }

    public static void main(String[] args) {
        ApiReader apiReader = new ApiReader();
        String apiUrl = "http://localhost:8080/ProjectMarsBcEnd/api/produits/getAll"; // Replace with your actual API URL
        List<Produit> produits = apiReader.readApi(apiUrl);

        if (produits != null) {
            // Print the list of products
            for (Produit produit : produits) {
                System.out.println(produit);

            }
        } else {
            System.out.println("Failed to fetch products from the API.");
        }
    }
}
