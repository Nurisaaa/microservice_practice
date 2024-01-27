package org.example;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
@CrossOrigin
public class ProductApi {

    private final ProductService productService;

//    @PostAuthorize("hasAuthority('ADMIN')")
//    @PostMapping
//    SimpleResponse saveProduct(@RequestBody ProductRequest productRequest) throws IOException {
//        return productService.save(productRequest);
//    }
//
////    @PostAuthorize("hasAuthority('ADMIN')")
//    @DeleteMapping("/{id}")
//    SimpleResponse deleteProduct(@PathVariable Long id) {
//        return productService.delete(id);
//    }
//
//    @PostAuthorize("hasAuthority('ADMIN')")
//    @PutMapping("/{id}")
//    SimpleResponse updateProduct(@RequestBody ProductRequest productRequest, @PathVariable Long id) throws IOException {
//        return productService.update(productRequest, id);
//    }
//
//    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENT')")
//    @GetMapping("/{id}")
//    ProductResponse findById(@PathVariable Long id) {
//        return productService.findById(id);
//    }
//
//    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENT')")
//    @GetMapping
//    List<ProductResponse> findAll(@RequestParam(required = false) String category, @RequestParam(required = false) String size) {
//        return productService.findAll(category, size);
//    }
//
//    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENT')")
//    @PostMapping("/favorites")
//    SimpleResponse addOrRemoveFromFavorites(@RequestParam Long id) {
//        return productService.addOrRemoveFromFavorites(id);
//    }
//
//    @PreAuthorize("hasAuthority('CLIENT')")
//    @GetMapping("/favorites")
//    List<ProductResponse> getFavorites() {
//        return productService.getFavorites();
//    }
//
//    @PreAuthorize("hasAuthority('CLIENT')")
//    @GetMapping("/basket")
//    List<ProductResponse> getBasket(){
//        return productService.getBasket();
//    }
//
//    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENT')")
//    @PostMapping("/basket")
//    SimpleResponse addOrRemoveFromBasket(@RequestParam Long id) {
//        return productService.addOrRemoveFromBasket(id);
//    }
}
