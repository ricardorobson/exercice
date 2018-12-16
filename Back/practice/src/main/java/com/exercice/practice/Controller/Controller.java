package com.exercice.practice.Controller;

import com.exercice.practice.model.Brand;
import com.exercice.practice.model.CategoryEnt;
import com.exercice.practice.model.Product;
import com.exercice.practice.model.Sale;
import com.exercice.practice.service.BrandService;
import com.exercice.practice.service.CategoryService;
import com.exercice.practice.service.ProductService;
import com.exercice.practice.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class Controller {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private SaleService saleService;

    @RequestMapping(value = "/category", method = RequestMethod.POST)
    public ResponseEntity<CategoryEnt> saveCategory(@RequestBody CategoryEnt category){
        return ResponseEntity.ok(categoryService.save(category));
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        return ResponseEntity.ok(productService.save(product));
    }

    @RequestMapping(value = "/product/category/{idProduct}/{idCategory}", method = RequestMethod.POST)
    public ResponseEntity<Product> setCategoryProduct(@PathVariable Integer idProduct,@PathVariable Integer idCategory){
        Product product = productService.findById(idProduct);
        CategoryEnt category = categoryService.findById(idCategory);

        product.setCategory(category);

        return ResponseEntity.ok(productService.save(product));
    }

    @RequestMapping(value = "/product/brand/{idProduct}/{idBrand}", method = RequestMethod.POST)
    public ResponseEntity<Product> addBrandProduct(@PathVariable Integer idProduct,@PathVariable Integer idBrand){
        Product product = productService.findById(idProduct);
        Brand brand = brandService.findById(idBrand);

        List<Brand> brandList = product.getBrand();
        brandList.add(brand);
        product.setBrand(brandList);

        return ResponseEntity.ok(productService.save(product));
    }

    @RequestMapping(value = "/brand", method = RequestMethod.POST)
    public ResponseEntity<Brand> saveBrand(@RequestBody Brand brand){
        return ResponseEntity.ok(brandService.save(brand));
    }

    @RequestMapping(value = "/sale/{idCategory}/{idProduct}/{idBrand}", method = RequestMethod.POST)
    public ResponseEntity<Sale> saveSale(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date, @PathVariable Integer idCategory, @PathVariable Integer idProduct, @PathVariable Integer idBrand){
        Sale sale=new Sale();
        sale.setDate(date);
        sale.setIdCategory(idCategory);
        sale.setIdProduct(idProduct);
        sale.setIdBrand(idBrand);
        return ResponseEntity.ok(saleService.save(sale));
    }

    @RequestMapping(value = "/sale/{idCategory}/{idProduct}/{idBrand}", method = RequestMethod.GET)
    public ResponseEntity<List<Sale>> getSales(@PathVariable Integer idCategory, @PathVariable Integer idProduct, @PathVariable Integer idBrand){
        return ResponseEntity.ok(saleService.findByAttrs(idCategory,idProduct,idBrand));
    }

    @RequestMapping(value = "/category/all", method = RequestMethod.GET)
    public ResponseEntity<List<CategoryEnt>> categoryAllNames(){
        List<CategoryEnt> cats = new ArrayList();
        Iterable<CategoryEnt> categoryList = categoryService.findAll();
        categoryList.forEach(category -> cats.add(category));
        return ResponseEntity.ok(cats);
    }

    @RequestMapping(value = "/product/all/{idCategory}", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> productAllNamesByCategory(@PathVariable Integer idCategory){
        List<Product> prods = new ArrayList();
        List<Product> products = new ArrayList();
        Iterable<Product> productList = productService.findAll();
        productList.forEach(product -> products.add(product));
        for(Product product:products){
            if(product.getCategory().getId()==idCategory){
                prods.add(product);
            }
        }
        return ResponseEntity.ok(prods);
    }

    @RequestMapping(value = "/brand/all/{idProduct}", method = RequestMethod.GET)
    public ResponseEntity<List<Brand>> brandAllNamesByProduct(@PathVariable Integer idProduct){
        List<Brand> bs = new ArrayList();
        List<Brand> brands = new ArrayList();
        Iterable<Brand> brandList = brandService.findAll();
        brandList.forEach(brand -> brands.add(brand));
        Product product = productService.findById(idProduct);
        for(Brand brand:brands){
            if(product.getBrand().contains(brand)){
                bs.add(brand);
            }
        }
        return ResponseEntity.ok(bs);
    }
}
