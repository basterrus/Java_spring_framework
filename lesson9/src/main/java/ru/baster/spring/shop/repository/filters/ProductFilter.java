package ru.baster.spring.shop.repository.filters;

import lombok.Getter;
import org.springframework.data.jpa.domain.Specification;
import ru.baster.spring.shop.models.Product;
import ru.baster.spring.shop.repository.specification.ProductSpecifications;

import java.util.Map;

@Getter
public class ProductFilter {
    private Specification<Product> spec;
    private String filterDefinition;

    public ProductFilter(Map<String, String> params) {
        StringBuilder filterDefinitionBuilder = new StringBuilder();
        spec = Specification.where(null);

        String filterTitle = params.get("name");
        if (filterTitle != null && !filterTitle.isBlank()) {
            spec = spec.and(ProductSpecifications.titleLike(filterTitle));
            filterDefinitionBuilder.append("&name=").append(filterTitle);
        }

        if (params.containsKey("minPrice") && !params.get("minPrice").isBlank()) {
            Integer minPrice = Integer.parseInt(params.get("minPrice"));
            spec = spec.and(ProductSpecifications.priceGreaterOrEqualsThan(minPrice));
            filterDefinitionBuilder.append("&minPrice=").append(minPrice);
        }

        if (params.containsKey("maxPrice") && !params.get("maxPrice").isBlank()) {
            Integer maxPrice = Integer.parseInt(params.get("maxPrice"));
            spec = spec.and(ProductSpecifications.priceLesserOrEqualsThan(maxPrice));
            filterDefinitionBuilder.append("&maxPrice=").append(maxPrice);
        }

        filterDefinition = filterDefinitionBuilder.toString();
    }
}