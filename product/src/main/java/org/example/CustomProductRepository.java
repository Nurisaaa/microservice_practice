package org.example;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomProductRepository {
    private final JdbcTemplate jdbcTemplate;

    public CustomProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ProductResponse> getProducts(String category, String size) {
        String condition = "";
        if (category == null && size == null){
            condition = "";
        } else if (category == null && size != null){
            condition = String.format("WHERE ps.sizes = '%s'", size);
        } else if (category != null && size == null){
            condition = String.format("WHERE p.category = '%s'", category);
        } else if (category != null && size != null){
            condition = String.format("WHERE p.category = '%s' AND ps.sizes = '%s'", category, size);
        }


        String sql = """
                SELECT p.id as id,
                       p.title as title,
                       p.price as price,
                       p.image as image,
                       p.category as category,
                       p.color as color,
                       p.date_of_creation as dateOfCreation
                FROM products p
                LEFT JOIN product_sizes as ps ON p.id = ps.product_id
                """ + condition + """
                GROUP BY p.id
                ORDER BY p.date_of_creation DESC
        """;

        List<ProductResponse> productResponse = jdbcTemplate.query(
                sql,
                (resultSet, row) -> ProductResponse.builder()
                        .id(resultSet.getLong("id"))
                        .title(resultSet.getString("title"))
                        .price(resultSet.getInt("price"))
                        .image(resultSet.getString("image"))
                        .category(resultSet.getString("category"))
                        .color(resultSet.getString("color"))
                        .dateOfCreation(resultSet.getDate("dateOfCreation").toLocalDate())
                        .build()
        );

        String getSizes = """
                SELECT sizes FROM product_sizes WHERE product_id = ?
        """;

        for (ProductResponse response : productResponse) {
            List<String> sizes = jdbcTemplate.query(getSizes, (resultSet, row) ->
                            resultSet.getString("sizes"),
                    response.getId()
            );
            response.setSizes(sizes);
        }

        return productResponse;
    }

    public List<ProductResponse> getFavorites(Long userId){
        String sql = """
                SELECT p.id as id,
                       p.title as title,
                       p.price as price,
                       p.image as image
                       p.category as category,
                       p.color as color,
                       p.date_of_creation as dateOfCreation
                       FROM products p join users_favorites f on p.id = f.favorites_id
                       WHERE f.user_id = ?
                       ORDER BY p.date_of_creation DESC
                """;
        List<ProductResponse> productResponse = jdbcTemplate.query(sql, (resultSet, row) -> ProductResponse.builder()
                .id(resultSet.getLong("id"))
                .title(resultSet.getString("title"))
                .image(resultSet.getString("image"))
                .price(resultSet.getInt("price"))
                .category(resultSet.getString("category"))
                .color(resultSet.getString("color"))
                .dateOfCreation(resultSet.getDate("dateOfCreation").toLocalDate())
                .build(), userId);

        String getSizes = """
                SELECT sizes FROM product_sizes WHERE product_id = ?
        """;

        for (ProductResponse response : productResponse) {
            List<String> sizes = jdbcTemplate.query(getSizes, (resultSet, row) ->
                            resultSet.getString("sizes"),
                    response.getId()
            );
            response.setSizes(sizes);
        }
        return productResponse;
    }

    public List<ProductResponse> getBasket(Long userId){
        String sql = """
                SELECT p.id as id,
                       p.title as title,
                       p.price as price,
                       p.image as image
                       p.category as category,
                       p.color as color,
                       p.date_of_creation as dateOfCreation,
                       FROM products p join users_baskets b on p.id = b.baskets_id
                       WHERE b.user_id = ?
                       GROUP BY p.id
                       ORDER BY p.date_of_creation DESC
                """;
        List<ProductResponse> productResponse = jdbcTemplate.query(sql, (resultSet, row) -> ProductResponse.builder()
                .id(resultSet.getLong("id"))
                .title(resultSet.getString("title"))
                .image(resultSet.getString("image"))
                .price(resultSet.getInt("price"))
                .category(resultSet.getString("category"))
                .color(resultSet.getString("color"))
                .dateOfCreation(resultSet.getDate("dateOfCreation").toLocalDate())
                .build(), userId);

        String getSizes = """
                SELECT sizes FROM product_sizes WHERE product_id = ?
        """;

        for (ProductResponse response : productResponse) {
            List<String> sizes = jdbcTemplate.query(getSizes, (resultSet, row) ->
                            resultSet.getString("sizes"),
                    response.getId()
            );
            response.setSizes(sizes);
        }
        return productResponse;
    }
}
