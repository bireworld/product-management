package labs.pm.data;

import java.math.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
//import java.math.RoundingMode.HALF_UP;
import static labs.pm.data.Rating.*;

public abstract class Product {
    public static final BigDecimal DISCOUNT_RATE=BigDecimal.valueOf(0.1);
    private  int id;
    private String name;
    private BigDecimal price;
    private Rating rating;

//     Product(){
//        this(0,"no name",BigDecimal.ZERO);
//    }
     Product(int id, String name, BigDecimal price, Rating rating) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }
     Product(int id, String name, BigDecimal price) {
    this(id, name, price, NOT_RATED);
    }


    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }
//    public void setName(String name) {
//        this.name = name;
//    }

    public BigDecimal getPrice() {
        return price;
    }
//    public void setPrice(final BigDecimal price) {
//        //price = BigDecimal.ONE;
//        this.price = price;
//    }
    public BigDecimal getDiscount() {
        return price.multiply(DISCOUNT_RATE).setScale(2,RoundingMode.HALF_UP);
    }

    public Rating getRating() {
        return rating;
    }
    public abstract Product applyRating(Rating newRating);
//    {
//        return new Product(this.id,this.name,this.price,newRating);
//
//    }
    public LocalDate getBestBefore(){
        return LocalDate.now();
    }

    @Override
    public String toString() {
        return id+", "+name+", "+price+", "+getDiscount()+", "+rating.getStars()+", "+getBestBefore();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return id == product.id && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
