package test.basic;

import java.util.List;

import infra.ProductDAO;
import model.basic.Product;

public class GetProducts {

    public static void main(String[] args) {

        ProductDAO dao = new ProductDAO();
        List<Product> products = dao.getAll();

        for (Product product : products) {
            System.out.println("ID: " + product.getId() + ", NOME: " + product.getName());
        }

        double finalPrice = products
                .stream()
                .map(p -> p.getPreco())
                .reduce(0.0, (t, p) -> t + p)
                .doubleValue();
        System.out.println("O valor total é R$ " + finalPrice);

        dao.close();
    }
}
